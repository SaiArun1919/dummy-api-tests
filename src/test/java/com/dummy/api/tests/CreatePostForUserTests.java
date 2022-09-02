package com.dummy.api.tests;

import com.dummy.api.post.PostHelper;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostCreateResponse;

@Guice
public class CreatePostForUserTests {

    @Inject
    private PostHelper postHelper;

    @Test
    public void userShouldCreateAPostWithDetails() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();
        PostCreateResponse postCreateResponse = postHelper.createNewPost(postCreateRequestBody);
        postCreateResponse.assertPostCreateDetails(postCreateRequestBody);
    }
}
