package InternalPackages;

import CoreFramework.InfoServer;
import CoreModules.ReadFile;

public class Rdpref {
	public void init(String in) {
		if(!in.contains(" ")){
			print("Wrong format!");
			print("Usage: rdpref [option name / all] [option]");
		}else{
			String inParse[] = in.split(" ");
			int leng = inParse.length; 
			if(leng==2){
				rdpref(inParse[1]);
			}else{
				print("Wrong format!");
				print("Usage: rdpref [option name / all] [option]");
			}
		}
	}
	public void rdpref(String key) {
		ReadFile rf = new ReadFile();
		InfoServer infod = new InfoServer();
		if(key.equals("all")) {
			print("Setting is only applied to boolean.");
		}else if(key.equals("writeEncryptedData")) {
			print(rf.initiate(infod.getCertainPath("pref") + "writeEncryptedData.pref"));
		}else if(key.equals("readEncryptedData")) {
			print(rf.initiate(infod.getCertainPath("pref") + "readEncryptedData.pref"));
		}else if(key.equals("lockRootRW")) {
			print(rf.initiate(infod.getCertainPath("pref") + "lockRootRW.pref"));
		}else if(key.equals("registy")) {
			print(rf.initiate(infod.getCertainPath("pref") + "registry.pref"));
		}else {
			print("No such option.");
		}
	}
	public void print(String s) {
		System.out.println(s);
	}
}
