package com.dummy.api.tests;

import com.dummy.api.post.PostHelper;
import com.dummy.api.post.create.PostCreateRequestBody;
import com.dummy.api.post.create.response.PostCreateResponse;
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
            PostCreateResponse postCreateResponse = postHelper.createNewPost(postCreateRequestBody);
            String id = postCreateResponse.getId();

            PostCreateResponse postDetails = postHelper.getPostDetails(id);
            postDetails.assertPostCreateDetails(postCreateRequestBody);

        }
    }
