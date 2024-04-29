package org.etiya;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.id;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        String title = webDriver.getTitle();
        System.out.println(title);

        //Locator Elementlere ulaşmak için kulllanırız.
        WebElement usernameInput =webDriver.findElement(id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput =webDriver.findElement(id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(5000);

        WebElement loginButton = webDriver.findElement(id("login-button"));
        loginButton.click();

        Thread.sleep(5000);

        webDriver.quit();
    }
}