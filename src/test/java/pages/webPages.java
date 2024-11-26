package pages;

import static helper.Utility.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import helper.Models;
import helper.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class webPages {

    By clickSignUp = By.xpath("//*[@id=\"signin2\"]");
    By usernameInputSignUp = By.id("sign-username");
    By passwordInputSignUp = By.id("sign-password");
    By clickButtonSignUp = By.cssSelector("button[onclick='register()']");
    By clickLogin = By.id("login2");
    By usernameInputLogin = By.id("loginusername");
    By passwordInputLogin = By.id("loginpassword");
    By clickButtonLogin = By.cssSelector("button[onclick='logIn()']");
    By nameOfUser = By.cssSelector("#nameofuser");
    By productDetail = By.linkText("Samsung galaxy s6");
    By productDetail2nd = By.linkText("Nokia lumia 1520");
    By getProductDetail3rd = By.xpath("//a[normalize-space()='Sony xperia z5']");
    By addToCard = By.cssSelector(".btn.btn-success.btn-lg");
    By clickCart = By.xpath("//a[@id='cartur']");
    By clickPlaceOrder = By.xpath("//button[normalize-space()='Place Order']");
    By inputName = By.xpath("(//input[@id='name'])[1]");
    By inputCountry = By.cssSelector("#country");
    By inputCity = By.cssSelector("#city");
    By inputCreditCard = By.xpath("(//input[@id='card'])[1]");
    By inputMonth = By.cssSelector("#month");
    By inputYear = By.cssSelector("#year");
    By clickPurchase = By.cssSelector("button[onclick='purchaseOrder()']");
    By successCheckout = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");
    By laptopCategory = By.xpath("(//a[normalize-space()='Laptops'])[1]");
    By productLaptop = By.xpath("//a[normalize-space()='Sony vaio i5']");
    By clickHome = By.xpath("(//a[normalize-space()='PRODUCT STORE'])[1]");
    By clickLogout = By.xpath("(//a[normalize-space()='Log out'])[1]");


    public void openWebTest(){
        driver.get("https://www.demoblaze.com/");
    }

    public void userClickSignup() {
        driver.findElement(clickSignUp).click();
    }

    public void userInputValidUsernameSignup(){
        String generateUsername = Models.GenerateUsername();
        driver.findElement(usernameInputSignUp).sendKeys(generateUsername);
        Utility.saveUsername(generateUsername);
    }

    public void userInputValidPasswordSignup() {
        driver.findElement(passwordInputSignUp).sendKeys("123456789");
    }

    public void userClickButtonSignup() {
        driver.findElement(clickButtonSignUp).click();
    }

    public void userGetSuccessSignupAlert() {
        //ini digunakan untuk menunggu alert sukses nya muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //ini digunakan untuk switch ke alert nya dan klik ok/accept
        Alert alertObj = driver.switchTo().alert();
        String alertText = alertObj.getText();
        assert alertText.contains("Sign up successful.");
        alertObj.accept();
    }

    public void userGetSuccessAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        //ini digunakan untuk switch ke alert nya dan klik ok/accept
        Alert alertObj = driver.switchTo().alert();
        String alertText = alertObj.getText();
        assert alertText.contains("Product added.");
        alertObj.accept();
    }

    public void userClickLogin(){
        driver.findElement(clickLogin).click();
    }

    public void userInputValidUsernameLogin(){
        String loginUsername = Utility.getUsername();
        driver.findElement(usernameInputLogin).sendKeys(loginUsername);
    }

    public void userInputValidPasswordLogin(){
        driver.findElement(passwordInputLogin).sendKeys("123456789");
    }

    public void userClickButtonLogin(){
        driver.findElement(clickButtonLogin).click();
    }

    public void userCanSeeNameOfUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfUser));

        assertThat(driver.findElement(nameOfUser).isDisplayed()).isTrue();
    }

    public void userClickProduct() throws InterruptedException {
        // menggunakan driver wait kena error "stale element reference: stale element not found"
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(productDetail));
        Thread.sleep(1000);
        driver.findElement(productDetail).click();
    }

    public void userClickAddToCart(){
        driver.findElement(addToCard).click();
    }

    public void userClickCart(){
        driver.findElement(clickCart).click();
    }

    public void userClickPlaceOrder(){
        driver.findElement(clickPlaceOrder).click();
    }

    public void userInputPlaceholder(){
        driver.findElement(inputName).sendKeys("Testing 132");
        driver.findElement(inputCountry).sendKeys("Indonesia");
        driver.findElement(inputCity).sendKeys("Jakarta");
        driver.findElement(inputCreditCard).sendKeys("1957895122");
        driver.findElement(inputMonth).sendKeys("August");
        driver.findElement(inputYear).sendKeys("2024");

    }

    public void userClickPurchase(){
        driver.findElement(clickPurchase).click();
    }

    public void userGetSuccessMessageToOrder(String successMessage){
        new WebDriverWait(driver, Duration.ofSeconds(10));
        String actualSuccessMessage = driver.findElement(successCheckout).getText();
        assertEquals(successMessage, actualSuccessMessage);
    }

    public void userGetErrorMessage (String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        //ini digunakan untuk switch ke alert nya dan klik ok/accept
        Alert alertObj = driver.switchTo().alert();
        String alertText = alertObj.getText();
        assertEquals(alertText, errorMessage);
        alertObj.accept();
    }

    public void userClickCategoryLaptops() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(laptopCategory));
        Thread.sleep(1000);
        driver.findElement(laptopCategory).click();
    }

    public void userSuccessToChangeTheCategory() {
        assertThat(driver.findElement(productLaptop).isDisplayed()).isTrue();
    }

    public void userClickSecondProduct(){
        driver.findElement(productDetail2nd).click();
    }

    public void userClickThirdProduct(){
        driver.findElement(getProductDetail3rd).click();
    }

    public void userClickHome(){
        driver.findElement(clickHome).click();
    }

    public void userClickLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickLogout));
        driver.findElement(clickLogout).click();
    }

    public void userCanSeeButtonLogin(){
        assertThat(driver.findElement(clickLogin).isDisplayed()).isTrue();
    }
}
