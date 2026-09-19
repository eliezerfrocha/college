package com.cod3r.gerenciadorfuncionarios;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VeterinarioSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/veterinarios/new");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testCadastrarVeterinario() throws InterruptedException {
        driver.findElement(By.id("nome")).sendKeys("Dr. Teste");
        driver.findElement(By.id("crmv")).sendKeys("12345");
        driver.findElement(By.id("telefone")).sendKeys("11999999999");

        driver.findElement(By.id("submit")).click(); // ou button[type=submit]

        Thread.sleep(1000); // esperar carregamento da página de retorno

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertTrue(bodyText.contains("Dr. Teste"), "Nome do veterinário não encontrado na página");
    }
}