package com.dummy.api.tests.posts;

import com.dummy.api.endpoints.posts.PostDetailsResponse;
import com.dummy.api.endpoints.posts.delete.DeletePostResponse;
import com.dummy.api.endpoints.posts.get.GetPostDetailsErrorResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostForIdTests extends PostTest {

    @Test
    public void shouldDeletePostDetailsForPostId() {
        PostDetailsResponse postDetailsResponse = getPostDetails();
        String post_id = postDetailsResponse.getId();

        DeletePostResponse deletePostResponse = postClient.deletePost(post_id);
        Assert.assertEquals(deletePostResponse.getStatusCode(),200);
        Assert.assertEquals(deletePostResponse.getId(),post_id);

        GetPostDetailsErrorResponse postDetailsAfterDelete = postClient.getPostExpectingError(post_id);
        Assert.assertEquals(postDetailsAfterDelete.getStatusCode(),404);
        Assert.assertEquals(postDetailsAfterDelete.getError(),"RESOURCE_NOT_FOUND");
    }
}
