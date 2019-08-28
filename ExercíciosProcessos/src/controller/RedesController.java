package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public String OperationalSystem() {
		String os = System.getProperty("os.name");
		return os;
	}

	public String callProcess(String process) {
		String message = "";
		String adapter = "";
		String ip = "";
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String row = buffer.readLine();
			while (row != null) {

				if (row.contains("enp") || row.contains("wlp")) {
					adapter = row.substring(0, (row.indexOf(":")));
				} else if(row.contains("Adaptador")){
					adapter = row;
				}

				if (row.contains("inet ")) {
					ip = row.substring(0, (row.lastIndexOf(" netmask")));
				} else if(row.contains("IPv4")){
					ip = row;
				}

				if (adapter != "" && ip != "") {
					message += adapter.trim() + ": " + ip.trim() + "\n";
					ip = "";

				}
				row = buffer.readLine();
			}
			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return message;
	}

	public void ip(String os) {

		if (os.contains("Windows")) {
			String process = "ipconfig";
			String adapter = "";
			String ip = "";

			System.out.println(callProcess(process));

		} else if (os.contains("Linux")) {
			String process = "ifconfig";

			System.out.println(callProcess(process));

		} else if (os.contains("Mac")) {

		} else {
			System.out.println("SO não reconhecido");
		}

	}

	public void ping() {

	}
}
