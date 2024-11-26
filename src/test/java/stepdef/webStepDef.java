package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.webPages;

public class webStepDef{
    webPages WebPages;

    public webStepDef(){
        this.WebPages = new webPages();
    }
    @Given("open web test")
    public void openWebTest() {
        WebPages.openWebTest();
    }

    @When("user click signup")
    public void userClickSignup() {
        WebPages.userClickSignup();
    }

    @And("user input valid username signup")
    public void userInputValidUsernameSignup() {
        WebPages.userInputValidUsernameSignup();
    }

    @And("user input valid password signup")
    public void userInputValidPasswordSignup() {
        WebPages.userInputValidPasswordSignup();
    }

    @And("user click button signup")
    public void userClickButtonSignup() {
        WebPages.userClickButtonSignup();
    }

    @Then("user get success signup alert")
    public void userGetSuccessSignupAlert() {
        WebPages.userGetSuccessSignupAlert();
    }

    @When("user click login")
    public void userClickLogin() {
        WebPages.userClickLogin();
    }

    @And("user input valid username login")
    public void userInputValidUsernameLogin() {
        WebPages.userInputValidUsernameLogin();
    }

    @And("user input valid password login")
    public void userInputValidPasswordLogin() {
        WebPages.userInputValidPasswordLogin();
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        WebPages.userClickButtonLogin();
    }

    @Then("user can see name of user")
    public void userCanSeeNameOfUser() {
        WebPages.userCanSeeNameOfUser();
    }

    @And("user click product")
    public void userClickProduct() throws InterruptedException {
        WebPages.userClickProduct();
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        WebPages.userClickAddToCart();
    }

    @And("user click cart")
    public void userClickCart() {
        WebPages.userClickCart();
    }

    @And("user click place order")
    public void userClickPlaceOrder() {
        WebPages.userClickPlaceOrder();
    }

    @And("user input placeholder")
    public void userInputPlaceholder() {
        WebPages.userInputPlaceholder();
    }

    @And("user click purchase")
    public void userClickPurchase() {
        WebPages.userClickPurchase();
    }

    @Then("user get success message to order {string}")
    public void userGetSuccessMessageToOrder(String successMessage) {
        WebPages.userGetSuccessMessageToOrder(successMessage);
    }

    @Then("user get success alert")
    public void userGetSuccessAlert() {
        WebPages.userGetSuccessAlert();
    }

    @Then("user get error message {string}")
    public void userGetErrorMessage(String errorMessage) {
        WebPages.userGetErrorMessage(errorMessage);
    }

    @And("user click category laptops")
    public void userClickCategoryLaptops() throws InterruptedException {
        WebPages.userClickCategoryLaptops();
    }

    @Then("user success to change the category")
    public void userSuccessToChangeTheCategory() {
        WebPages.userSuccessToChangeTheCategory();
    }

    @And("user click second product")
    public void userClickSecondProduct() {
        WebPages.userClickSecondProduct();
    }

    @And("user click third product")
    public void userClickThirdProduct() {
        WebPages.userClickThirdProduct();
    }

    @And("user click home")
    public void userClickHome() {
        WebPages.userClickHome();
    }

    @And("user click logout")
    public void userClickLogout() {
        WebPages.userClickLogout();
    }

    @Then("user can see button login")
    public void userCanSeeButtonLogin() {
        WebPages.userCanSeeButtonLogin();
    }
}
