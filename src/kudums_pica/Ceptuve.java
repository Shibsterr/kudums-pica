package kudums_pica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ceptuve {

	public static void main(String[] args) {
		String izvele;
		
		String[] darbibas = {"Pasūtīt picu","Apskatīties pasūtījumus","Izcept picu","Beigt darbu"};
		
		ArrayList<Object> pica = new ArrayList<>();
		
		do{
			izvele = (String)JOptionPane.showInputDialog(null,"Izvēlies darbību","Darbības izvēle"
					,JOptionPane.QUESTION_MESSAGE,null,darbibas,darbibas[0]);
			
			
			
		}while(!izvele.equalsIgnoreCase("Beigt darbu"));
		
	}

}
