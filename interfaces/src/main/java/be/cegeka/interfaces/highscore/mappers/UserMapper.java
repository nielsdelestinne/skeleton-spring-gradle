package be.cegeka.interfaces.highscore.mappers;

import be.cegeka.domain.entity.highscore.User;
import be.cegeka.interfaces.highscore.transferobjects.UserTO;
import org.springframework.stereotype.Component;

import static be.cegeka.domain.entity.highscore.User.UserBuilder.userBuilder;

@Component
public class UserMapper {

    public User mapToDomain(UserTO userTO) {
        return userBuilder()
                .withFirstName(userTO.firstName)
                .withLastName(userTO.lastName)
                .withEmail(userTO.email)
                .build();
    }

    public UserTO mapToTO(User user) {
        UserTO userTO = new UserTO();
        userTO.firstName = user.getFirstName();
        userTO.lastName = user.getLastName();
        userTO.email = user.getEmail();
        return userTO;
    }

}
