package com.dummy.api.post;

import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostDetailsResponse;
import com.dummy.api.post.delete.DeletePostResponse;
import com.dummy.api.post.get.GetPostDetailsErrorResponse;
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

    public PostDetailsResponse getPostDetails(String post_id){
        PostDetailsResponse details = postClient.getPostDetails(post_id);
        return details;
    }

    public GetPostDetailsErrorResponse getPostDetailsAfterDelete(String post_id){
        GetPostDetailsErrorResponse postExpectingError = postClient.getPostExpectingError(post_id);
        return postExpectingError;
    }

    public DeletePostResponse shouldDeletePost(String post_id){
        DeletePostResponse deletePostResponse = postClient.deletePost(post_id);
        return deletePostResponse;
    }
}
