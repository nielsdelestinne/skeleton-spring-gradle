package be.cegeka.starter.interfaces.highscore.mappers;

import be.cegeka.starter.domain.entity.highscore.User;
import be.cegeka.starter.interfaces.highscore.transferobjects.UserTO;
import be.cegeka.starter.infrastructure.test.UnitTest;
import org.junit.Test;
import org.mockito.InjectMocks;

import static be.cegeka.starter.domain.entity.highscore.testbuilders.UserTestBuilder.aUser;
import static be.cegeka.starter.interfaces.highscore.transferobjects.UserTOTestBuilder.aUserTO;
import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest extends UnitTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void mapToDomain() {
        UserTO userTO = aUserTO()
                .withFirstName("Jan")
                .withLastName("Jansen")
                .withEmail("jan@djemail.com")
                .build();

        User user = userMapper.mapToDomain(userTO);

        assertThat(user).isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Jan");
        assertThat(user.getLastName()).isEqualTo("Jansen");
        assertThat(user.getEmail()).isEqualTo("jan@djemail.com");
    }

    @Test
    public void mapToTO() {
        User user = aUser()
                .withFirstName("Jan")
                .withLastName("Jansen")
                .withEmail("jan@djemail.com")
                .build();

        UserTO userTO = userMapper.mapToTO(user);

        assertThat(userTO).isNotNull();
        assertThat(userTO.firstName).isEqualTo("Jan");
        assertThat(userTO.lastName).isEqualTo("Jansen");
        assertThat(userTO.email).isEqualTo("jan@djemail.com");
    }
}