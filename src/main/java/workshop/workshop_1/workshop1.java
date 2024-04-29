package workshop.workshop_1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;


import java.io.IOException;
import java.util.List;

import static org.openqa.selenium.By.id;

public class workshop1 {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 10 adet selenium hazır fonksiyonu kullanım örneği ve
        // örneklerin üzerinde fonksiyonun işlevinin anlatıldığı yorum satırını içeren kodları yazınız.

        WebDriver webDriver = new ChromeDriver();
        webDriver.navigate().to(globalConstants.BASE_URL);
        String title = webDriver.getTitle();
        System.out.println(title);


        WebElement usernameInput =webDriver.findElement(id(globalConstants.USERNAME));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput =webDriver.findElement(id(globalConstants.PSW));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(5000);

        WebElement loginButton = webDriver.findElement(id(globalConstants.LOGIN_BTN));
        //buton tıklama yapar.
        loginButton.click();

        //Belirli bir sayfadaki metni kontrol etme , Xpathe göre
        WebElement element = webDriver.findElement(By.xpath(globalConstants.PRODUCTS));
            if (element.getText().equals("Products")) {
                System.out.println("Yan baslik  dogru");}
                else 
                System.out.println("Yan baslik yanlis");

        // sayfa yenileme için kullanılır.
        webDriver.navigate().refresh();
        Thread.sleep(2000);

        // önceki sayfaya gitmek için kullanılır.
        webDriver.navigate().back();
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);

        //sonraki sayfaya git
        webDriver.navigate().forward();
        String currentUrl1 = webDriver.getCurrentUrl();
        System.out.println(currentUrl1);

        //Mevcut sayanın urlini alır.
        String currentUrl2 = webDriver.getCurrentUrl();
        System.out.println(currentUrl2);

        //pencereyi tam ekran yapma
        webDriver.manage().window().maximize();

        //sayfanın ekran görüntüsü alma
        File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("workshop1.png"));

        //Giriş ekranında tüm ürünleri görüntüleme
        List<WebElement> products = webDriver.findElements(By.className("inventory_item"));
        /* ürünlerin adını yazdır
        for (WebElement product : products) {
           System.out.println(product.getText());
         } */
        // Ürünlerin sayısını yazdırma
        int productCount = products.size();
        System.out.println("Ürün sayısı: " + productCount);

        //ürünleri adan zye siralama dropdown menüye tıklama yapılarak.
        WebElement dropdownMenu = webDriver.findElement(By.className(globalConstants.DROPDOWN_MENU));
        dropdownMenu.click();
        Thread.sleep(2000);
        WebElement zaSort = webDriver.findElement(By.xpath(globalConstants.ZA_SORT));
        zaSort.click();
        Thread.sleep(2000);

        //sayfayı kapatır.
        webDriver.quit();




    }



}
