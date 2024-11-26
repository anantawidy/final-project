package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static helper.Models.*;
import static helper.Utility.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class apiPages {

    String setURL;
    Response res;
    Integer id;

    public void prepareUrlValidFor(String url) {
        switch (url) {
            case "get_list_users":
                setURL = Endpoint.get_list_users;
                break;
            case "create_new_user":
                setURL = Endpoint.create_new_user;
                break;
            case "delete_user":
                setURL = Endpoint.delete_user + getUserId();
                break;
            case "update_user":
                setURL = Endpoint.update_user + getUserId();
                break;
            case "invalid_create_new_user":
                setURL = Endpoint.invalid_create_new_user;
                break;
            default:
                System.out.println("Input right URL");
        }
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
    }

    public void hitApiCreateNewUser() {
        res = getListUsers(setURL);
    }

    public void hitApiDeleteUser() {
        res = getListUsers(setURL);
    }

    public void hitApiUpdateUser() {
        res = getListUsers(setURL);
    }

    public void validationStatusCode(int statusCode) {
        assertThat(res.statusCode()).isEqualTo(statusCode);
    }

    public void validationResponseListUsers() {
        // Extract the list of objects directly as a List of Maps
        List<Map> users = res.jsonPath().getList("", Map.class);

        // Example validations
        for (Map<String, Object> user : users) {
            System.out.println("Users: " + user);
            assertTrue(user.containsKey("id"));
            assertTrue(user.containsKey("name"));
            assertTrue((Integer) user.get("id") > 0);
        }
    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchema(fileName);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void userSendAPOSTRequestWithUserData() {
        res = createNewUser(setURL);

        //Ini opsional hanya untuk melihat response body yang dikirim dari file models.java
        System.out.println("Response Body: " + res.getBody().asString());

        // Simpan ID ke tempat yang bisa diakses oleh metode `deleteUser`
        int userId = res.jsonPath().getInt("id");
        saveUserId(userId);

        //Ini opsional hanya untuk melihat user id yang disimpan
        System.out.println("ini user id yg tersimpan: " + Utility.getUserId());
    }

    public void validationResponseCreateUser(String name) {
        assertTrue(res.getBody().asString().contains(name));
    }

    public void userSendADELETERequestWithUserData() {
        res = deleteUser(setURL);
        System.out.println("Ini userid yang berhasil dihapus: " + Utility.getUserId());
    }

    public void userSendAUPDATERequestWithUserData() {
        res = updateUser(setURL);
    }

    public void validationResponseUpdateUser(String newName){
        assertTrue(res.getBody().asString().contains(newName));
    }

    public void userSendAPOSTRequestWithMissingNameField(){
        res = missingName(setURL);
    }

    public void validationResponseErrorMessage(String errorMessage){
        assertTrue(res.getBody().asString().contains(errorMessage));
    }

    public void userSendAUPDATERequestWithWrongID(){
        res = invalidUserId(setURL);
    }

    public void userSendADELETERequestWithUserIdReDelete(){
        res = ReDelete(setURL);
    }
}
