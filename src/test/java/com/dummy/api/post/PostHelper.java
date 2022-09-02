package com.dummy.api.post;

import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostCreateResponse;
import com.google.inject.Inject;

public class PostHelper {

    @Inject
    private PostClient postClient;

    public PostCreateResponse createNewPost() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();

        return createNewPost(postCreateRequestBody);
    }

    public PostCreateResponse createNewPost(PostCreateRequestBody requestBody) {

        PostCreateResponse postCreateResponse = postClient.createPost(requestBody);

        return postCreateResponse;
    }
}
