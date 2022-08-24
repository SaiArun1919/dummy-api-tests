package users;

import io.restassured.response.Response;
import users.get.GetUsersListResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

    public GetUsersListResponse getList(int limit){

        Response response =
                given()
                  .header("app-id", "6305fad76cd510050784ce73")
                        .queryParam("limit",limit)
                .when()
                  .get("https://dummyapi.io/data/v1/user");

        response.then().log().body();

        int statusCode = response.statusCode();

        GetUsersListResponse usersListResponse = response.as(GetUsersListResponse.class);
        usersListResponse.setStatusCode(statusCode);
        return usersListResponse;
    }
}
