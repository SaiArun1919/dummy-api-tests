package users.create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {
    private String firstName;
    private String lastName;
    private String email;

    public CreateUserRequestBody(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;

        public Builder() {
            this.firstName = "test";
            this.lastName = "dummy";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
        }

        public CreateUserRequestBody build() {
            CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
            return createUserRequestBody;
        }

    }
}