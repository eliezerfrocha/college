package com.iftm.client.resources;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests (70 %) using the real Spring context + H2 database.
 * Covers all CRUD + custom search endpoints as required in the assignment.
 * <p>
 * You can copy‑paste this file into <code>src/test/java</code> and adapt the package
 * to match your project structure if necessary.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClientResourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    private Long existingId;
    private Long nonExistingId;
    private ClientDTO newClientDTO;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        Client maria = new Client(null, "Maria Brown", "12345678901", 4500.0,
                Instant.parse("1985-07-15T00:00:00Z"), 1);
        Client alex  = new Client(null, "Alex Green",  "98765432100", 3000.0,
                Instant.parse("1990-11-03T00:00:00Z"), 0);
        Client bob   = new Client(null, "Bob Grey",   "55566677788", 6500.0,
                Instant.parse("1975-02-28T00:00:00Z"), 3);
        repository.saveAll(List.of(maria, alex, bob));

        existingId    = maria.getId();
        nonExistingId = 999L;

        newClientDTO = new ClientDTO(null, "Clarice Lispector", "10919444522",
                3800.0, Instant.parse("1960-04-13T07:50:00Z"), 2);
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // GET /clients (paged)
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("findAll should return paged clients with correct size and content")
    void findAllShouldReturnPagedClients() throws Exception {
        mockMvc.perform(get("/clients")
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content", hasSize(3)))
               .andExpect(jsonPath("$.totalElements").value(3))
               .andExpect(jsonPath("$.content[?(@.name == 'Maria Brown')]").exists());
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // GET /clients/{id}
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("findById should return client when id exists")
    void findByIdShouldReturnClientWhenIdExists() throws Exception {
        mockMvc.perform(get("/clients/id/{id}", existingId)
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(existingId))
               .andExpect(jsonPath("$.name").value("Maria Brown"))
               .andExpect(jsonPath("$.cpf").value("12345678901"));
    }

    @Test
    @DisplayName("findById should return 404 when id does not exist")
    void findByIdShouldReturn404WhenIdDoesNotExist() throws Exception {
        mockMvc.perform(get("/clients/id/{id}", nonExistingId)
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.error").value("Resource not found"))
               .andExpect(jsonPath("$.path", org.hamcrest.Matchers.endsWith("/clients/" + nonExistingId)));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // GET /clients/income?income={value}
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("findByIncome should return clients with exact income")
    void findByIncomeShouldReturnMatchingClients() throws Exception {
        mockMvc.perform(get("/clients/income")
                        .param("income", "4500.0")
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content", hasSize(1)))
               .andExpect(jsonPath("$.content[0].name").value("Maria Brown"));
    }

    @Test
    @DisplayName("findByIncome should return empty content when no match")
    void findByIncomeShouldReturnEmptyWhenNoMatch() throws Exception {
        mockMvc.perform(get("/clients/income")
                        .param("income", "9999")
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content", hasSize(0)))
               .andExpect(jsonPath("$.totalElements").value(0));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // GET /clients/income/greaterThan?income={value}
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("findByIncomeGreaterThan should return clients with income greater than param")
    void findByIncomeGreaterThanShouldReturnClients() throws Exception {
        mockMvc.perform(get("/clients/income/greaterThan")
                        .param("income", "4000")
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content", hasSize(2)))
               .andExpect(jsonPath("$.content[*].income", everyItem(greaterThan(4000.0))));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // GET /clients/cpfLike?cpf={fragment}
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("findByCpfLike should return clients whose CPF contains fragment")
    void findByCpfLikeShouldReturnClients() throws Exception {
        mockMvc.perform(get("/clients/cpfLike")
                        .param("cpf", "555")
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.content", hasSize(1)))
               .andExpect(jsonPath("$.content[0].cpf").value("55566677788"));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // POST /clients (create)
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("insert should persist client and return created with body")
    void insertShouldCreateClient() throws Exception {
        String json = objectMapper.writeValueAsString(newClientDTO);

        ResultActions result = mockMvc.perform(post("/clients")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated())
              .andExpect(jsonPath("$.id").isNumber())
              .andExpect(jsonPath("$.name").value("Clarice Lispector"))
              .andExpect(jsonPath("$.cpf").value("10919444522"));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // PUT /clients/{id} (update)
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("update should modify client and return updated data when id exists")
    void updateShouldReturnClientWhenIdExists() throws Exception {
        newClientDTO.setName("Maria Carolina");
        newClientDTO.setIncome(4800.0);
        String json = objectMapper.writeValueAsString(newClientDTO);

        ResultActions result = mockMvc.perform(put("/clients/{id}", existingId)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
              .andExpect(jsonPath("$.id").value(existingId))
              .andExpect(jsonPath("$.name").value("Maria Carolina"))
              .andExpect(jsonPath("$.income").value(4800.0));
    }

    @Test
    @DisplayName("update should return 404 when id does not exist")
    void updateShouldReturn404WhenIdDoesNotExist() throws Exception {
        String json = objectMapper.writeValueAsString(newClientDTO);

        mockMvc.perform(put("/clients/{id}", nonExistingId)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.error").value("Resource not found"));
    }

    // ────────────────────────────────────────────────────────────────────────────────
    // DELETE /clients/{id}
    // ────────────────────────────────────────────────────────────────────────────────
    @Test
    @DisplayName("delete should remove client when id exists")
    void deleteShouldReturnNoContentWhenIdExists() throws Exception {
        mockMvc.perform(delete("/clients/{id}", existingId))
               .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("delete should return 404 when id does not exist")
    void deleteShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        mockMvc.perform(delete("/clients/{id}", nonExistingId))
               .andExpect(status().isNotFound());
    }
}

/* ────────────────────────────────────────────────────────────────────────────────
 * PART 2 – 30 % (MockBean + WebMvcTest)
 * -----------------------------------------------------------------------------
 * Lightweight tests using only the web layer and a mocked ClientService.
 * They execute much faster and isolate the controller behaviour.
 * -----------------------------------------------------------------------------*/
@WebMvcTest(ClientResource.class)
class ClientResourceWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("findById should return DTO when service returns data")
    void findByIdShouldDelegateToService() throws Exception {
        ClientDTO dto = new ClientDTO(1L, "Zelda Rocha", "11122233344", 5000.0,
                Instant.parse("1992-05-10T00:00:00Z"), 0);
        given(service.findById(1L)).willReturn(dto);

        mockMvc.perform(get("/clients/{id}", 1L))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Zelda Rocha"));
    }
}

