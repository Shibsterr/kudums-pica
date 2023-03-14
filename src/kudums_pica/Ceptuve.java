package kudums_pica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ceptuve {
static JSlider getSlider(final JOptionPane optionPane) {
	    JSlider slider = new JSlider(7,24);
	    slider.setMinorTickSpacing(2);  
	    slider.setMajorTickSpacing(4);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    ChangeListener changeListener = new ChangeListener() {
	    	
public void stateChanged(ChangeEvent changeEvent) {
	  JSlider theSlider = (JSlider) changeEvent.getSource();
	       if (!theSlider.getValueIsAdjusting()) {
	          optionPane.setInputValue(new Integer(theSlider.getValue()));
	        }
	      }
	    };
	    slider.addChangeListener(changeListener);
	    return slider;
	  }

	public static void main(String[] args) {
		int izvele;
		
		String[] darbibas = {"Pasūtīt picu","Apskatīties pasūtījumus","Izcept picu","Beigt darbu"};
		//picas apraksts
		String[] piegades = {"Piegāde","Vietēji"};
		String[] tipi = {"Hawaii","Studenta","Pepperoni"};
		String[] piedeva = {"Bekons","Siers","Sēnes"};
		String[] merces = {"BBQ","Ketchups","placeholder"};
		
		ArrayList<Object> Pica = new ArrayList<>();
		
		do{
			izvele = JOptionPane.showOptionDialog(null,"Izvēlies darbību","Darbības izvēle",
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,darbibas,null);
			
			switch(izvele){
			
			case 0:	//pasūtit picu
				String tips,merce,adrese,pag,piedevas;
				int lielums,skaits,pagaida=0;
				double cena=0;
				boolean piegade = false;
				int izvelesIndekss;
				
				JOptionPane.showMessageDialog(null, "Labdien!");
				pag = (String) JOptionPane.showInputDialog(null, "Vai šī būs piegāde vai uzvietas?","Izvēle",JOptionPane.QUESTION_MESSAGE,null
						,piegades,piegades[0]);
				izvelesIndekss = Arrays.asList(piegades).indexOf(pag);
				
				if(izvelesIndekss == 1){
					piegade = false;
				}else if(izvelesIndekss == 0){
					piegade = true;
				}
				skaits = Integer.parseInt(JOptionPane.showInputDialog(null,"Cik daudz picas jūs pasūtīsiet?","Skaits",JOptionPane.QUESTION_MESSAGE));
				
				do{
				
			    tips = (String) JOptionPane.showInputDialog(null,"Kāda tipa picu jūs vēlaties?","Izvēle",
			    		JOptionPane.QUESTION_MESSAGE,null,tipi,tipi[0]);
			    
			    piedevas = (String)JOptionPane.showInputDialog(null,"Kādas piedevas jūs vēlaties?","Izvēle",
			    		JOptionPane.QUESTION_MESSAGE,null,piedeva,piedeva[0]);
			    
			    merce = (String)JOptionPane.showInputDialog(null,"Kādu mērci jūs vēlaties pielikt?","Izvēle",
			    		JOptionPane.QUESTION_MESSAGE,null,merces,merces[0]);
			    
				//sliders izvele preks picas lieluma
			    //sakot no 7 - 23 ir lielumi
				JFrame parent = new JFrame();
			    JOptionPane optionPane = new JOptionPane();
			    JSlider slider = getSlider(optionPane);
			    optionPane.setMessage(new Object[] { "Izvēlaties lielumu: ", slider });
			    optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
			    optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
			    JDialog dialog = optionPane.createDialog(parent, "Izvēle");
			    dialog.setVisible(true);
			    
			    lielums = (int)optionPane.getValue();
			    //cenas aprekins
			    //ja piegade = true tad +1,27 
//			    if(piegade == true){
//			    	cena = cena+1.27;
//			    }
			    
			    if(tips=="Hawaii" || tips == "Studenta"){
			    	cena = cena+4.25;
			    }else{
			    	cena = cena+5;
			    }
			    
			    if(piedevas == "Bekons" || piedevas == "Sēnes"){
			    	cena = cena+1.25;
			    }else{
			    	cena = cena+1;
			    }
			    
			    if(merce == "BBQ" || merce == "Ketchups"){
			    	cena = cena+0.45;
			    }else{
			    	cena = cena+0.99;
			    }
			    
			    if(lielums >= 14){
			    	cena = cena+6;
			    }else if(lielums <= 14){
			    	cena = cena+4;
			    }
			    
			    //String tips, String merce, int cena, int izmers,boolean piegade, int skaits, String piedevas
			    Pica.add(new Pica(tips,merce,cena,lielums,piegade,skaits,piedevas));
			    pagaida++;
				}while(pagaida != skaits);
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
