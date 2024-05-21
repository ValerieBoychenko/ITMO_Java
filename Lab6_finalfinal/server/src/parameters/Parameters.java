package parameters;

import models.MusicBand;

import java.io.Serializable;

public class Parameters implements Serializable {
    private String parameter;
    private MusicBand musicBand;

    public Parameters(String parameter, MusicBand musicBand){
        this.parameter = parameter;
        this.musicBand = musicBand;
    }
    public Parameters(String parameter){
        this.parameter = parameter;
    }
    public Parameters(MusicBand musicBand){
        this.musicBand = musicBand;
    }

    public String getParameter() {
        return parameter;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }
}
