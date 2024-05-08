package workshop.workshop_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import workshop.workshop_1.globalConstants;


import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.id;

// Yazdığınız 10 adet fonksiyonu JUnit kullanarak test methodlarına çevirmeniz.

public class SwaglabsTests {

    WebDriver webDriver;

    @BeforeEach
    public void start()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to(globalConstants.BASE_URL);

        WebElement usernameInput = webDriver.findElement(id(globalConstants.USERNAME));
        usernameInput.sendKeys("standard_user");
        WebElement passwordInput = webDriver.findElement(id(globalConstants.PSW));
        passwordInput.sendKeys("secret_sauce");


        WebElement loginButton = webDriver.findElement(id(globalConstants.LOGIN_BTN));
        loginButton.click();
        webDriver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void exit() {
        webDriver.quit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sideTitle()
    {
        WebElement element = webDriver.findElement(By.xpath(globalConstants.PRODUCTS));
        if (element.getText().equals("Products")) {
            System.out.println("Yan baslik  dogru");}
        else
            System.out.println("Yan baslik yanlis");
    }

    @Test
    public void pageURL()
    {
        webDriver.navigate().refresh();

        webDriver.navigate().back();
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);
        webDriver.navigate().forward();
        String currentUrl1 = webDriver.getCurrentUrl();
        System.out.println(currentUrl1);
    }


    @Test
    public void az_List()
    {
        WebElement dropdownMenu = webDriver.findElement(By.className(globalConstants.DROPDOWN_MENU));
        dropdownMenu.click();
        WebElement zaSort = webDriver.findElement(By.xpath(globalConstants.ZA_SORT));
        zaSort.click();

    }

    @Test
    public void addToBasket()
    {
        WebElement item3  = webDriver.findElement(By.id(globalConstants.ITEM3_ID));
        item3.click();
        WebElement addToCart = webDriver.findElement(By.xpath(globalConstants.ADDTOCART));
        addToCart.click();
    }

    @Test
    public void menuLogout()
    {
        WebElement menuButton = webDriver.findElement(By.xpath(globalConstants.BUTTON_XPATH));
        menuButton.click();

        WebElement logout = webDriver.findElement(By.id(globalConstants.LOGOUT));
        logout.click();

        String expectedResult = "https://www.saucedemo.com/v1/index.html";
        String actualResult = webDriver.getCurrentUrl();

        Assertions.assertEquals(expectedResult, actualResult);

    }


}
