package selenium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListarVeterinarioTest extends BaseTest {

    @Test
    public void deveListarVeterinariosNaTabela() {
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Nome"));
        assertTrue(pageSource.contains("CRMV"));
        assertTrue(pageSource.contains("Especialidade"));
    }
}