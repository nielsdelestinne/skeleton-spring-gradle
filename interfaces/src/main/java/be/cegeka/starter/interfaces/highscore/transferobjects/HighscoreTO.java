package be.cegeka.starter.interfaces.highscore.transferobjects;

import be.cegeka.starter.infrastructure.TransferObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class HighscoreTO extends TransferObject {

    public long id;
    public float highscore;
    public UserTO userTO;

}
