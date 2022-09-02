package com.dummy.api.tests;
import com.dummy.api.user.UserClient;
import com.dummy.api.user.get.GetUsersListResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class GetListOfUsersTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeClass(){
        userClient = new UserClient();
    }

    @Test
    public void getTheListOfAllUsers(){
       //Act
       GetUsersListResponse getUsersListResponse = userClient.getList("limit",10);
       //Assert
       Assert.assertEquals(getUsersListResponse.getStatusCode(),200);
       Assert.assertEquals(getUsersListResponse.getLimit(),10);
       getUsersListResponse.hasMrUser("mr");
    }

    @Test
    public void getTheListOfUsersCreatedByCurrentUser(){
        //Act
        GetUsersListResponse getUsersListResponse = userClient.getList("created",1);
        //Assert
        Assert.assertEquals(getUsersListResponse.getStatusCode(),200);
        Assert.assertEquals(getUsersListResponse.getLimit(),20);
        getUsersListResponse.assertTotalAccountsPresent();
    }
}
