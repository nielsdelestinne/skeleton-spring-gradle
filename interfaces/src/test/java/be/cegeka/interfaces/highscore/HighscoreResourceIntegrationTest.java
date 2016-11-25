package be.cegeka.interfaces.highscore;

import be.cegeka.domain.entity.highscore.Highscore;
import be.cegeka.domain.entity.highscore.HighscoreRepository;
import be.cegeka.interfaces.highscore.transferobjects.HighscoreTOTestBuilder;
import be.cegeka.interfaces.highscore.transferobjects.UserTOTestBuilder;
import be.cegeka.interfaces.highscore.transferobjects.HighscoreTO;
import be.cegeka.infrastructure.test.IntegrationTest;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

public class HighscoreResourceIntegrationTest extends IntegrationTest {

    @Autowired
    private HighscoreRepository highscoreRepository;

    @Test
    public void hello() {
        Response response =
                when()
                    .get(APP_BASE_URL + HighscoreResource.HIGHSCORE_BASE_URL + "/hello")
                .then()
                    .statusCode(200)
                .extract()
                    .response();

        assertThat(response.getBody().print()).isEqualTo("World!");
    }

    @Test
    public void submit_givenHighscoreTO_whenSubmit_thenHighscorePersistedAndReturned() {
        // given
        HighscoreTO highscoreTO = HighscoreTOTestBuilder.aHighscoreTO()
                .withHighscore(100)
                .withUserTO(UserTOTestBuilder.aUserTO()
                        .withFirstName("Frans")
                        .withLastName("Fransen")
                        .withEmail("fran@djemail.com")
                        .build())
                .build();

        // when
        HighscoreTO returnedHighscoreTO =
                given()
                    .contentType("application/json;charset=UTF-8")
                    .body(highscoreTO)
                .when()
                    .post(APP_BASE_URL + HighscoreResource.HIGHSCORE_BASE_URL)
                .then()
                    .statusCode(200)
                .extract()
                    .response()
                        .as(HighscoreTO.class);

        // then
        assertThat(returnedHighscoreTO.id).isNotNull();
        assertThat(returnedHighscoreTO.highscore).isEqualTo(100);
        assertThat(returnedHighscoreTO.userTO).isNotNull();
        assertThat(returnedHighscoreTO.userTO.firstName).isEqualTo("Frans");

        Highscore persistedHighscore = highscoreRepository.findOne(returnedHighscoreTO.id);
        assertThat(persistedHighscore.getHighscore()).isEqualTo(100);
        assertThat(persistedHighscore.getUser()).isNotNull();
        assertThat(persistedHighscore.getUser().getLastName()).isEqualTo("Fransen");
        assertThat(persistedHighscore.getUser().getEmail()).isEqualTo("fran@djemail.com");

    }

}