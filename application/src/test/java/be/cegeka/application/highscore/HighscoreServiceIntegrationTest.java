package be.cegeka.application.highscore;

import be.cegeka.domain.entity.highscore.Highscore;
import be.cegeka.domain.entity.highscore.testbuilders.HighscoreTestBuilder;
import be.cegeka.domain.entity.highscore.testbuilders.UserTestBuilder;
import be.cegeka.infrastructure.test.IntegrationTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class HighscoreServiceIntegrationTest extends IntegrationTest {

    @Autowired
    private HighscoreService highscoreService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void submit() {
        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withUser(UserTestBuilder.aUser()
                        .withFirstName("Test")
                        .withLastName("Den Tester")
                        .withEmail("test@test.com")
                        .build())
                .withHighscore(757.54F)
                .build();

        Highscore persistedHighscore = highscoreService.submit(highscoreToSubmit);

        assertThat(persistedHighscore).isEqualTo(highscoreToSubmit);
    }

    @Test
    public void submit_givenHighscoreWithoutUser_thenThrowValidationException() {
        expectedException.expectMessage("User should not be empty");

        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withoutUser()
                .build();

        highscoreService.submit(highscoreToSubmit);
    }

    @Test
    public void submit_givenHighscoreWithUserMissingLastName_thenThrowValidationException() {
        expectedException.expectMessage("LastName of User should not be empty");

        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withUser(UserTestBuilder.aUser()
                        .withoutLastName()
                        .build())
                .build();

        highscoreService.submit(highscoreToSubmit);
    }

    @Test
    public void submit_givenHighscoreWithUserMissingFirstName_thenThrowValidationException() {
        expectedException.expectMessage("FirstName of User should not be empty");

        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withUser(UserTestBuilder.aUser()
                        .withoutFirstName()
                        .build())
                .build();

        highscoreService.submit(highscoreToSubmit);
    }

    @Test
    public void submit_givenHighscoreWithUserMissingEmail_thenThrowValidationException() {
        expectedException.expectMessage("Email should not be empty");

        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withUser(UserTestBuilder.aUser()
                        .withoutEmail()
                        .build())
                .build();

        highscoreService.submit(highscoreToSubmit);
    }

    @Test
    public void submit_givenHighscoreWithUserWithAnIncorrectEmail_thenThrowValidationException() {
        expectedException.expectMessage("Email should be a valid email-address");

        Highscore highscoreToSubmit = HighscoreTestBuilder.aHighscore()
                .withUser(UserTestBuilder.aUser()
                        .withEmail("nietgeldig.abc")
                        .build())
                .build();

        highscoreService.submit(highscoreToSubmit);
    }

}