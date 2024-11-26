package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

import static helper.Utility.getUserId;
import static io.restassured.RestAssured.given;

public class Models {
    private static RequestSpecification request;

    public static void setUpHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer a94910c69b9814de6af842571204e6077c7b3b64b9e40f9fd16621d5ba7c0a71");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response createNewUser(String endpoint) {
        setUpHeaders();

        // User data to create
        String name = "Prio Rumpun";
        String gender = "Male";
        String email = "priorumpun" + System.currentTimeMillis() +"@testing.com"; //menggunakan System.currentTimeMillis agar email yg ditambahkan tidak ada yg duplicate
        String status = "active";

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", name);
        requestBody.put("gender", gender);
        requestBody.put("email", email);
        requestBody.put("status", status);

        return request.body(requestBody.toString())
                .when().post(endpoint);
    }

    public static Response deleteUser(String endpoint) {
        setUpHeaders();
        return request.when()
                .delete(endpoint);
    }

    public static Response updateUser(String endpoint) {
        setUpHeaders();
        String newName = "Update User Latest";

        given().when().get(endpoint + getUserId())
                .getBody().jsonPath().get("data.name");

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        return request.body(jsonObject.toString())
                .patch(endpoint);
    }

    public static Response missingName(String endpoint){
        setUpHeaders();
        // User data to create
        String name = null;
        String gender = "Male";
        String email = "priorumpun" + System.currentTimeMillis() +"@testing.com"; //menggunakan System.currentTimeMillis agar email yg ditambahkan tidak ada yg duplicate
        String status = "active";

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", name);
        requestBody.put("gender", gender);
        requestBody.put("email", email);
        requestBody.put("status", status);

        return request.body(requestBody.toString())
                .when().post(endpoint);
    }

    public static Response invalidUserId(String endpoint) {
        setUpHeaders();
        String newName = "Invalid User ID";

        given().when().get(endpoint + "6")
                .getBody().jsonPath().get("data.name");

        HashMap<String, String> bodyMap = new HashMap<>();
        bodyMap.put("name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        return request.body(jsonObject.toString())
                .patch(endpoint);
    }

    public static Response ReDelete(String endpoint){
        setUpHeaders();
        return request.when()
                .delete(endpoint);
    }

    public static String GenerateUsername(){
        String username = "testing";
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        return username + randomNumber;
    }
}
