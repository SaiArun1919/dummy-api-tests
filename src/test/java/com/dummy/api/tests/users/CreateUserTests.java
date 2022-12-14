package com.dummy.api.tests.users;

import com.dummy.api.endpoints.users.UserClient;
import com.dummy.api.endpoints.users.create.CreateUserRequestBody;
import com.dummy.api.endpoints.users.create.response.CreateUserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void shouldCreateAUserWithValidEmail() {
        //Arrange
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
        //Act
        CreateUserResponse userResponse = userClient.createUser(createUserRequestBody);
        //Assert
        userResponse.assertUser(createUserRequestBody);
    }
}
