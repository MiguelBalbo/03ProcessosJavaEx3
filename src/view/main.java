package view;
import javax.swing.JOptionPane;

import controller.DistroController;

public class main {
	public static void main(String[] args) {
		int opc=0;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção: \n 1 - Exibir distribuição \n 9 - Sair"));
			switch(opc) {
			case 1:
				DistroController.exibeDistro();
				break;
			case 9:
				break;
			default:
				JOptionPane.showMessageDialog(null,"Verifique a opção digitada");
				break;
			}
		}while(opc != 9);
	}
}
