package InternalPackages;

public class Shutdown {
	public static void init() {
		print("Stopping OS.");
		print("Complete.");
		System.exit(0);
	}
	public static void print(String s) {
		System.out.println("Shutdown [INFO]: " + s);
	}
}
