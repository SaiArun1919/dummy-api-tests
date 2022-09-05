package com.dummy.api.post.create.response;

import com.dummy.api.post.create.PostCreateRequestBody;
import lombok.Data;
import org.testng.Assert;

import java.util.List;

public @Data
class PostDetailsResponse {
    private int statusCode;

    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private int likes;
    private List<String> tags;

    public void assertPostCreateDetails(PostCreateRequestBody postCreateRequestBody) {
        Assert.assertEquals(this.getStatusCode(), 200);
        Assert.assertEquals(this.getText(), postCreateRequestBody.getText());
        Assert.assertEquals(this.getLikes(), postCreateRequestBody.getLikes());
        Assert.assertEquals(this.getOwner().getId(), postCreateRequestBody.getOwner());
        Assert.assertEquals(this.getImage(), postCreateRequestBody.getImage());
        Assert.assertTrue(this.getTags().stream()
                .filter(tags -> tags.equals(postCreateRequestBody.getTags())).findAny().isPresent());
    }

    public @Data
    class Owner {
        private String firstName;
        private String lastName;
        private String id;
    }
}