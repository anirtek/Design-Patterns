package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 19th, 2017.
 */
public class StateHighRisk implements AirportStateI {

    SecurityFactors securityFactor;
    int travellerCount, daysCount, prohibitedItemCount = 0;
    int averageTraffic, averageItems = 0;
    final String operations = "2 4 6 8 10";
    

    /**
     * Constructor
     *
     * @param currentSecurityFactorsIn
     */
    public StateHighRisk(SecurityFactors currentSecurityFactorsIn) {
        MyLogger.writeMessage("Constructor called - " + toString(), MyLogger.DebugLevel.CONSTRUCTOR);
        this.securityFactor = currentSecurityFactorsIn;
    }

    public SecurityFactors getSecurityFactor() {
        return securityFactor;
    }

    public void setSecurityFactor(SecurityFactors securityFactor) {
        this.securityFactor = securityFactor;
    }

    public int getTravellerCount() {
        return travellerCount;
    }

    public void setTravellerCount(int travellerCount) {
        this.travellerCount = travellerCount;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public int getProhibitedItemCount() {
        return prohibitedItemCount;
    }

    public void setProhibitedItemCount(int prohibitedItemCount) {
        this.prohibitedItemCount = prohibitedItemCount;
    }

    public int getAverageTraffic() {
        return averageTraffic;
    }

    public void setAverageTraffic(int averageTraffic) {
        this.averageTraffic = averageTraffic;
    }

    public int getAverageItems() {
        return averageItems;
    }

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
            MyLogger.writeMessage("State changed - " + securityFactor.getState(), MyLogger.DebugLevel.IN_RUN);
            return getOperations();
        } else if ((this.getAverageTraffic() >= 4 && this.getAverageTraffic() < 8) || (this.getAverageItems() >= 1 && this.getAverageItems() < 2)) {
            securityFactor.setState(securityFactor.getMODERATE_RISK_STATE());
            MyLogger.writeMessage("State changed - " + securityFactor.getState(), MyLogger.DebugLevel.IN_RUN);
            return securityFactor.getState().getOperations();
        } else if (this.getAverageTraffic() >= 8 || this.getAverageItems() >= 2) {
            securityFactor.setState(securityFactor.getHIGH_RISK_STATE());
            return securityFactor.getState().getOperations();
        }
        return null;
    }

    @Override
    public String toString() {
        return "STATE_HIGH_RISK";
    }
}
