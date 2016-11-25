package be.cegeka.domain.entity.highscore;

import be.cegeka.infrastructure.test.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static be.cegeka.domain.entity.highscore.testbuilders.HighscoreTestBuilder.aHighscore;
import static org.assertj.core.api.Assertions.assertThat;

public class HighscoreRepositoryIntegrationTest extends IntegrationTest{

    @Autowired
    private HighscoreRepository highscoreRepository;

    @Test
    public void get() {
        Highscore expectedHighscore = aHighscore().build();

        Highscore actualHighscore = highscoreRepository.save(expectedHighscore);

        assertThat(actualHighscore.getHighscore()).isEqualTo(expectedHighscore.getHighscore());
        assertThat(actualHighscore.getUser()).isEqualTo(expectedHighscore.getUser());
        assertThat(actualHighscore.getId()).isNotNull();
    }

}