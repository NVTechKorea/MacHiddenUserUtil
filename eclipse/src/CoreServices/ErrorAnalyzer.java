package CoreServices;
import java.util.Random;

import CoreFramework.InfoServer;
import CoreModules.WriteFile;
import InternalPackages.Shutdown;
// Module Code: system.dreampackage.erroranalyzer
public class ErrorAnalyzer{
	public ErrorAnalyzer(){}
	public void initiate(Exception e, String process, boolean debug){
		String er = e.toString();
		uiprint("Process: " + process);
		if(er.contains("NullPointerException")){
			uiprint("NullPointerException found.");
			uiprint("Please check all the variables are correct, or contact to software manufacturer.");
		}else if (er.contains("ArrayIndexOutOfBoundsException")) {
			uiprint("ArrayIndexOutOfBoundsException found.");
			uiprint("Please check whether you entered too many items.");
		}else if (er.contains("NoClassDefFoundError")) {
			uiprint("NoClassDefFoundError found.");
		}else if (er.contains("FileNotFoundException")) {
			uiprint("FileNotFoundException found.");
			uiprint("Please check all resource files are located correctly.");
		}else if (er.contains("ClassNotFoundException")) {
			uiprint("ClassNotFoundException found.");
			uiprint("Please check wheter you've renamed system file, or script is compiled.");
		}else if (er.contains("NoSuchElement")) {
			uiprint("NoSuchElement found.");
			uiprint("Please report this error to the developer.");
		}else{
			uiprint("Unknown error. Running printStackTrace only.");
		}
		if(true){
			uiprint("/////////////PANIC/////////////");
			e.printStackTrace();
			uiprint("///////////////////////////////");	
			uiprint("Please report this error to the developer. Thanks.");
			uiprint("Trying to write report in: /data/error_report_" + process + ".txt");
			try {
				InfoServer infod = new InfoServer();
				WriteFile wf = new WriteFile();
				Random rand = new Random();
				int random = rand.nextInt(10000000)+10;
				wf.writeError(infod.getCertainPath("data") +"error_report_id_" + random + ".txt", e);
				uiprint("Process finished.");
				Shutdown.init();
			}catch(Exception ee) {
				uiprint("File writing error. Please report the panic error to the developer.");
				Shutdown.init();
			}
		}
	}
	public static void uiprint(String s){
		System.out.println("E-ANALYZER [INFO]: " + s);
	}
}