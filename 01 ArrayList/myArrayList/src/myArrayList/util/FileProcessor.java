package myArrayList.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import myArrayList.MyArrayList;

public class FileProcessor {

    private String fileName;

    public FileProcessor(String fileIn) {
        fileName = fileIn;
    }

    public void readLine(MyArrayList myArrayList) {
        try (BufferedReader lineIn = new BufferedReader(new FileReader(fileName))) {
            try {
                for (String line; (line = lineIn.readLine()) != null;) {
                    try {
                        myArrayList.insertSorted(myArrayList, Integer.parseInt(line));
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
}

