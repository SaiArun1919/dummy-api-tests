package com.dummy.api.post;

import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostCreateResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClient {

    public Response postCreate(PostCreateRequestBody body) {
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("app-id", "6305fad76cd510050784ce73")
                        .body(body)
                        .when()
                        .post("https://dummyapi.io/data/v1/post/create");

        response.then()
                .log().body();
        return response;
    }

    public PostCreateResponse getDetails(String id){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "6305fad76cd510050784ce73")
                .pathParam("id", id)
                .when()
                .get("https://dummyapi.io/data/v1/post/{id}");

        response.then().log().body();

        int statusCode = response.getStatusCode();
        PostCreateResponse postCreateResponse = response.as(PostCreateResponse.class);
        postCreateResponse.setStatusCode(statusCode);
        return postCreateResponse;
    }

    public PostCreateResponse createPost(PostCreateRequestBody postCreateRequestBody) {
        Response response = postCreate(postCreateRequestBody);
        PostCreateResponse postCreateResponse = response.as(PostCreateResponse.class);
        postCreateResponse.setStatusCode(response.getStatusCode());
        return postCreateResponse;
    }
}
