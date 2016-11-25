package be.cegeka.starter.application.highscore;

import be.cegeka.starter.domain.entity.highscore.Highscore;
import be.cegeka.starter.domain.entity.highscore.HighscoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class HighscoreService {

    @Autowired
    private HighscoreRepository highscoreRepository;

    @Transactional
    @Valid
    public Highscore submit(Highscore highscore) {
        return highscoreRepository.save(highscore);
    }

}