package be.cegeka.starter.domain.entity.highscore.testbuilders;

import be.cegeka.starter.domain.entity.highscore.User;

import static be.cegeka.starter.domain.entity.highscore.User.UserBuilder.userBuilder;

public class UserTestBuilder {

    private String firstName = "Niels";
    private String lastName = "Delestinne";
    private String email = "niels@mail.be";

    public static UserTestBuilder aUser() {
        return new UserTestBuilder();
    }

    public User build() {
        return userBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .build();
    }

    public UserTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserTestBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserTestBuilder withoutLastName() {
        this.lastName = null;
        return this;
    }

    public UserTestBuilder withoutFirstName() {
        this.firstName = null;
        return this;
    }

    public UserTestBuilder withoutEmail() {
        this.email = null;
        return this;
    }
}