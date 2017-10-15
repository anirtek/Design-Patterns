package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class FileProcessor {

    final private String inputFileName, deleteInput, output_1, output_2, output_3;

    /**
     * Parameterized constructor of the class that sets the different filename
     * received from the command line to the local fileName variables.
     *
     * @param fileIn
     * @param deleteIn
     * @param fileOut_1
     * @param fileOut_2
     * @param fileOut_3
     */
    public FileProcessor(String fileIn, String deleteIn, String fileOut_1,
            String fileOut_2, String fileOut_3) {

        /*Creating input file*/
        if (fileIn != null) {
            inputFileName = fileIn;
        } else {
            inputFileName = "src/input.txt";
        }
        /*Creating delete input file*/
        if (deleteIn != null) {
            deleteInput = deleteIn;
        } else {
            deleteInput = "src/delete.txt";
        }
        /*creating output file*/
        if (fileOut_1 != null) {
            output_1 = fileOut_1;
        } else {
            output_1 = "src/output_1.txt";
        }

        if (fileOut_2 != null) {
            output_2 = fileOut_2;
        } else {
            output_2 = "src/output_2.txt";
        }

        if (fileOut_3 != null) {
            output_3 = fileOut_3;
        } else {
            output_3 = "src/output_3.txt";
        }
    }

    /**
     * This method performs the reading operation on the input line and
     * separates the b_number and the courseName facilitating the the easy node
     * creation in the TreeBuilder class.
     *
     * @param builder
     */
    public void readLine(TreeBuilder builder) {
        HashMap<Integer, Integer> uniqueInput = new HashMap<Integer, Integer>();
        try (BufferedReader lineIn = new BufferedReader(new FileReader(inputFileName))) {
            try {
                for (String line; (line = lineIn.readLine()) != null;) {
                    try {
                        /**
                         * Break the input line into b_number and course names.
                         * Keep adding the b_number into a HashMap so as to
                         * maintain unique input data
                         */
                        String[] inputPass = line.split(":");
                        int b_number = Integer.parseInt(inputPass[0]);
                        String courseName = inputPass[1];
                        /**
                         * Adding the b_number first
                         */
                        if (!uniqueInput.containsKey(b_number)) {
                            builder.makeNodeObjects(b_number, courseName);
                            uniqueInput.put(b_number, 1);
                        } else {
                            builder.addCourse(b_number, courseName);
                            continue;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println(ex);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } finally {
                lineIn.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * this method reads the delete input file and separates the b_number and
     * courseName so as to help the deletion method of Tree class to remove the
     * course from the node.
     *
     * @param builder
     */
    public void deleteLine(TreeBuilder builder) {
        try (BufferedReader lineIn = new BufferedReader(new FileReader(deleteInput))) {
            try {
                for (String line; (line = lineIn.readLine()) != null;) {
                    try {
                        /**
                         * Break the input line into b_number and course names.
                         * Keep adding the b_number into a HashMap so as to
                         * maintain unique input data
                         */
                        String[] inputPass = line.split(":");
                        int b_number = Integer.parseInt(inputPass[0]);
                        String courseName = inputPass[1];
                        /**
                         * Adding the b_number first
                         */
                        builder.removeCourse(b_number, courseName);
                    } catch (NumberFormatException ex) {
                        System.out.println(ex);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex);
            } finally {
                lineIn.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Additional method to write to any file if required.
     *
     * @param outputLine
     */
    public void writeLine(String outputLine) {
        try {
            File outputFile = new File("src/output.txt");
            outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true));
            pw.println(outputLine);
            pw.close();
        } catch (IOException ex) {

        }
    }
}

