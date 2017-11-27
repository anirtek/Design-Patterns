package fileVisitors.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @version 5.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class FileProcessor {

    private String inputFileName = "", outputFileName = "";
    private Scanner in = null;

    /**
     * Parameterized constructor of the class that sets the different filename
     * received from the command line to the local fileName variables.
     *
     * @param inputFileIn
     * @param outputFileIn
     */
    public FileProcessor(String inputFileIn, String outputFileIn) {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
        if (inputFileIn == null) {
            System.err.println("Input File name is null!");
            System.exit(0);
        } else {
            this.inputFileName = inputFileIn;
        }
        if (outputFileIn == null) {
            System.err.println("Output File name is null!");
            System.exit(0);
        } else {
            this.outputFileName = outputFileIn;
        }
        File inputFile = new File(inputFileName);
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found! Please try again");
        }
    }

    /**
     * This method performs the reading operation on the input line and
     * separates the b_number and the courseName facilitating the the easy node
     * creation in the TreeBuilder class.
     *
     * @param sf
     */
    public String readLine() {
        String line = "";
        try {
            if (in == null) {
                throw new RuntimeException("File is closed!");
            }
            while (in.hasNext()) {
                line = in.next();
                return line;
            }
            line = null;
            return line;
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeInScanner() {
        if (in != null) {
            in.close();
            in = null;
        }
    }

    /**
     * Additional method to write to any file if required.
     *
     * @param outputLine
     */
    public void writeLine(String outputLine) {
        try {
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true))) {
                pw.println(outputLine);
            }
        } catch (IOException ex) {
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.util.FileProcessor";
    }

}
