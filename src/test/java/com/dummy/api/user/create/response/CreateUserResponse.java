package com.dummy.api.user.create.response;


import com.dummy.api.user.create.CreateUserRequestBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserResponse{

	@Setter
	private int statusCode;

	private String firstName;
	private String lastName;
	private String id;
	private String updatedDate;
	private String email;
	private String registerDate;

	public void assertUser(CreateUserRequestBody createUserRequestBody) {
		Assert.assertEquals(this.getEmail(), createUserRequestBody.getEmail());
		Assert.assertEquals(this.getFirstName(), createUserRequestBody.getFirstName());
		Assert.assertEquals(this.getLastName(), createUserRequestBody.getLastName());
		Assert.assertNotNull(this.getId(),"New user id generated");
	}
}