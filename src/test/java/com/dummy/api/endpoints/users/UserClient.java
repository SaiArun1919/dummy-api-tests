package com.dummy.api.endpoints.users;

import com.dummy.api.endpoints.users.create.CreateUserRequestBody;
import com.dummy.api.endpoints.users.create.response.CreateUserErrorResponse;
import com.dummy.api.endpoints.users.create.response.CreateUserResponse;
import com.dummy.api.endpoints.users.get.GetUsersListResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public GetUsersListResponse getList(String key, int value) {

        Response response =
                given()
                        .header("app-id", "6305fad76cd510050784ce73")
                        .queryParam(key, value)
                        .when()
                        .get("https://dummyapi.io/data/v1/user");

        response.then().log().body();

        int statusCode = response.statusCode();

        GetUsersListResponse usersListResponse = response.as(GetUsersListResponse.class);
        usersListResponse.setStatusCode(statusCode);
        return usersListResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("app-id", "6305fad76cd510050784ce73")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();
        return response;
    }

    public CreateUserResponse createUser(CreateUserRequestBody requestBody) {
        Response response = create(requestBody);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserWithError(CreateUserRequestBody requestBody) {
        Response response = create(requestBody);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.getStatusCode());
        return errorResponse;
    }
}
