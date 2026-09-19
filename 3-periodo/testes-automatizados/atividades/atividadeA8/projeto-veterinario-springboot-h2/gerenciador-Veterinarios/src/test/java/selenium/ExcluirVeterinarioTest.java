package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExcluirVeterinarioTest extends BaseTest {

    @Test
    public void deveExcluirVeterinarioComSucesso() {
        driver.findElement(By.linkText("Excluir")).click(); // pega o primeiro

        String pageSource = driver.getPageSource();
        assertFalse(pageSource.contains("Dra. Camila Atualizada")); // ou nome anterior
    }
}