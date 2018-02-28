public class ChargingSystem {
	public static void main(String[] args) {
		EuropePlugs europeSystem = new EuropePlugs(); //europe power system
		USPlugs usSystem = new USPlugs();
		EuropeInter adapter = new PowerAdapter(usSystem); //adapter enabled with europe system

		/* Journey started to France */
		System.out.println("I'm in the United Stated leaving for the France...");
		usSystem.useRectPlug();
		usSystem.charge();

		System.out.println("Reached France but laptop is discharged!");
		adapter.useSquaredPlug();
		adapter.charge();

		System.out.println("Finally. The laptop is charged. Thanks to the US to Europe Adapter!");
	}
}
