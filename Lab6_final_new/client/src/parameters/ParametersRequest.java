package parameters;

import models.MusicBand;

import java.io.Serializable;

public class ParametersRequest implements Serializable {
    private String parameter;
    private MusicBand musicBand;

    public ParametersRequest(String parameter, MusicBand musicBand){
        this.parameter = parameter;
        this.musicBand = musicBand;
    }
    public ParametersRequest(String parameter){
        this.parameter = parameter;
    }
    public ParametersRequest(MusicBand musicBand){
        this.musicBand = musicBand;
    }

    public String getParameter() {
        return parameter;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }
}
