package be.cegeka.interfaces.highscore.transferobjects;

import be.cegeka.infrastructure.TransferObject;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class HighscoreTO extends TransferObject {

    public long id;
    public float highscore;
    public UserTO userTO;

}
