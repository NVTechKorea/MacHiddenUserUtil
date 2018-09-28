package CoreFramework;
import java.io.File;

import CoreModules.WriteFile;
import CoreServices.Installer;
import Security.PostSignatureCheck;
import Security.SignatureCheck;
public class InitialRun {
	public void init() {
		print("RunManager entered.");
		InfoServer infod = new InfoServer();
		print("Checking inital run history...");
		String path = infod.getCertainFile("firstRunFlag");
		File file = new File(path);
		if(!file.exists()) {
			print("No history found.");
			print("Running installer...");
			Installer installer = new Installer();
			installer.init();
			setupFlag(infod);
			SignatureCheck sigchk = new SignatureCheck();
			sigchk.regvar();
			sigchk.initiate();
		}else {
			print("Running directly to Core...");
			PostSignatureCheck psc = new PostSignatureCheck();
			psc.regvar();
			psc.initiate();
		}
	}
	public void setupFlag(InfoServer infod) {
		String path = infod.getCertainFile("firstRunFlag");
		WriteFile wf = new WriteFile();
		wf.initiate(path, "");
	}
	
	public static void print(String s) {
		System.out.println("InitialRunManager [INFO]: " + s);
	}
}
