import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.get.GetUsersListResponse;

public class GetListOfUsersTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeClass(){
        userClient = new UserClient();
    }

    @Test
    public void getTheListOfAllUsers(){
       //Act
       GetUsersListResponse getUsersListResponse = userClient.getList(10);

       //Assert
       Assert.assertEquals(getUsersListResponse.getStatusCode(),200);
       Assert.assertEquals(getUsersListResponse.getLimit(),10);
       getUsersListResponse.hasMrUser("mr");
    }
}
