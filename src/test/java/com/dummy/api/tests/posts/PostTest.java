package com.dummy.api.tests.posts;

import com.dummy.api.endpoints.posts.PostClient;
import com.dummy.api.endpoints.posts.PostHelper;
import com.dummy.api.endpoints.posts.create.PostCreateRequestBody;
import com.dummy.api.endpoints.posts.PostDetailsResponse;
import com.dummy.api.tests.BaseTest;
import com.google.inject.Inject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = "post")
public class PostTest extends BaseTest {
    @Inject
    protected PostHelper postHelper;

    @Inject
    protected PostClient postClient;

    private ThreadLocal<PostDetailsResponse> postDetailsResponseThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();
        PostDetailsResponse postDetailsResponse = postHelper.createNewPost(postCreateRequestBody);
        postDetailsResponseThreadLocal.set(postDetailsResponse);
    }

    protected PostDetailsResponse getPostDetails(){
        return postDetailsResponseThreadLocal.get();
    }
}
