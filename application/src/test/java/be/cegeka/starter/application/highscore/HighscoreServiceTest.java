package be.cegeka.starter.application.highscore;

import be.cegeka.starter.domain.entity.highscore.Highscore;
import be.cegeka.starter.domain.entity.highscore.HighscoreRepository;
import be.cegeka.starter.domain.entity.highscore.testbuilders.HighscoreTestBuilder;
import be.cegeka.starter.infrastructure.test.UnitTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class HighscoreServiceTest extends UnitTest {

    @Mock
    private HighscoreRepository highscoreRepository;

    @InjectMocks
    private HighscoreService highscoreService;

    @Test
    public void submit() {
        Highscore expectedHighscore = HighscoreTestBuilder.aHighscore().build();

        when(highscoreRepository.save(any(Highscore.class))).thenReturn(expectedHighscore);
        when(highscoreRepository.count()).thenReturn(1L);

        Highscore actualHighscore = highscoreService.submit(expectedHighscore);

        assertThat(actualHighscore).isEqualTo(expectedHighscore);
    }

}