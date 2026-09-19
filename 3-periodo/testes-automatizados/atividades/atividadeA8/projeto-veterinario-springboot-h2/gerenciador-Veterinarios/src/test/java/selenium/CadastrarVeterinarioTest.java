package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastrarVeterinarioTest extends BaseTest {

    @Test
    public void deveCadastrarVeterinarioComSucesso() {
        driver.findElement(By.linkText("Novo Veterinário")).click();

        driver.findElement(By.id("nome")).sendKeys("Dra. Camila Souza");
        driver.findElement(By.id("crmv")).sendKeys("99999");
        driver.findElement(By.id("especialidade")).sendKeys("Clínica Geral");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verificação
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Dra. Camila Souza"));
        assertTrue(pageSource.contains("99999"));
        assertTrue(pageSource.contains("Clínica Geral"));
    }
}