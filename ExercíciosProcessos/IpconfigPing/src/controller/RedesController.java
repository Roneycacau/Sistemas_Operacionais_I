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

	public String callProcess(String process, String os) {
		String message = "";
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream flow = p.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reader);
			String row = buffer.readLine();

			message = formatString(buffer, row, process, os, message);

			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return message;
	}

	private String formatString(BufferedReader buffer, String row, String process, String os, String message) {
		String adapter = "";
		String ip = "";
		while (row != null) {
			if (process.contains("ip")) {
				if (os.contains("Windows")) {
					String adapterSubstringStart = "Adaptador";
					String adapterSubstringEnd = ":";
					String ipSubstringStart = ": ";
					String ipSubstringEnd = "";
					String containsAdapterIdentifier = "Adaptador";
					String containsIpIdentifier = "IPv4";
					if (row.contains(containsAdapterIdentifier)) {
						adapter = row.substring(row.indexOf(adapterSubstringStart),
								row.lastIndexOf(adapterSubstringEnd));
					}
					if (row.contains(containsIpIdentifier)) {
						ip = row.substring(row.indexOf(ipSubstringStart) + 1, row.lastIndexOf(ipSubstringEnd));
					}
					if (adapter != "" && ip != "") {
						message += adapter.trim() + ": " + ip.trim() + "\n";
						ip = "";
					}
				} else if (os.contains("Linux")) {
					String adapterSubstringStart = " ";
					String adapterSubstringEnd = ":";
					String ipSubstringStart = "t ";
					String ipSubstringEnd = "/";
					String containsAdapterIdentifier = "mtu";
					String containsIpIdentifier = "inet ";

					if (row.contains(containsAdapterIdentifier)) {
						adapter = row.substring(row.indexOf(adapterSubstringStart),
								row.lastIndexOf(adapterSubstringEnd));
					}
					if (row.contains(containsIpIdentifier)) {
						ip = row.substring(row.indexOf(ipSubstringStart) + 1, row.lastIndexOf(ipSubstringEnd));
					}
					if (adapter != "" && ip != "") {
						message += adapter.trim() + ": " + ip.trim() + "\n";
						ip = "";
					}
				}
				try {
					row = buffer.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				if (process.contains("-n")) {
					System.out.print("Calculando");
					while (row != null) {
						System.out.print(".");
						if (row.contains("dia")) {
							System.out.println("DONE");
							System.out.println("Latência: " + row.substring(row.lastIndexOf("=")));
						}
						try {
							row = buffer.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else if (process.contains("-c")) {
					System.out.print("Calculando");
					while (row != null) {
						System.out.print(".");
						if (row.contains("/")) {
							String[] splitedString = row.split("/");
							System.out.println("DONE");System.out.println("Latencia: " + splitedString[4] + "ms");
						}
						try {
							row = buffer.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}
		return message;

	}

	public void ip(String os) {
		if (os.contains("Windows")) {
			String process = "ipconfig";
			System.out.println(callProcess(process, os));
		} else if (os.contains("Linux")) {
			String process = "ip address";
			System.out.println(callProcess(process, os));
		} else {
			System.out.println("SO não reconhecido");
		}
	}

	public void ping(String os) {
		String process = "";
		if (os.contains("Windows")) {
			process = "ping -n 10 www.google.com";
			System.out.println(callProcess(process, os));
		} else if (os.contains("Linux")) {
			process = "ping -c 10 google.com";
			System.out.println(callProcess(process, os));
		}

	}

}
