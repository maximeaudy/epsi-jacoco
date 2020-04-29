package pizza.spring.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzaSpringAcceptanceTest {

    private WebDriver webDriver;

    @Before
    public void createWebDriver() {
        webDriver = new ChromeDriver();
    }

    @After
    public void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    public void orderPizzaSuccess() throws Exception {
        webDriver.navigate().to("http://localhost:8080/pizza_spring_war/");

        WebElement menuBtn = webDriver.findElement(By.cssSelector("#menu > ul > li:nth-child(1) > a"));
        menuBtn.click();

        WebElement choicePizza = webDriver.findElement(By.cssSelector("#pizzaId > option:nth-child(1)"));
        choicePizza.click();

        WebElement enterName = webDriver.findElement(By.cssSelector("#nom"));
        enterName.sendKeys("maxime");

        WebElement enterNum = webDriver.findElement(By.cssSelector("#telephone"));
        enterNum.sendKeys("0671850954");

        WebElement clickOrder = webDriver.findElement(By.cssSelector("#commandeDto > button"));
        clickOrder.click();

        WebElement name = webDriver.findElement(By.cssSelector("body > div > ul:nth-child(1) > li:nth-child(1)"));
        assertEquals("good", "Nom : maxime", name.getText());
    }

    @Test
    public void orderWithoutPizza() throws Exception {
        webDriver.navigate().to("http://localhost:8080/pizza_spring_war/");

        WebElement menuBtn = webDriver.findElement(By.cssSelector("#menu > ul > li:nth-child(1) > a"));
        menuBtn.click();

        WebElement enterName = webDriver.findElement(By.cssSelector("#nom"));
        enterName.sendKeys("maxime");

        WebElement enterNum = webDriver.findElement(By.cssSelector("#telephone"));
        enterNum.sendKeys("0671850954");

        WebElement clickOrder = webDriver.findElement(By.cssSelector("#commandeDto > button"));
        clickOrder.click();

        WebElement error = webDriver.findElement(By.cssSelector("#pizzaId\\.errors"));
        assertEquals("good", "Vous devez choisir au moins une pizza", error.getText());
    }

    @Test
    public void orderPizzaWithoutPhoneNumber() throws Exception {
        webDriver.navigate().to("http://localhost:8080/pizza_spring_war/");

        WebElement menuBtn = webDriver.findElement(By.cssSelector("#menu > ul > li:nth-child(1) > a"));
        menuBtn.click();

        WebElement choicePizza = webDriver.findElement(By.cssSelector("#pizzaId > option:nth-child(1)"));
        choicePizza.click();

        WebElement enterName = webDriver.findElement(By.cssSelector("#nom"));
        enterName.sendKeys("maxime");

        WebElement clickOrder = webDriver.findElement(By.cssSelector("#commandeDto > button"));
        clickOrder.click();

        WebElement error = webDriver.findElement(By.cssSelector("#telephone\\.errors"));
        assertEquals("good", "ne peut pas être vide", error.getText());
    }

}