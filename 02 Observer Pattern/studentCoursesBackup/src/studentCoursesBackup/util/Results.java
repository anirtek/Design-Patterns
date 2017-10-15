package studentCoursesBackup.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import studentCoursesBackup.myTree.MyTree;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class Results {

    private MyTree tree;
    private String outputFile = "";
    public ArrayList<String> status;

    /**
     * Constructor of the Results class.
     *
     * @param tree
     * @param outputFileName
     */
    public Results(MyTree tree, String outputFileName) {
        this.tree = tree;
        this.outputFile = outputFileName;
        status = new ArrayList<String>();
    }

    /**
     * This method stores the output line into the local ArrayList.
     *
     * @param line
     */
    public void storeLine(String line) {
        status.add(line);
    }

    /**
     * Navigates on the local output Array List and writes each line into the
     * respective output file.
     */
    public void writeToFile() {
        for (int i = 0; i < status.size(); i++) {
            writeLine(status.get(i));
        }
    }

    /**
     * Performs actual writing into the file specified.
     *
     * @param line
     */
    public void writeLine(String line) {
        try {
            File outputFile = new File(this.outputFile);
            outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true));
            pw.println(line);
            pw.close();
        } catch (IOException ex) {

        }
    }

}

