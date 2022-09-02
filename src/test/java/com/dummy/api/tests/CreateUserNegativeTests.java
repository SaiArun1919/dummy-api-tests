package com.dummy.api.tests;

import com.dummy.api.user.UserClient;
import com.dummy.api.user.create.CreateUserRequestBody;
import com.dummy.api.user.create.response.CreateUserErrorResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CreateUserNegativeTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void validateErrorDetailsBySendingExistedEmailForUserCreation() {
        //Arrange
        CreateUserRequestBody userRequestBody = new CreateUserRequestBody.Builder().email("bcf224@gmail.com").build();
        //Act
        CreateUserErrorResponse createUserErrorResponse = userClient.createUserWithError(userRequestBody);
        //Assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(), 400);
        createUserErrorResponse.assertHasError("Email already used");
    }
}
