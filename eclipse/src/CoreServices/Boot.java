package CoreServices;

import CoreFramework.InfoServer;
import CoreFramework.InitialRun;

public class Boot {
	public void init(boolean krlang) {
		InfoServer infod = new InfoServer();
		print("Bootloader info:");
		print("Name: Dynamic Neo Bootloader XII");
		print("Version: 12.6");
		print("OS to boot: " + infod.getSystemName() + " " + infod.getVersion());
		try {
			InitialRun ir = new InitialRun();
			ir.init();
			CoreNavigator.init();
		}catch(Exception e) {
			ErrorAnalyzer ea = new ErrorAnalyzer();
			ea.initiate(e, "Main", false);
		}
	}
	public static void print(String s) {
		System.out.println("Boot [INFO]: " + s);
	}
}
