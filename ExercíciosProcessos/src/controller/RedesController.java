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

	public String callProcess(String process, String adapterSubstringStart, String adapterSubstringEnd,
			String ipSubstringStart, String ipSubstringEnd, String containsAdapterIdentifier,
			String containsIpIdentifier) {
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
				if (process.contains("ip")) {
					if (row.contains(containsAdapterIdentifier)) {
						adapter = row.substring(row.indexOf(adapterSubstringStart),
								row.lastIndexOf(adapterSubstringEnd));
					} else if (row.contains(containsAdapterIdentifier)) {
						adapter = row;
					}

					if (row.contains(containsIpIdentifier)) {
						ip = row.substring(row.indexOf(ipSubstringStart) + 1, row.lastIndexOf(ipSubstringEnd));
					} else if (row.contains(containsIpIdentifier)) {
						ip = row;
					}

					if (adapter != "" && ip != "") {
						message += adapter.trim() + ": " + ip.trim() + "\n";
						ip = "";

					}
					row = buffer.readLine();
				}else {
					if(process.contains("-n")) {
						
					}else if(process.contains("-c")) {
						
					}
				}
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
			String adapterSubstringStart = "Adaptador";
			String adapterSubstringEnd = ":";
			String ipSubstringStart = ": ";
			String ipSubstringEnd = "";
			String containsAdapterIdentifier = "Adaptador";
			String containsIpIdentifier = "IPv4";

			System.out.println(callProcess(process, adapterSubstringStart, adapterSubstringEnd, ipSubstringStart,
					ipSubstringEnd, containsAdapterIdentifier, containsIpIdentifier));

		} else if (os.contains("Linux")) {
			String process = "ip address";
			String adapterSubstringStart = " ";
			String adapterSubstringEnd = ":";
			String ipSubstringStart = "t ";
			String ipSubstringEnd = "/";
			String containsAdapterIdentifier = "mtu";
			String containsIpIdentifier = "inet ";

			System.out.println(callProcess(process, adapterSubstringStart, adapterSubstringEnd, ipSubstringStart,
					ipSubstringEnd, containsAdapterIdentifier, containsIpIdentifier));

		} else {
			System.out.println("SO não reconhecido");
		}
	}

	public void ping(String os) {
		String process;
		if(os.contains("Windows")) {
			process = "ping -n 10 ";
		}else if(os.contains("Linux")) {
			process = "ping -c 10 google.com";
		}

	}
}
