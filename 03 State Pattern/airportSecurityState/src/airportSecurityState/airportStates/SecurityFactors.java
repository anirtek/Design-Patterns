package airportSecurityState.airportStates;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 19th, 2017.
 */
public class SecurityFactors {

    AirportStateI LOW_RISK_STATE;
    AirportStateI MODERATE_RISK_STATE;
    AirportStateI HIGH_RISK_STATE;
    FileProcessor fileProcessor;
    AirportStateI state;

    ArrayList<String> PROHIBITED_ITEMS;

    int numberOfProhibitedItems, numberOfTravellers, numberOfDays;

    /**
     * constructor of the Security Factor class : the context class for state
     * pattern.
     */
    public SecurityFactors() {
        MyLogger.writeMessage("Constructor called - " + toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        numberOfProhibitedItems = 0;
        numberOfTravellers = 0;
        numberOfDays = 0;
        PROHIBITED_ITEMS = new ArrayList<>();

        PROHIBITED_ITEMS.add("Blade");
        PROHIBITED_ITEMS.add("Nailcutter");
        PROHIBITED_ITEMS.add("Knife");
        PROHIBITED_ITEMS.add("Gun");
    }

    /**
     * setStateReferences() actually sets the state class instances.
     * 
     * @param lowRisk
     * @param moderateRisk
     * @param highRisk
     * @param fp 
     */
    public void setStateReferences(AirportStateI lowRisk, AirportStateI moderateRisk, AirportStateI highRisk, FileProcessor fp) {
        LOW_RISK_STATE = lowRisk;
        MODERATE_RISK_STATE = moderateRisk;
        HIGH_RISK_STATE = highRisk;
        setState(LOW_RISK_STATE);
        fileProcessor = fp;
    }

    /**
     * processInput() method processes the input line received from the fileProcessor class.
     * 
     * @param inputLine 
     */
    public void processInput(String inputLine) {
        String[] inputPass = inputLine.split(":|;");
        setNumberOfTravellers(numberOfTravellers + 1);
        setNumberOfDays(Integer.parseInt(inputPass[1]));
        if (isItemPresent(inputPass[8])) {
            setNumberOfProhibitedItems(numberOfProhibitedItems + 1);
        }
        int travellers = getNumberOfTravellers();
        int items = getNumberOfProhibitedItems();
        int days = getNumberOfDays();
        this.getState().computeAvgTraffic(travellers, days);
        this.getState().computeAvgProhititedItem(items, days);
        String operations = this.getState().tightenOrLoosenSecurity();
        fileProcessor.writeLine(operations);
    }

    /**
     * getter for LOW_RISK_STATE()
     * @return 
     */
    public AirportStateI getLOW_RISK_STATE() {
        return LOW_RISK_STATE;
    }

    /**
     * setter for LOW_RISK_STATE()
     * @param LOW_RISK_STATE 
     */
    public void setLOW_RISK_STATE(StateLowRisk LOW_RISK_STATE) {
        this.LOW_RISK_STATE = LOW_RISK_STATE;
    }

    /**
     * getter for MODERATE_RISK_STATE()
     * @return 
     */
    public AirportStateI getMODERATE_RISK_STATE() {
        return MODERATE_RISK_STATE;
    }

    /**
     * setter for MODERATE_RISK_STATE()
     * @param MODERATE_RISK_STATE 
     */
    public void setMODERATE_RISK_STATE(StateModerateRisk MODERATE_RISK_STATE) {
        this.MODERATE_RISK_STATE = MODERATE_RISK_STATE;
    }

    /**
     * getter for HIGH_RISK_STATE()
     * @return 
     */
    public AirportStateI getHIGH_RISK_STATE() {
        return HIGH_RISK_STATE;
    }

    /**
     * setter for HIGH_RISK_STATE()
     * @param HIGH_RISK_STATE 
     */
    public void setHIGH_RISK_STATE(StateHighRisk HIGH_RISK_STATE) {
        this.HIGH_RISK_STATE = HIGH_RISK_STATE;
    }
    
    /**
     * getter for current state of the airport.
     * @return 
     */
    public AirportStateI getState() {
        return state;
    }

    /**
     * Setting current state of the airport.
     * @param stateIn 
     */
    public void setState(AirportStateI stateIn) {
        this.state = stateIn;
    }

    /**
     * getter for numberOfProhibitedItems
     * @return 
     */
    public int getNumberOfProhibitedItems() {
        return numberOfProhibitedItems;
    }

    /**
     * setter for numberOfProhibitedItems
     * @param numberOfProhibitedItems 
     */
    public void setNumberOfProhibitedItems(int numberOfProhibitedItems) {
        this.numberOfProhibitedItems = numberOfProhibitedItems;
    }

    /**
     * getter for numberOfDays
     * @return 
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * setter for numberOfDays
     * @param daysIn 
     */
    public void setNumberOfDays(int daysIn) {
        this.numberOfDays = daysIn;
    }

    /**
     * getter for numberOfTravellers
     * @return 
     */
    public int getNumberOfTravellers() {
        return numberOfTravellers;
    }

    /**
     * setter for numberOfTravellers
     * @param travellersIn 
     */
    public void setNumberOfTravellers(int travellersIn) {
        this.numberOfTravellers = travellersIn;
    }

    /**
     * checks if the item received is prohibited or not
     * @param itemName
     * @return 
     */
    public boolean isItemPresent(String itemName) {
        return PROHIBITED_ITEMS.contains(itemName);
    }

    /**
     * sets the parameters of to the security factor class.
     * @param totalTravellers
     * @param totalDays
     * @param itemName 
     */
    public void setParameters(int totalTravellers, int totalDays, String itemName) {
        this.setNumberOfTravellers(totalTravellers);
        this.setNumberOfDays(totalDays);
        if (isItemPresent(itemName)) {
            this.setNumberOfProhibitedItems(numberOfProhibitedItems + 1);
        }
    }

    /**
     * computes the average traffic per day at the airport.
     */
    public void computeAvgTrafficePerDay() {
        int travellers = getNumberOfTravellers();
        int days = getNumberOfDays();
        System.out.println(travellers + "  " + days);
        AirportStateI state = this.getState();
        state.computeAvgTraffic(travellers, days);
    }

    /**
     * Computes the average number of prohibited items per day.
     */
    public void computeAvgProhibitedItemsPerDay() {
        int totalProhibited = getNumberOfProhibitedItems();
        int days = getNumberOfDays();
        state.computeAvgProhititedItem(totalProhibited, days);
    }

    /**
     * Local method for calling the actual tightenOrLoosenSecurity() method of 
     * the states of the airport.
     */
    public void tightenOrLoosenSecurity() {
        state.tightenOrLoosenSecurity();
    }

    @Override
    public String toString() {
        return "SecurityFactors (The context class)";
    }
}
