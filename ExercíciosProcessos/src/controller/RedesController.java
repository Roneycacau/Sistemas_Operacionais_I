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
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {

				if ((linha.contains("Adaptador") || linha.contains("et") || linha.contains("en") || linha.contains("wl")
						|| linha.contains("lo"))
						&& (!linha.contains("ether") && !linha.contains("ets") && !linha.contains("net")
								&& !linha.contains("txqueuelen"))) {
					if ((linha.contains("et") || linha.contains("en") || linha.contains("wl") || linha.contains("lo"))
							&& (!linha.contains("ether") && !linha.contains("ets") && !linha.contains("net")
									&& !linha.contains("txqueuelen"))) {
						int iend = linha.indexOf(":");
						adapter = linha.substring(0, iend).trim();
					} else {
						adapter = linha.trim();
					}
				}
				if (linha.contains("IPv4") || linha.contains("inet ")) {
					if (linha.contains("inet ")) {
						ip = linha.substring(0, (linha.lastIndexOf("netmask"))).trim();
					} else {
						ip = linha.trim();
					}
				}
				if (adapter != "" && ip != "") {
					message += adapter + "\n" + ip + "\n";
					ip = "";

				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return message;
	}

	public void ip(String os) {

		if (os.contains("Windows")) {
			String process = "ipconfig";

			System.out.println(callProcess(process));

		} else if (os.contains("Linux")) {
			String process = "ifconfig";

			System.out.println(callProcess(process));

		} else if (os.contains("Mac")) {
			String process = "ifconfig";

			System.out.println(callProcess(process));

		} else {
			System.out.println("SO não reconhecido");
		}

	}

	public void ping() {

	}
}
