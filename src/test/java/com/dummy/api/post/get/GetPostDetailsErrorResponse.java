package com.dummy.api.post.get;

import lombok.Data;

public @Data class GetPostDetailsErrorResponse{
	private int statusCode;
	private String error;
}