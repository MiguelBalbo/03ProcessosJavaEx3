package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController() {
		super();	
	}
	
	private static String sistemaOperacional() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(System.getProperty("os.name"));
		sBuffer.append(" ");
		sBuffer.append(System.getProperty("os.version"));
		sBuffer.append(" ");
		sBuffer.append(System.getProperty("os.arch"));
		
		return sBuffer.toString();
	}
	
	private static void runComandoRet (String cmd) {
		String[] cmdPicado = cmd.split(" ");
 		String SO = sistemaOperacional();
		
		try {
			Process proc = Runtime.getRuntime().exec(cmdPicado);
			InputStream iStream = proc.getInputStream();
			InputStreamReader irStream = new InputStreamReader(iStream);
			BufferedReader bfReader = new BufferedReader(irStream);
			String readLinha = bfReader.readLine();
			
			while(readLinha != null) {
				if (SO.contains("Linux")) {
					if(readLinha.contains("NAME")) {
						String[] segSplit = readLinha.split("=");
						System.out.println(segSplit[1]);
					}
				}
				readLinha = bfReader.readLine();
			}
			
		}catch(Exception err) {
			System.err.println(err);
		}
	}
	
	public static void exibeDistro() {
		String SO = sistemaOperacional();
		
		if (SO.contains("Linux")) {
			runComandoRet("cat /etc/os-release");
		}
		else {
			System.out.println("Sistema não suportado");
		}
	}
}
