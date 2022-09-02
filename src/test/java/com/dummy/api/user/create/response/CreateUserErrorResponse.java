package com.dummy.api.user.create.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserErrorResponse{

	@Setter
	private int statusCode;

	private Data data;
	private String error;

	@Getter
	public static class Data{
		private String email;
	}

	public void assertHasError(String message){
		boolean existedUser = data.getEmail().equals(message);
	}
}