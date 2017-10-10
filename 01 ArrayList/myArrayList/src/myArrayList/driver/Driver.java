package myArrayList.driver;

import java.io.File;
import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;
import myArrayList.util.FileProcessor;

public class Driver {

    public static void main(String[] args) {
        String inputFileName = "", outputFileName ="";
        FileProcessor file = null;
        Results results = null;

        if(args.length > 0) {
            inputFileName = args[0];
            outputFileName = args[1];
        }

        if(inputFileName == null) {
            System.out.println("Input File name is not provided. Stopping the program. Please try again!");
            System.exit(0);
        } else {
            file = new FileProcessor(inputFileName);
        }

        if(inputFileName != null && outputFileName == null) {
            outputFileName = "src/output.txt";
        } else {
            results = new Results(outputFileName);
        }

        MyArrayList myArrayList = new MyArrayList();

        file.readLine(myArrayList); //reading the file, inserted data into MyArrayList

        int sum = myArrayList.sum(); //get the sum of all the data

        results.addSumToResults(myArrayList, results); //sum added to results

        MyArrayListTest myArrayListTest = new MyArrayListTest();

        myArrayListTest.testMe(myArrayList, results); // run test cases on myArrayList and feed data into results

        for (int iterator = 0; iterator < results.testResults.size(); iterator++) {
            results.writeToStdout(results.testResults.get(iterator));
            results.writeToFile(results.testResults.get(iterator));
        }
    }

}
