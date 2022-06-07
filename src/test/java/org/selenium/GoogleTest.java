package org.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

/**
 * @author dendy
 * @Date 05/06/2022
 * @Time 23.19
 * Description :
 */
public class GoogleTest {


    @Test
    public void search() {
        System.out.println("Inside Step - Buka Browser");
        System.setProperty("webdriver.edge.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("driver/msedgedriver.exe")).getFile());
        EdgeDriver  driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); //connect
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //page / obj

        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Dendy senapartha");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
        driver.findElement(By.name("q")).submit();
    }

    @Test
    public void lms() {
        System.out.println("Inside Step - Buka Browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader().getResource("driver/chromedriver.exe")).getFile());
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); //connect
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); //page / obj

        driver.navigate().to("https://lms.ukdw.ac.id/login/index.php");
        driver.findElement(By.name("username")).sendKeys("dendy.prtha");
        driver.findElement(By.name("password")).sendKeys("D3nd1001*");
        driver.findElement(By.id("loginbtn")).submit();
    }
}
