package be.cegeka.starter.interfaces.highscore;

import be.cegeka.starter.domain.entity.highscore.Highscore;
import be.cegeka.starter.domain.entity.highscore.HighscoreRepository;
import be.cegeka.starter.interfaces.highscore.transferobjects.HighscoreTO;
import be.cegeka.starter.infrastructure.test.IntegrationTest;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static be.cegeka.starter.interfaces.highscore.HighscoreResource.HIGHSCORE_BASE_URL;
import static be.cegeka.starter.interfaces.highscore.transferobjects.HighscoreTOTestBuilder.aHighscoreTO;
import static be.cegeka.starter.interfaces.highscore.transferobjects.UserTOTestBuilder.aUserTO;
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
                    .get(APP_BASE_URL + HIGHSCORE_BASE_URL + "/hello")
                .then()
                    .statusCode(200)
                .extract()
                    .response();

        assertThat(response.getBody().print()).isEqualTo("World!");
    }

    @Test
    public void submit_givenHighscoreTO_whenSubmit_thenHighscorePersistedAndReturned() {
        // given
        HighscoreTO highscoreTO = aHighscoreTO()
                .withHighscore(100)
                .withUserTO(aUserTO()
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
                    .post(APP_BASE_URL + HIGHSCORE_BASE_URL)
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