package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controls {

	public String OperationalSystem() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void callProcess(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String row = buffer.readLine();
			while(row != null ) {
				System.out.println(row);
				try {
					row = buffer.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(row);
			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void taskList(String os) {
		String process = "";
		process= os.contains("Windows") ? "tasklist" : "ps -e";
		callProcess(process);
	}
	public void kill(String os, String victim) {
		String process = "";
		process= os.contains("Windows") ? "taskkill /im " + victim + " /f" : victim.matches("^[0-9]*$") ? "kill " + victim: "pkill " + victim;
		callProcess(process);
	}

}
