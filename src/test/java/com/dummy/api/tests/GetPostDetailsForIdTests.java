package com.dummy.api.tests;

import com.dummy.api.post.PostHelper;
import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostDetailsResponse;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice
public class GetPostDetailsForIdTests {

        @Inject
        private PostHelper postHelper;

        @Test
        public void shouldGetPostDetailsForPostId() {
            PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();
            PostDetailsResponse postDetailsResponse = postHelper.createNewPost(postCreateRequestBody);
            String id = postDetailsResponse.getId();

            PostDetailsResponse postDetails = postHelper.getPostDetails(id);
            postDetails.assertPostCreateDetails(postCreateRequestBody);

        }
    }
