package org.selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * @author dendy
 * @Date 06/06/2022
 * @Time 16.03
 * Description :
 */
public class LoginTest {

    ChromeDriver driver;

    @Given("browser opened")
    public void browser_opened() {
        System.out.println("Inside Step - Buka Browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                        .getResource("driver/chromedriver.exe")).getFile());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); //connect
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //page / obj
    }

    @Given("user in login page")
    public void user_in_login_page() {
        System.out.println("Inside Step - user ada di halaman login");
        driver.navigate().to("https://demo.guru99.com/Agile_Project/Agi_V1/");
    }

    @When("user insert username and password")
    public void user_insert_username_and_password() {
        System.out.println("Inside Step - Ada di fungsi user memasukkan username dan password");
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
    }


    @When("login button clicked")
    public void login_button_clicked() {
        System.out.println("Inside Step - ada di fungsi klik tombol Login");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        System.out.println("Inside Step - ada di halaman user diarahkan ke halaman utama");
        List<WebElement> list = driver.findElements(By
                .xpath("//*[contains(text(),'" + "Log out" + "')]"));
        Assertions.assertTrue(list.size() > 0, "Text not found!");
        driver.close();
        driver.quit();
    }
}
