package CoreServices;
import CoreFramework.InfoServer;
import CoreModules.*;
public class Installer {
	DeleteFile df = null;
	DeleteFolder rm = null;
	DownloadHelper dh = null;
	MakeDir md = null;
	ReadFile rf = null;
	WriteFile wf = null;
	InfoServer infod = null;
	public void init() {
		print("Entered installer.");
		df = new DeleteFile();
		rm = new DeleteFolder();
		dh = new DownloadHelper();
		md = new MakeDir();
		rf = new ReadFile();
		wf = new WriteFile();
		infod = new InfoServer();
		print("Setting up storage...");
		InfoServer infod = new InfoServer();
		setupStorage(infod);
		setupDefaultPref(infod);
		print("Setup complete.");
	}
	public void setupDefaultPref(InfoServer infod) {
		wf.initiate(infod.getCertainPath("pref") + "writeEncryptedData.pref", "true");
		wf.initiate(infod.getCertainPath("pref") + "readEncryptedData.pref", "true");
		wf.initiate(infod.getCertainPath("pref") + "lockRootRW.pref", "true");
		wf.initiate(infod.getCertainPath("pref") + "registry.pref", "<empty>");
	}
	public void setupStorage(InfoServer infod) {
		MakeDir makeDir = new MakeDir();
		String path = infod.getUserDirectory() + infod.getDirectoryIdentifier() + infod.getManufacturer();
		makeDir.initiate(path);
		path = path + infod.getDirectoryIdentifier() + infod.getSystemName();
		makeDir.initiate(path);
		path = path + infod.getDirectoryIdentifier() + infod.getVersion();
		makeDir.initiate(path);
		path = infod.getCertainPath("var");
		makeDir.initiate(path);
		path = infod.getCertainPath("system");
		makeDir.initiate(path);
		path = infod.getCertainPath("data");
		makeDir.initiate(path);
		path = infod.getCertainPath("installer");
		makeDir.initiate(path);
		path = infod.getCertainPath("als");
		makeDir.initiate(path);
		path = infod.getCertainPath("exec");
		makeDir.initiate(path);
		path = infod.getCertainPath("pref");
		makeDir.initiate(path);
	}
	public void installPackage(String s) {
		String pkg = "null";
		if(s.contains("sideload")) {
			pkg = "user.dneo.sideload";
		}else if(s.contains("r3ality")) {
			pkg = "system.dneo.reality";
		}else {
			pkg = "unspecified";
		}
		print("Finding header...");
		try {
			print("Installing: " + pkg);
			print("Querying location..");
			Thread.sleep(500);
			print("Unpacking package...");
			print("10%");
			Thread.sleep(100);
			print("30%");
			Thread.sleep(100);
			print("50%");
			Thread.sleep(100);
			print("60%");
			Thread.sleep(100);
			print("77%");
			Thread.sleep(100);
			print("90%");
			Thread.sleep(100);
			print("100%");
			Thread.sleep(50);
			print("Moving package to installer directory...");
			print("10%");
			Thread.sleep(100);
			print("20%");
			Thread.sleep(100);
			print("40%");
			Thread.sleep(100);
			print("80%");
			Thread.sleep(100);
			print("89%");
			Thread.sleep(100);
			print("96%");
			Thread.sleep(100);
			print("99%");
			Thread.sleep(50);
			print("100%");
			print("Done.");
		}catch(Exception e) {
			
		}
	}
	public static void print(String s) {
		System.out.println("Installer [INFO]: " + s);
	}
}
