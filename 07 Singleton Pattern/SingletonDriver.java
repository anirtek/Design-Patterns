public class SingletonDriver {
	public static void main(String[] args) {
		Discount disc1 = Discount.getInstance(); //get the object of singleton class Discount
		System.out.println("First instance of Discount has percentage = " + disc1.percent);

		Discount disc2 = Discount.getInstance(); //get another object of singleton class Discount
		System.out.println("Second instance of Discount has percentage = " + disc2.percent);

		//Let's try to set new value to the percent and check if it also reflects in the first instance too
		disc2.percent = 45; //changed fro 35 to 45.

		System.out.println("Changed percentage of second instance!");
		System.out.println("Value of percent with first Discout instance = " + disc1.percent);

		//Second check : Addresses of both the instances on heap memory.
		System.out.println("Addresses of both instance(s) of Discount class on heap memory ... ");
		System.out.println("Fist instance located at " + disc1.hashCode() + "\nsecond instance located at " + disc2.hashCode());

	}
}
