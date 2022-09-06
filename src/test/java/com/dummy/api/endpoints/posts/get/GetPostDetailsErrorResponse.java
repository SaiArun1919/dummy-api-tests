package com.dummy.api.endpoints.posts.get;

import lombok.Data;

public @Data class GetPostDetailsErrorResponse{
	private int statusCode;
	private String error;
}