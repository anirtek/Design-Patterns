package fileVisitors.store;

import fileVisitors.element.MyTree;
import fileVisitors.util.FileDisplayInterface;
import fileVisitors.util.Logger;
import fileVisitors.util.StdoutDisplayInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @version 5.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String outputFile = null;
    public ArrayList<String> status = null;

    /**
     * Constructor of the Results class.
     *
     * @param tree
     * @param outputFileName
     */
    public Results(String outputFileName) {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
        this.outputFile = outputFileName;
        status = new ArrayList<String>();
    }

    /**
     * This method stores the output line into the local ArrayList.
     *
     * @param line
     */
    public void storeLine(String line) {
        status.add(line); //getting stored into the arrayList
    }

    /**
     * Navigates on the local output Array List and writes each line into the
     * respective output file.
     *
     * @param tree
     */
    public void writeSchedulesToFile(MyTree tree) {
        for (int i = 0; i < status.size(); i++) {
            writeToFile(status.get(i));
        }
    }
    int debugLevel = 5;

    /**
     * Performs actual writing into the file specified.
     *
     * @param line
     */
    public void writeToFile(String line) {
        try {
            File outputFile = new File(this.outputFile);
            outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true));
            pw.println(line);
            pw.close();
        } catch (IOException ex) {

        }
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.store.Results"; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Overridden method for writing the output to screen.
     */
    @Override
    public void writeToScreen() {
        //MyLogger.writeMessage(outputFile, MyLogger.DebugLevel.RELEASE);
    }

}
