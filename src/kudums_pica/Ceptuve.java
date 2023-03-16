package kudums_pica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ceptuve {

	static JSlider getSlider(final JOptionPane optionPane) {
	    JSlider slider = new JSlider(7,24);
	    slider.setMinorTickSpacing(6);  
	    slider.setMajorTickSpacing(4);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    slider.setValue(7);
	    slider.setSnapToTicks(true);
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
	
	static void apskatitCheku(){
		String teksts, str="";
		
		try{
			FileReader fr = new FileReader("ceks.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while((teksts=br.readLine())!=null){
				str += teksts+"\n";
			}
			br.close();
			
			JOptionPane.showMessageDialog(null, "Visu pagaidām pasūtijuma čeki: \n"+str,"Čeki",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kļūda ar nolasīšanu čeku failu!","Kļūda",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	static int picasIzvele(ArrayList<Object> Pica){
		String[] rSaraksts = new String[Pica.size()];
		
		for(int i=0; i<rSaraksts.length; i++){
			rSaraksts[i] = ((Pica)Pica.get(i)).getTips()+"\n"+
		((((Pica)Pica.get(i)).getPiegade() ? " Piegadāts uz adresi "+((PiegadesPica)Pica.get(i)).getAdrese()+" " : " Klients pasūtija vietēji"))+" "+(((Pica)Pica.get(i)).getCena())+" EUR";
		}
		String izveletais =
				(String)JOptionPane.showInputDialog(null,"Kuru pasūtijumu izpildīt? ","Izpilde",JOptionPane.QUESTION_MESSAGE,
				null,rSaraksts,rSaraksts[0]);
		
		return Arrays.asList(rSaraksts).indexOf(izveletais);
	}
	
	static void ierasktitCheku(String teksts){
		try{
			FileWriter fw = new FileWriter("ceks.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.print(teksts);
			pw.println();
			pw.close();
			JOptionPane.showMessageDialog(null, "Jūsu pica ir pasūtīta!","Pasūtījums",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception E){
			JOptionPane.showMessageDialog(null, "Kļūda rakstot cheku!");
		}
	}
	
	static void izmestsCekus(){
    try{
		 FileWriter fw = new FileWriter("ceks.txt", false);
		 PrintWriter pw = new PrintWriter(fw, false);

			    pw.flush();
			    pw.close();
			    fw.close();
			    JOptionPane.showMessageDialog(null, "Čeki ir izmesti!","Brīdinājums",JOptionPane.WARNING_MESSAGE);
			    }catch(Exception exception){
			    	JOptionPane.showMessageDialog(null, "Kļūda ar čeka izmešanu!");

			    }
	}
	
	public static void main(String[] args) {
		int izvele;
		
		String[] darbibas = {"Pasūtīt picu","Apskatīties pasūtījumus","Izcept picu","Apskatīt ceku","Izmest čekus","Beigt darbu"};
		//picas apraksts
		String[] piegades = {"Piegāde","Vietēji"};
		String[] tipi = {"Hawaii","Studenta","Pepperoni"};
		String[] piedeva = {"Bekons","Siers","Sēnes"};
		String[] merces = {"BBQ","Ketchups","Majonēze"};
		
    
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
				//"Hawaii","Studenta","Pepperoni"
			    tips = (String) JOptionPane.showInputDialog(null,"Kāda tipa picu jūs vēlaties?\n__________________\n "
			    		+ "Hawaii - 4,25 EUR \n Studentu - 4,25 EUR \n Pepperoni - 5 EUR \n__________________\n","Izvēle",
			    		JOptionPane.QUESTION_MESSAGE,null,tipi,tipi[0]);
			    //"Bekons","Siers","Sēnes"
			    piedevas = (String)JOptionPane.showInputDialog(null,"Kādas piedevas jūs vēlaties?\n__________________\n "
			    		+ "Bekons - 1,25 EUR \n Siers - 1 EUR \n Sēnes - 1,25 EUR\n__________________\n","Izvēle",
			    		JOptionPane.QUESTION_MESSAGE,null,piedeva,piedeva[0]);
			    //"BBQ","Ketchups","Majonēze"
			    merce = (String)JOptionPane.showInputDialog(null,"Kādu mērci jūs vēlaties pielikt?\n__________________\n"
			    		+ "BBQ - 0,45 EUR \n Ketchups - 0,45 EUR \n Majonēze - 0,35 EUR \n__________________\n","Izvēle",
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
			    lielums = slider.getValue();
			    
			    //cenas aprekins
			    //ja piegade = true tad +1,25 
			    
			    if(piegade == true){
			    	cena = cena+1.25;
			    }
			    
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
			    	cena = cena+0.35;
			    }
			    
			    if(lielums > 14){
			    	cena = cena+6;
			    }else if(lielums <= 14){
			    	cena = cena+4;
			    }
			    DecimalFormat df = new DecimalFormat(".##");
			    //String tips, String merce, int cena, int izmers,boolean piegade, int skaits, String piedevas
			    if(piegade == false){
				    df.format(cena);
			    Pica.add(new Pica(tips,merce,cena,lielums,piegade,skaits,piedevas));
			    }else if(piegade == true){
			    	adrese = (String)JOptionPane.showInputDialog(null,"Ievadiet savu adresi lai varēt jums piegādāt picu! ");
			    	 df.format(cena);
			    	 Pica.add(new PiegadesPica(tips,merce,cena,lielums,piegade,skaits,piedevas,adrese));
			    }
			    pagaida++;
				}while(pagaida != skaits);
				String str1="";
				for(int i=0; i<Pica.size(); i++){
					str1 += ((Pica)Pica.get(i)).checkaIerakste();
				}
				ierasktitCheku(str1);
				
				break;
			
			case 1:	//apskatīties pasūtījumus
				String str;
				if(Pica.size()>0){
					str = "Picu pasūtijumi: "+Pica.size()+"\n______________________\n";
					
					for(int i=0; i<Pica.size(); i++){
						str+= ((Pica)Pica.get(i)).checks()+"\n______________\n";
					}

					JOptionPane.showMessageDialog(null,str,"Picu saraksts",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "Nav nekādu pasūtijumu!","Informācija",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 2:	//izcept picu vai arī izdzēst to picu
				if(Pica.size()>0){
					izvelesIndekss = picasIzvele(Pica);
					Pica.remove(izvelesIndekss);
					JOptionPane.showMessageDialog(null,"Pica veiksmīgi ir izcepta un atdota klientam!");
				}else{
					JOptionPane.showMessageDialog(null, "Nav nekādu pasūtijumu!","Informācija",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 3:	//apskatīt ceku
				if(Pica.size()>0){
				apskatitCheku();
				}else{
					JOptionPane.showMessageDialog(null, "Nav nekādu pasūtijumu!","Informācija",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 4:	//izmests vai izstīrit ceka failu
				izmestsCekus();
				break;
			
			case 5:	//beight darbu
				JOptionPane.showMessageDialog(null, "Darbs beights šodien!","Informācija",JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
		}while(izvele != 5);
		
	}

}
