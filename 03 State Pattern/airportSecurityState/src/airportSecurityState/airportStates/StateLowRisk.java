package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 19th, 2017.
 */
public class StateLowRisk implements AirportStateI {
    
    SecurityFactors securityFactor;
    int travellerCount, daysCount, prohibitedItemCount = 0;
    int averageTraffic, averageItems = 0;
    final String operations = "1 3 5 7 9";

    /**
     * Constructor
     * @param currentSecurityFactorsIn
     */
    public StateLowRisk(SecurityFactors currentSecurityFactorsIn) {
        MyLogger.writeMessage("Constructor called - " + toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.securityFactor = currentSecurityFactorsIn;
    }
    
    /**
     * getter for getting instance of security factor class
     * @return 
     */
    public SecurityFactors getSecurityFactor() {
        return securityFactor;
    }
    
    /**
     * setter for setting instance of the security factor class
     * @param securityFactor 
     */
    public void setSecurityFactor(SecurityFactors securityFactor) {
        this.securityFactor = securityFactor;
    }
    
    /**
     * getter for getting travellers count.
     * @return 
     */
    public int getTravellerCount() {
        return travellerCount;
    }
    
    /**
     * setting the number of the travellers.
     * @param travellerCount 
     */
    public void setTravellerCount(int travellerCount) {
        this.travellerCount = travellerCount;
    }
    
    /**
     * getter for total days count.
     * @return 
     */
    public int getDaysCount() {
        return daysCount;
    }
    
    /**
     * setter for total days count.
     * @param daysCount 
     */
    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }
    
    /**
     * getting number of prohibited items.
     * @return 
     */
    public int getProhibitedItemCount() {
        return prohibitedItemCount;
    }
    
    /**
     * setting the number of the prohibited items.
     * @param prohibitedItemCount 
     */
    public void setProhibitedItemCount(int prohibitedItemCount) {
        this.prohibitedItemCount = prohibitedItemCount;
    }
    
    /**
     * getter for getting average traffic when the state is LOW_RISK.
     * @return 
     */
    public int getAverageTraffic() {
        return averageTraffic;
    }
    
    /**
     * setter for setting the average traffic when the state is LOW_RISK
     * @param averageTraffic 
     */
    public void setAverageTraffic(int averageTraffic) {
        this.averageTraffic = averageTraffic;
    }
    
    /**
     * getter for average number of prohibited items
     * @return 
     */
    public int getAverageItems() {
        return averageItems;
    }
    
    /**
     * setter for average number of prohibited items
     * @param averageItems 
     */
    public void setAverageItems(int averageItems) {
        this.averageItems = averageItems;
    }
    
    @Override
    public String getOperations() {
        MyLogger.writeMessage("Operations Performed for " + toString() + " = " + operations, MyLogger.DebugLevel.IN_RESULTS);
        return operations;
    }
    
    @Override
    public void computeAvgTraffic(int totalTravellers, int totalDays) {
        this.setAverageTraffic(totalTravellers / totalDays);
    }
    
    @Override
    public void computeAvgProhititedItem(int itemsCount, int totalDays) {
        this.setAverageItems(itemsCount / totalDays);
    }
    
    @Override
    public String tightenOrLoosenSecurity() {
        if ((this.getAverageTraffic() >= 0 && this.getAverageTraffic() < 4) || (this.getAverageItems() >= 0 && this.getAverageItems() < 1)) {
            securityFactor.setState(securityFactor.getLOW_RISK_STATE());
            return getOperations();
        } else if ((this.getAverageTraffic() >= 4 && this.getAverageTraffic() < 8) || (this.getAverageItems() >= 1 && this.getAverageItems() < 2)) {
            securityFactor.setState(securityFactor.getMODERATE_RISK_STATE());
            MyLogger.writeMessage("State changed - " + securityFactor.getState(), MyLogger.DebugLevel.IN_RUN);
            return securityFactor.getState().getOperations();
        } else if (this.getAverageTraffic() >= 8 || this.getAverageItems() >= 2) {
            securityFactor.setState(securityFactor.getHIGH_RISK_STATE());
            MyLogger.writeMessage("State changed - " + securityFactor.getState(), MyLogger.DebugLevel.IN_RUN);
            return securityFactor.getState().getOperations();
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "STATE_LOW_RISK";
    }
}
