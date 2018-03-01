public class Discount {
	int percent = 35;
	private static Discount localInstance;

	public static Discount getInstance(){
		if(localInstance == null) {
			localInstance = new Discount();
		}
		return localInstance;
	}

	private Discount(){

	}
}
