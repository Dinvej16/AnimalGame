package animalgame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

    /**
     * This method lets us load old game saved data.
     * @param fileName the filename from which we want to retrieve game data
     * @return the instance of saveGame we retrieved
     */
    public static SavedGame loadSavedGame(String fileName){
        SavedGame savedGame = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName+".ser");
            ObjectInputStream oi = new ObjectInputStream(streamIn);
            savedGame = (SavedGame) oi.readObject();

            oi.close();
            streamIn.close();

        } catch (Exception e){
            System.out.println("Couldn't load file!");
            // e.printStackTrace();
        }
        return savedGame;
    }

    /**
     * This method lets us save a new instance of SavedGame to a chosen file.
     * @param savedGame the instance to write to a file
     * @param fileName the filename to where we want to write the file
     */
    public static void saveGameRuntime(SavedGame savedGame, String fileName){
        try {
            FileOutputStream streamOut = new FileOutputStream(fileName+".ser", false);
            ObjectOutputStream objectOut = new ObjectOutputStream(streamOut);
            objectOut.writeObject(savedGame);

            objectOut.close();
            streamOut.close();

        } catch (Exception e) {
            //System.out.println("Couldn't save runtime to file!");
            e.printStackTrace();
        }
    }
}
