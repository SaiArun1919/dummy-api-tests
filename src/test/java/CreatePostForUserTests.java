import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UserClient;
import users.post.PostCreateRequestBody;
import users.post.response.PostCreateResponse;

public class CreatePostForUserTests {

    private UserClient userClient;

    @BeforeClass
    public void beforeClass() {
        userClient = new UserClient();
    }

    @Test
    public void userShouldCreateAPostWithDetails() {
        PostCreateRequestBody postCreateRequestBody = new PostCreateRequestBody.Builder().build();

        PostCreateResponse postCreateResponse = userClient.createPost(postCreateRequestBody);

        postCreateResponse.assertPostCreateDetails(postCreateRequestBody);
    }
}
