package studentCoursesBackup.driver;

import studentCoursesBackup.myTree.MyTree;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class Driver {

    /**
     * Driver class contains the main() method to run this project.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Input file variables & validating the number of input parameters.
         */
        String inputFileName = "", deleteInput = "", orig_outputFile = "", bkp_1_outputFile = "", bkp_2_outputFile = "";

        if (args.length < 5 || args.length > 5) {
            System.out.println("Invalid number of command line arguments! \n"
                    + "Exiting the program. \n"
                    + " Please try again with only 5 valid arguments.");
            System.exit(0);
        } else {
            inputFileName = args[0];
            deleteInput = args[1];
            orig_outputFile = args[2];
            bkp_1_outputFile = args[3];
            bkp_2_outputFile = args[4];
        }

        FileProcessor fp = new FileProcessor(inputFileName, deleteInput,
                orig_outputFile, bkp_1_outputFile, bkp_2_outputFile);

        /**
         * Creating the MyTree objects
         */
        MyTree tree = new MyTree();
        MyTree backupTree_1 = new MyTree();
        MyTree backupTree_2 = new MyTree();

        /**
         * The TreeBuilder class is available in the package util. This class is
         * responsible for making clones of the original tree nodes.
         */
        TreeBuilder builder = new TreeBuilder(tree, backupTree_1, backupTree_2);

        /**
         * Reading the input.txt file and creating node for each line.
         */
        fp.readLine(builder);
        
        /**
         * Reading the delete.txt file to delete the courses.
         */
        fp.deleteLine(builder);

        /**
         * Creating 3 separate Results class objects to store the output.
         */
        Results resultsOrig = new Results(tree, orig_outputFile);
        Results resultsBackup_1 = new Results(tree, bkp_1_outputFile);
        Results resultsBackup_2 = new Results(tree, bkp_2_outputFile);

        /**
         * Calling printNodes() method of MyTree class.
         */
        tree.printNodes(resultsOrig);
        tree.printNodes(resultsBackup_1);
        tree.printNodes(resultsBackup_2);

        /**
         * Creating objects of the FileDisplayInterface class.
         */
        FileDisplayInterface fdi_orig = new FileDisplayInterface(resultsOrig);
        FileDisplayInterface fdi_1 = new FileDisplayInterface(resultsBackup_1);
        FileDisplayInterface fdi_2 = new FileDisplayInterface(resultsBackup_2);

        /**
         * Writing stored output from Results to the respective output files.
         */
        fdi_orig.processOutput();
        fdi_1.processOutput();
        fdi_2.processOutput();
    }

}

