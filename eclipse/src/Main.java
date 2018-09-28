// Module Code: system.dreampackage.main
import CoreServices.Boot;
public class Main{
	public static void main(String[] args) {
		boolean krlang = false;
		if(args.length==1) {
			if(args[0].equals("lang=kr")) {
				krlang = true;
			}
		}
		Boot bootloader = new Boot();
		bootloader.init(krlang);
	}
}