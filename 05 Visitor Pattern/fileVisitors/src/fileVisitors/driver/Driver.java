package fileVisitors.driver;

import fileVisitors.element.MyTree;
import fileVisitors.element.TreeBuilder;
import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.InputProcessor;
import fileVisitors.util.Logger;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;

/**
 * @version 5.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class Driver {

    /**
     * Driver code accepts minimum 6 number of inputs. It also validates every
     * single input including filename and debug level.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) {
        String inputFile = null;
        String outputFile = null;
        int debugLevel = 0;
        if(args.length !=  3) {
            System.err.println("Invalid number of arguments! Exiting the program.");
            System.exit(0);
        }
        try {
            inputFile = args[0];
            outputFile = args[1];
            debugLevel = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
            System.err.println(ex);
            System.exit(0);
        } 
        try {    
            if(debugLevel < 0 || debugLevel > 4) {
                throw new IllegalArgumentException("The argument " + args[2] + " is invalid. Please enter debug level between 0 and 4.");
            } else {
                Logger.setDebugValue(debugLevel);
            }
        } catch(IllegalArgumentException ex) {
            System.err.println(ex);
            System.exit(0);
        }

        /**
         * Creating instance of the FileProcessor
         */
        FileProcessor fileProc = new FileProcessor(inputFile, outputFile);
        /**
         * Creating instance of the InputProcessor
         */
        InputProcessor inputProc = new InputProcessor();

        /**
         * Create an instance of MyTree
         */
        MyTree tree = new MyTree();

        PopulateVisitor pVisitor = new PopulateVisitor();
        pVisitor.setFileProcessor(fileProc);
        pVisitor.setInputProcessor(inputProc);
        tree.accept(pVisitor);

        PalindromeHighlight phVisitor = new PalindromeHighlight();
        tree.accept(phVisitor);

        PrimeLength plVisitor = new PrimeLength();
        tree.accept(plVisitor);

        Results results = new Results(outputFile);

        PrintTree ptVisitor = new PrintTree(results);
        /**
         * Setting Results class instance as the member of PrintTree visitor.
         * As per the email clarified requirement.
         */
        tree.accept(ptVisitor);

    }
}
