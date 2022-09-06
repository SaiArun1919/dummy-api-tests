package com.dummy.api.tests.posts;

import org.testng.annotations.Test;
import com.dummy.api.endpoints.posts.create.PostCreateRequestBody;
import com.dummy.api.endpoints.posts.PostDetailsResponse;

public class CreatePostForUserTests extends PostTest {

    @Test
    public void userShouldCreateAPostWithDetails() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();
        PostDetailsResponse postDetailsResponse = postHelper.createNewPost(postCreateRequestBody);
        postDetailsResponse.assertPostCreateDetails(postCreateRequestBody);
    }
}
