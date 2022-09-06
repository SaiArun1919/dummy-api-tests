package com.dummy.api.tests.posts;

import com.dummy.api.endpoints.posts.PostDetailsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPostDetailsForIdTests extends PostTest {

        @Test
        public void shouldGetPostDetailsForPostId() {
            PostDetailsResponse newPost = getPostDetails();
            String post_id = newPost.getId();

            PostDetailsResponse postDetails = postClient.getPostDetails(post_id);;
            boolean postMatches = postDetails.equals(newPost);
            Assert.assertTrue(postMatches);
        }
}
