package be.cegeka.interfaces.highscore.mappers;

import be.cegeka.domain.entity.highscore.Highscore;
import be.cegeka.domain.entity.highscore.User;
import be.cegeka.interfaces.highscore.transferobjects.HighscoreTOTestBuilder;
import be.cegeka.interfaces.highscore.transferobjects.HighscoreTO;
import be.cegeka.interfaces.highscore.transferobjects.UserTO;
import be.cegeka.infrastructure.test.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static be.cegeka.domain.entity.highscore.testbuilders.HighscoreTestBuilder.aHighscore;
import static be.cegeka.domain.entity.highscore.testbuilders.UserTestBuilder.aUser;
import static be.cegeka.interfaces.highscore.transferobjects.UserTOTestBuilder.aUserTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class HighscoreMapperTest extends UnitTest{

    @Mock
    private UserMapper userMapperMock;

    @InjectMocks
    private HighscoreMapper highscoreMapper;

    @Before
    public void mockUserMapper() {
        when(userMapperMock.mapToDomain(any(UserTO.class)))
                .thenReturn(aUser()
                        .withFirstName("Jan")
                        .withLastName("Jansen")
                        .withEmail("jan@djemail.com")
                        .build());

        when(userMapperMock.mapToTO(any(User.class)))
                .thenReturn(aUserTO()
                        .withFirstName("Jan")
                        .withLastName("Jansen")
                        .withEmail("jan@djemail.com")
                        .build());
    }

    @Test
    public void mapToDomain() {
        HighscoreTO highscoreTO = HighscoreTOTestBuilder.aHighscoreTO()
                .withId(123)
                .withHighscore(100)
                .build();

        Highscore highscore = highscoreMapper.mapToDomain(highscoreTO);

        verify(userMapperMock).mapToDomain(any(UserTO.class));
        assertThat(highscore).isNotNull();
        assertThat(highscore.getId()).isEqualTo(123);
        assertThat(highscore.getHighscore()).isEqualTo(100);
        assertThat(highscore.getUser()).isNotNull();
        assertThat(highscore.getUser().getFirstName()).isEqualTo("Jan");
    }

    @Test
    public void mapToTO() {
        Highscore highscore = aHighscore()
                .withId(123)
                .withHighscore(100)
                .build();

        HighscoreTO highscoreTO = highscoreMapper.mapToTO(highscore);

        verify(userMapperMock).mapToTO(any(User.class));
        assertThat(highscoreTO).isNotNull();
        assertThat(highscoreTO.id).isEqualTo(123);
        assertThat(highscoreTO.highscore).isEqualTo(100);
        assertThat(highscoreTO.userTO).isNotNull();
        assertThat(highscoreTO.userTO.firstName).isEqualTo("Jan");
    }
}