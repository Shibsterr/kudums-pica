package kudums_pica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ceptuve {

	public static void main(String[] args) {
		int izvele,izvelesIndekss;
		
		String[] darbibas = {"Pasūtīt picu","Apskatīties pasūtījumus","Izcept picu","Beigt darbu"};
		
		ArrayList<Object> pica = new ArrayList<>();
		
		do{
			izvele = JOptionPane.showOptionDialog(null,"Izvēlies darbību","Darbības izvēle",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,darbibas,null);
			
			switch(izvele){
			
			case 0:	//pasūtit picu
				String tips,merce,adrese;
				int cena,lielums,skaits;
				boolean piegade;
				
				JOptionPane.showMessageDialog(null, "Labdien! Kādu picu jūs vēlaties?");
				
				
				break;
			
			case 1:	//apskatīties pasūtījumus
				
				break;
				
			case 2:	//izcept picu
				
				break;
				
			case 3:	//beight darbu
				
				break;
			}
			
		}while(izvele != 3);
		
	}

}
