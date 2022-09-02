
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

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
