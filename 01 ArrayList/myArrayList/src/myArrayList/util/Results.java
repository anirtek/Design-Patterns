package myArrayList.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myArrayList.MyArrayList;

/**
 *
 * @author anirtek
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    public ArrayList<String> testResults = new ArrayList<String>();
    public String outFileName;
    boolean plug = true;

    public Results(String outFile) {
        outFileName = outFile;
    }

    public void addSumToResults(MyArrayList myArrayList, Results results) {
        int sum = myArrayList.sum();
        String arraySum = String.valueOf(sum);
        arraySum = "The sum of all the values in the array list is: ".concat(arraySum);
        results.testResults.add(arraySum);
    }

    public void writeToFile(String s) {
        try {
            BufferedWriter bw = null;
            FileWriter fw = null;
            
            File outputfile = new File(outFileName);
            outputfile.createNewFile();
            try {
                //System.out.println("I am here now");
//                FileOutputStream fout = new FileOutputStream(outputfile, true);
                PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(outputfile, true)), true);
                fout.println(s);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void writeToStdout(String s) {
        if (plug) {
            System.out.println("Output printing from writeToStdout() function of Results class . . .");
            System.out.println("==============================================================");
            plug = false;
        }
        System.out.println(s);
    }

}

