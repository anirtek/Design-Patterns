public class PowerAdapter implements EuropeInter {
	USPlugs plug;

	/* Adapter constructor */
	public PowerAdapter(USPlugs plugIn) {
		this.plug = plugIn;
	}

	public void useSquaredPlug(){
		plug.useRectPlug();
	}

	public void charge(){
		plug.charge();
	}
}
