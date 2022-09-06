package com.dummy.api.endpoints.posts;

import com.dummy.api.endpoints.posts.create.PostCreateRequestBody;
import com.google.inject.Inject;

public class PostHelper {

    @Inject
    private PostClient postClient;

    public PostDetailsResponse createNewPost() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();

        return createNewPost(postCreateRequestBody);
    }

    public PostDetailsResponse createNewPost(PostCreateRequestBody requestBody) {

        PostDetailsResponse postDetailsResponse = postClient.createPost(requestBody);

        return postDetailsResponse;
    }
}
