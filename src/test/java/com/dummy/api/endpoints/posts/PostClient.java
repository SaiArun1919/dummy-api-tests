package com.dummy.api.endpoints.posts;

import com.dummy.api.endpoints.posts.create.PostCreateRequestBody;
import com.dummy.api.endpoints.posts.delete.DeletePostResponse;
import com.dummy.api.endpoints.posts.get.GetPostDetailsErrorResponse;
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

    public PostDetailsResponse getPostDetails(String id){
        Response response = getPost(id);

        int statusCode = response.getStatusCode();
        PostDetailsResponse postDetailsResponse = response.as(PostDetailsResponse.class);
        postDetailsResponse.setStatusCode(statusCode);
        return postDetailsResponse;
    }

    public GetPostDetailsErrorResponse getPostExpectingError(String id){
        Response response = getPost(id);
        int statusCode = response.getStatusCode();
        GetPostDetailsErrorResponse postDetailsErrorResponse = response.as(GetPostDetailsErrorResponse.class);
        postDetailsErrorResponse.setStatusCode(statusCode);
        return postDetailsErrorResponse;
    }

    private Response getPost(String id) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "6305fad76cd510050784ce73")
                .pathParam("id", id)
                .when()
                .get("https://dummyapi.io/data/v1/post/{id}");

        response.then().log().body();
        return response;
    }

    public DeletePostResponse deletePost(String id){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", "6305fad76cd510050784ce73")
                .pathParam("id", id)
                .when()
                .delete("https://dummyapi.io/data/v1/post/{id}");

        response.then().log().body();

        int statusCode = response.getStatusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);
        return deletePostResponse;
    }

    public PostDetailsResponse createPost(PostCreateRequestBody postCreateRequestBody) {
        Response response = postCreate(postCreateRequestBody);
        PostDetailsResponse postDetailsResponse = response.as(PostDetailsResponse.class);
        postDetailsResponse.setStatusCode(response.getStatusCode());
        return postDetailsResponse;
    }
}
