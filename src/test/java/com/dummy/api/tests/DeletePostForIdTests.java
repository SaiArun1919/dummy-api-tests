package com.dummy.api.tests;

import com.dummy.api.post.PostHelper;
import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostDetailsResponse;
import com.dummy.api.post.delete.DeletePostResponse;
import com.dummy.api.post.get.GetPostDetailsErrorResponse;
import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class DeletePostForIdTests {

    @Inject
    private PostHelper postHelper;

    @Test
    public void shouldDeletePostDetailsForPostId() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();
        PostDetailsResponse postDetailsResponse = postHelper.createNewPost(postCreateRequestBody);
        String id = postDetailsResponse.getId();

        PostDetailsResponse postDetails = postHelper.getPostDetails(id);
        postDetails.assertPostCreateDetails(postCreateRequestBody);

        DeletePostResponse deletePostResponse = postHelper.shouldDeletePost(id);
        Assert.assertEquals(deletePostResponse.getStatusCode(),200);
        Assert.assertEquals(deletePostResponse.getId(),id);

        GetPostDetailsErrorResponse postDetailsAfterDelete = postHelper.getPostDetailsAfterDelete(id);
        Assert.assertEquals(postDetailsAfterDelete.getStatusCode(),404);
        Assert.assertEquals(postDetailsAfterDelete.getError(),"RESOURCE_NOT_FOUND");
    }

}
