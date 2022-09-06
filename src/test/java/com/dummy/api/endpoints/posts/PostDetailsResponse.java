package com.dummy.api.endpoints.posts;

import com.dummy.api.endpoints.posts.create.PostCreateRequestBody;
import lombok.Data;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Owner owner = (Owner) o;
            return firstName.equals(owner.firstName) && lastName.equals(owner.lastName) && id.equals(owner.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, id);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDetailsResponse that = (PostDetailsResponse) o;
        return statusCode == that.statusCode && likes == that.likes && owner.equals(that.owner)
                && image.equals(that.image) && link.equals(that.link) && publishDate.equals(that.publishDate)
                && id.equals(that.id) && text.equals(that.text) && updatedDate.equals(that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, owner, image, link, publishDate, id, text, updatedDate, likes, tags);
    }
}