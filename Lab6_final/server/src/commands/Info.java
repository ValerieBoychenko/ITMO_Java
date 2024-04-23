package commands;

import serverModules.ResponseClient;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class Info extends Command implements Serializable {
    private static final long serialVersionUID = 8L;

    public void execute(DatagramSocket serverSocket, DatagramPacket receivePacket) throws NullPointerException, IOException {
        if (musicBands == null) {
            throw new NullPointerException("musicBands is not initialized.\n" + this.toString());
        }
        String message = "Информация о коллекции музыкальных групп:" + "\n" +
                "Тип коллекции: TreeMap<String, base_class.MusicBand>" + "\n" +
                "Дата инициализации: " + musicBands.getInitializationDate() + "\n" +
                "Количество элементов: " + musicBands.getMusicBands().size();
        new ResponseClient().response(message, serverSocket, receivePacket);
    }

    @Override
    public String toString(){
        return "Имя класса: Info" + " - / " + new Date().toString() + " /";
    }

}

