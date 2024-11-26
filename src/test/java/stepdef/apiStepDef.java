package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.apiPages;

public class apiStepDef {

    apiPages ApiPages;

    public apiStepDef(){
        this.ApiPages = new apiPages();
    }

    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        ApiPages.prepareUrlValidFor(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        ApiPages.hitApiGetListUsers();
    }

    @Then("validation status code {int}")
    public void validationStatusCode(int statusCode) {
        ApiPages.validationStatusCode(statusCode);
    }

    @Then("validation response list users")
    public void validationResponseListUsers() {
        ApiPages.validationResponseListUsers();
    }

    @And("hit api create new user")
    public void hitApiCreateNewUser() {
        ApiPages.hitApiCreateNewUser();
    }

    @Then("validation response create user {string}")
    public void validationResponseCreateUser(String name) {
        ApiPages.validationResponseCreateUser(name);
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        ApiPages.validationResponseJsonWithJSONSchema(fileName);
    }

    @When("user send a POST request with user data")
    public void userSendAPOSTRequestWithUserData() {
        ApiPages.userSendAPOSTRequestWithUserData();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        ApiPages.hitApiDeleteUser();
    }

    @When("user send a DELETE request with user id")
    public void userSendADELETERequestWithUserData() {
        ApiPages.userSendADELETERequestWithUserData();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        ApiPages.hitApiUpdateUser();
    }

    @When("user send a UPDATE request with user data")
    public void userSendAUPDATERequestWithUserData() {
        ApiPages.userSendAUPDATERequestWithUserData();
    }

    @Then("validation response update user {string}")
    public void validationResponseUpdateUser(String newName) {
        ApiPages.validationResponseUpdateUser(newName);
    }

    @When("user send a POST request with missing name field")
    public void userSendAPOSTRequestWithMissingNameField() {
        ApiPages.userSendAPOSTRequestWithMissingNameField();
    }

    @Then("validation response error message {string}")
    public void validationResponseErrorMessage(String errorMessage) {
        ApiPages.validationResponseErrorMessage(errorMessage);
    }

    @When("user send a UPDATE request with wrong ID")
    public void userSendAUPDATERequestWithWrongID() {
        ApiPages.userSendAUPDATERequestWithWrongID();
    }

    @When("user send a DELETE request with user id - ReDelete")
    public void userSendADELETERequestWithUserIdReDelete() {
        ApiPages.userSendADELETERequestWithUserIdReDelete();
    }
}
