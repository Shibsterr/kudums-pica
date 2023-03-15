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
	private String piedevas;

	//Konstruktors
	public Pica(String tips, String merce, double cena, int izmers,boolean piegade, int skaits, String piedevas){
		this.tips = tips;
		this.merce = merce;
		this.cena = cena;
		this.izmers = izmers;
		this.piegade = piegade;
		this.skaits = skaits;
		this.piedevas = piedevas;
	}
	
	//Metodes
	
	public String getTips(){
		return tips;
	}
	
	public String getMerce(){
		return merce;
	}
	public String getPiedevas(){
		return piedevas;
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
	
	public String checks(){
		return "Picas tips: "+getTips()
		+"\nPicas merce: "+getMerce()
		+"\nPicas piedevas: "+getPiedevas()
		+"\nPicas izmērs: "+getIzmers()
		+"\nPicas cena: "+getCena()
		+"\nPica ir saņemta no vietas";
	}
	
}
