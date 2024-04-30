package commands.auxiliaryCommands.parameters;

import baseClass.MusicBand;

import java.io.Serializable;

public record MusicBandAndKeyParameters(String key, MusicBand musicBand) implements Parameter, Serializable {
    public void getParameters(){
        System.out.println("MusicBand : " + musicBand);
    }
}
