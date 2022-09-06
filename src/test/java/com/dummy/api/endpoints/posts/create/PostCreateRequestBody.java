package com.dummy.api.endpoints.posts.create;

import lombok.Data;

public @Data class PostCreateRequestBody {
    private String owner;
    private String image;
    private String text;
    private int likes;
    private String tags;

    public PostCreateRequestBody(Builder builder) {
        this.owner = builder.owner;
        this.image = builder.image;
        this.text = builder.text;
        this.likes = builder.likes;
        this.tags = builder.tags;
    }

    public static class Builder {
        private String owner;
        private String image;
        private String text;
        private int likes;
        private String tags;

        public Builder() {
            this.owner = "6311d04b3ce6c16604451196";
            this.image = "https://miro.medium.com/max/1400/1*_wxvYQ3bmLZBk31PIZihfA.png";
            this.text = "Rest Assured";
            this.likes = 10;
            this.tags = "#API";
        }

        public PostCreateRequestBody build() {
            PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody(this);
            return postCreateRequestBody;
        }
    }
}