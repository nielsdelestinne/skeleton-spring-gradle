package be.cegeka.starter.interfaces.highscore.transferobjects;

import static be.cegeka.starter.interfaces.highscore.transferobjects.UserTOTestBuilder.aUserTO;

public class HighscoreTOTestBuilder {

    private long id;
    private float highscore = 88.45F;
    private UserTO userTO = aUserTO().build();

    public static HighscoreTOTestBuilder aHighscoreTO() {
        return new HighscoreTOTestBuilder();
    }

    public HighscoreTO build() {
        HighscoreTO highscoreTO = new HighscoreTO();
        highscoreTO.id = id;
        highscoreTO.highscore = highscore;
        highscoreTO.userTO = userTO;
        return highscoreTO;
    }

    public HighscoreTOTestBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public HighscoreTOTestBuilder withHighscore(float highscore) {
        this.highscore = highscore;
        return this;
    }

    public HighscoreTOTestBuilder withUserTO(UserTO userTO) {
        this.userTO = userTO;
        return this;
    }
}