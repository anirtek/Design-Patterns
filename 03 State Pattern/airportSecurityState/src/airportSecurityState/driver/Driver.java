package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.airportStates.SecurityFactors;
import airportSecurityState.airportStates.StateHighRisk;
import airportSecurityState.airportStates.StateLowRisk;
import airportSecurityState.airportStates.StateModerateRisk;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import java.util.IllegalFormatException;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 19th, 2017.
 */
public class Driver {

    /**
     * Main() method validates the input arguments and exits the program if any
     * thing found invalid.
     * 
     * @param args 
     */
    public static void main(String[] args) {

        String inputFileName = "", outputFileName = "";
        int debugLevel;

        /**
         * Validate input arguments if and only if equals to 3.
         */
        if (args.length < 3 || args.length > 3) {
            System.out.println("Number of input arguments are invalid.");
            System.out.println("Exiting the program.");
            System.out.println("Please try again.");
            System.exit(0);
        } else if (args.length == 3) {
            /**
             * 1. Check if first input is a string else error 
             * 2. Check if second input is a string else error 
             * 3. Check if third input is an integer else error
             */
            try {
                inputFileName = args[0];
                outputFileName = args[1];
                /**
                 * Validating the debugger level between 0 to 4
                 */
                debugLevel = Integer.parseInt(args[2]);
                MyLogger.setDebugValue(debugLevel);
                if (!(debugLevel >= 0 && debugLevel <= 4)) {
                    System.err.println("Invalid debug level input.");
                    System.err.println("Valid debug level ranges from the limits including 0 to 4.");
                    System.exit(0);
                }
            } catch (IllegalFormatException ex) {
                MyLogger.writeMessage(ex.getMessage(), MyLogger.DebugLevel.RELEASE);
                System.out.println("One of the provided input has an illegal format.");
                System.exit(0);
            }
        }

        /**
         * Create object of File Processor
         */
        FileProcessor fp = new FileProcessor(inputFileName, outputFileName);

        /**
         * Create object of Security Factor [the context class]
         */
        SecurityFactors securityFactor = new SecurityFactors();

        /**
         * Create the objects of all the state classes - (I) Low Risk state (II)
         * Moderate Risk state (III) High Risk state
         */
        AirportStateI lowRisk = new StateLowRisk(securityFactor);
        AirportStateI moderateRisk = new StateModerateRisk(securityFactor);
        AirportStateI highRisk = new StateHighRisk(securityFactor);

        /**
         * Store references of the state objects in the Security Factors
         */
        securityFactor.setStateReferences(lowRisk, moderateRisk, highRisk, fp);

        /**
         * Read the inputFile
         */
        fp.readLine(securityFactor);
    }
}
