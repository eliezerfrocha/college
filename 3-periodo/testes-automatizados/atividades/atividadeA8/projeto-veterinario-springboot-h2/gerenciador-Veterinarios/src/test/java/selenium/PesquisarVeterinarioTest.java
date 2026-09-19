package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PesquisarVeterinarioTest extends BaseTest {

    @Test
    public void devePesquisarVeterinarioPorNome() {
        driver.findElement(By.id("filtro-nome")).sendKeys("Camila");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Dra. Camila Souza"));
    }
}