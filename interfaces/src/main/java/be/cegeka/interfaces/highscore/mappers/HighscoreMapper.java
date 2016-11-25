package be.cegeka.interfaces.highscore.mappers;

import be.cegeka.domain.entity.highscore.Highscore;
import be.cegeka.interfaces.highscore.transferobjects.HighscoreTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HighscoreMapper {

    @Autowired
    private UserMapper userMapper;

    public Highscore mapToDomain(HighscoreTO highscoreTO) {
        return Highscore.HighscoreBuilder.highscore()
                .withId(highscoreTO.id)
                .withHighscore(highscoreTO.highscore)
                .withUser(userMapper
                        .mapToDomain(highscoreTO.userTO))
                .build();
    }

    public HighscoreTO mapToTO(Highscore highscore) {
        HighscoreTO highscoreTO = new HighscoreTO();
        highscoreTO.id = highscore.getId();
        highscoreTO.highscore = highscore.getHighscore();
        highscoreTO.userTO = userMapper.mapToTO(highscore.getUser());
        return highscoreTO;
    }

}
