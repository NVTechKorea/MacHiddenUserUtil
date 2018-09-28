package InternalPackages;

import CoreFramework.InfoServer;
import CoreModules.ReadFile;
import CoreModules.WriteFile;

public class Chpref {
	public void init(String in) {
		if(!in.contains(" ")){
			print("Wrong format!");
			print("Usage: chpref [option name / all] [option]");
		}else{
			String inParse[] = in.split(" ");
			int leng = inParse.length; 
			if(leng==3){
				chpref(inParse[1], inParse[2]);
			}else{
				print("Wrong format!");
				print("Usage: chpref [option name / all] [option]");
			}
		}
	}
	public void chpref(String key, String val) {
		WriteFile wf = new WriteFile();
		InfoServer infod = new InfoServer();
		if(key.equals("all")) {
			print("Setting is only applied to boolean.");
		}else if(key.equals("writeEncryptedData")) {
			if(val.equals("true")) {
				wf.initiate(infod.getCertainPath("pref") + "writeEncryptedData.pref", "true");
			}else if(val.equals("false")) {
				wf.initiate(infod.getCertainPath("pref") + "writeEncryptedData.pref", "false");
			}else {
				print("No such option. Only true/false");
			}
		}else if(key.equals("readEncryptedData")) {
			if(val.equals("true")) {
				wf.initiate(infod.getCertainPath("pref") + "readEncryptedData.pref", "true");
			}else if(val.equals("false")) {
				wf.initiate(infod.getCertainPath("pref") + "readEncryptedData.pref", "false");
			}else {
				print("No such option. Only true/false");
			}
		}else if(key.equals("lockRootRW")) {
			if(val.equals("true")) {
				wf.initiate(infod.getCertainPath("pref") + "lockRootRW.pref", "true");
			}else if(val.equals("false")) {
				wf.initiate(infod.getCertainPath("pref") + "lockRootRW.pref", "false");
			}else {
				print("No such option. Only true/false");
			}
		}else if(key.equals("add-registry")) {
			ReadFile rf = new ReadFile();
			String data = rf.initiate(infod.getCertainPath("pref") + "registry.pref");
			wf.initiate(infod.getCertainPath("pref") + "registry.pref", data + "; " + val);
		}else if(key.equals("remove-registry")) {
			ReadFile rf = new ReadFile();
			String data = rf.initiate(infod.getCertainPath("pref") + "registry.pref");
			String[] p = data.split("; ");
			int address = 0;
			for(int i = 0; i<p.length; i++) {
				if(p[i].equals(val)) {
					address = i;
					break;
				}else {
					address = i;
				}
			}
			if(address==p.length) {
				print("Data not found in registry.");
			}else {
				p[address] = "";
				data = "";
				for(int i = 0; i<p.length; i++) {
					data = data + p[i] + "; ";
				}
				wf.initiate(infod.getCertainPath("pref") + "registry.pref", data);
			}
		}
	}
	public void print(String s) {
		System.out.println(s);
	}
}
