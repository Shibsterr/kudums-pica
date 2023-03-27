package kudums_pica;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Pica {

	//Attribūti
	private String tips;		
	private String merce;
	private double cena;
	private int izmers;
	private boolean piegade;			//ja true = piegadā picu uz adresu false = no ceptuves savakts
	private int skaits;
	private String[] piedevas;

	//Konstruktors
	public Pica(String tips, String merce, double cena, int izmers,boolean piegade, int skaits, String[] piedevaIzvele){
		this.tips = tips;
		this.merce = merce;
		this.cena = cena;
		this.izmers = izmers;
		this.piegade = piegade;
		this.skaits = skaits;
		this.piedevas = piedevaIzvele;
	}
	
	//Metodes
	
	public String getTips(){
		return tips;
	}
	
	public String getMerce(){
		return merce;
	}
	public String getPiedevas(int sk){
		String p = piedevas[sk];
		return p;
	}

	public double getCena(){
		return cena;
	}
	
	public int getIzmers(){
		return izmers;
	}
	
	public boolean getPiegade(){
		return piegade;
	}
	//+"\nPica ir saņemta no vietas";
	public String checks(){
		String teksts="";
		if(getPiedevas(1) == null && getPiedevas(2) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: Nav izvēlētas!"
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir saņemta no vietas";
			
		}else if(getPiedevas(1) == null && getPiedevas(2) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(3)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir saņemta no vietas";
			
		}else if(getPiedevas(1) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(2)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir saņemta no vietas";
			
		}else if(getPiedevas(2) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(1)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir saņemta no vietas";
		}else{
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: 1.Piedeva "+getPiedevas(1)+" 2. Piedeva "+getPiedevas(2)+" 3. Piedeva"+getPiedevas(3)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir saņemta no vietas";
		}
		
		return teksts;
	}
	
	public String checkaIerakste(){
		return 
				"\n-------------------------\n"
				+"| Picas tips: "+getTips()
				+"\n| Picas merces: "+getMerce()
				+"\n| Picas piedevas: "+getPiedevas(1)+","+getPiedevas(2)+","+getPiedevas(3)
				+"\n| Picas izmērs: "+getIzmers()
				+"\n| Pica ir saņemta no vietas"
				+"\n| Pasūtijuma cena: "+getCena()
				+"\n\t |PALDIES PAR IEPIRKUMU\t\n"
				+"-----------------------------\n";
	}
}
