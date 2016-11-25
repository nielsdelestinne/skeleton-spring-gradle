package be.cegeka.interfaces.highscore.transferobjects;

public class UserTOTestBuilder {

    private String firstName = "Kurtje";
    private String lastName = "Kurtens";
    private String email = "kurtjekurtens007@djemail.com";

    public static UserTOTestBuilder aUserTO() {
        return new UserTOTestBuilder();
    }

    public UserTO build() {
        UserTO userTO = new UserTO();
        userTO.firstName = firstName;
        userTO.lastName = lastName;
        userTO.email = email;
        return userTO;
    }

    public UserTOTestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserTOTestBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserTOTestBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}