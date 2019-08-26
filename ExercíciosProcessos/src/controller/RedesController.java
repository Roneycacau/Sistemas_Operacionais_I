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
		String message="";
		String adapter = "";
		String ip = "";
    	try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null ) {
				
				if(linha.contains("Adaptador")||linha.contains("en")||linha.contains("en")||linha.contains("wl")) {
					if(linha.contains("en")||linha.contains("en")||linha.contains("wl")) {
						adapter = linha.substring(0, (linha.indexOf(":")-1 	));
					}else {
					adapter = linha;
					}
				}
				if(linha.contains("IPv4")||linha.contains("inet ")) {
					if(linha.contains("inet ")) {
						adapter = linha.substring(0, (linha.lastIndexOf("netmask")));
					}else{
						ip = linha;
					}
				}
				if(adapter != "" && ip!= "") {
					message += adapter + "\n" + ip + "\n" ;
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

		if(os.contains("Windows")) {
			String process = "ipconfig";
			String adapter = "";
			String ip = "";
			
			System.out.println(callProcess(process));
			
			
		}else if(os.contains("Linux")) {
			String process = "ifconfig";

			
			System.out.println(callProcess(process));
			
			
		}else if(os.contains("Mac")){

			
			
			
			
		}else {
			System.out.println("SO não reconhecido");
		}
		
	}
	
	public void ping() {
		
	}
}
