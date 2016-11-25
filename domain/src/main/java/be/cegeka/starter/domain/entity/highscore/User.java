package be.cegeka.starter.domain.entity.highscore;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public final class User {

    @NotNull(message = "FirstName of User should not be empty")
    private String firstName;
    @NotBlank(message = "LastName of User should not be empty")
    private String lastName;
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Email should be a valid email-address")
    private String email;

    private User() {
        // hibernate
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    public static class UserBuilder {

        private String firstName;
        private String lastName;
        private String email;

        private UserBuilder(){
        }

        public static UserBuilder userBuilder() {
            return new UserBuilder();
        }

        public User build() {
            return new User(firstName, lastName, email);
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }
    }
}
