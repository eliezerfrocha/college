package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlterarVeterinarioTest extends BaseTest {

    @Test
    public void deveAlterarVeterinarioComSucesso() {
        driver.findElement(By.linkText("Editar")).click(); // pega o primeiro

        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("Dra. Camila Atualizada");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Dra. Camila Atualizada"));
    }
}