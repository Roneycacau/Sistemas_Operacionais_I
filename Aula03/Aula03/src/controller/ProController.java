package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProController {

    public ProController() {
        super();
    }

    public String os(){
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        String version = System.getProperty("os.version");

        return os + " -v. " + version +  " - arquitetura " + arch; 
    }

    public void chamaProcesso(String processo){
        try {
            Runtime.getRuntime().exec(processo);
            
        } catch (Exception e) {
            // e.printStackTrace();
            if(e.getMessage().contains("740")){
                StringBuffer buffer = new StringBuffer();
                buffer.append("cmd /c");
                buffer.append(" ");
                buffer.append(processo);
                try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }else {
            	e.printStackTrace();
            }
        }
        
        
    } 
    
    public void leProcesso(String processo) {
    	try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null ) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void mataProcesso(String param) {
    	String cmdPid = "TASKKILL /FO TABLE";
    	String cmdNome = "TASKKILL /IM";
    	int pid = 0;
    	StringBuffer buffer = new StringBuffer();
    	
    	try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(param);
		}
    	chamaProcesso(buffer.toString());
    }
    
}