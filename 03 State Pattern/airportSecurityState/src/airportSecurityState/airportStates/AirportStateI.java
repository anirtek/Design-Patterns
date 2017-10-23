package airportSecurityState.airportStates;

/**
 *
 * @author anirtek
 */
public interface AirportStateI {
 
    public String tightenOrLoosenSecurity();
    
    public String getOperations();

    public void computeAvgTraffic(int totalTravellers, int totalDays);

    public void computeAvgProhititedItem(int itemsCount, int totalDays);
}
