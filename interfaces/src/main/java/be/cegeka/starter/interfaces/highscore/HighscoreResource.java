package be.cegeka.starter.interfaces.highscore;

import be.cegeka.starter.application.highscore.HighscoreService;
import be.cegeka.starter.domain.entity.highscore.Highscore;
import be.cegeka.starter.interfaces.highscore.mappers.HighscoreMapper;
import be.cegeka.starter.interfaces.highscore.transferobjects.HighscoreTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = HighscoreResource.HIGHSCORE_BASE_URL)
public class HighscoreResource {

    static final String HIGHSCORE_BASE_URL = "/api/highscore";

    @Autowired
    private HighscoreService highscoreService;

    @Autowired
    private HighscoreMapper highscoreMapper;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String hello() {
        return "World!";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public HighscoreTO submit(@RequestBody HighscoreTO highscoreTO) {
        Highscore highscore = highscoreService.submit(highscoreMapper.mapToDomain(highscoreTO));
        return highscoreMapper.mapToTO(highscore);
    }

}
