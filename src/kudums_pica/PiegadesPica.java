package kudums_pica;

public class PiegadesPica extends Pica {
	//Atribūti
	private String adrese;
	
	//Konstruktors
	public PiegadesPica(String tips, String merce, double cena, int izmers, boolean piegade, int skaits,String piedevas,String adrese) {
		
		super(tips, merce, cena, izmers, piegade, skaits, piedevas);
			this.adrese = adrese;
	}

	//Metodes
	public String getAdrese(){
		return adrese;
	}
	
	public String checks(){
		return "Picas tips: "+getTips()
		+"\nPicas merce: "+getMerce()
		+"\nPicas piedevas: "+getPiedevas()
		+"\nPicas izmērs: "+getIzmers()
		+"\nPicas cena: "+getCena()
		+"\nPica ir pasūtīta uz: "+getAdrese();
	}
	
	public String checkaIerakste(){
		return 
	"\n-------------------------\n"
	+"Picas tips: "+getTips()
	+"\nPicas merces: "+getMerce()
	+"\nPicas piedevas: "+getPiedevas()
	+"\nPicas izmērs: "+getIzmers()
	+"\nPica ir pasūtīta uz: "+getAdrese()
	+"\nPicas cena ar PVN(14%): "+(getCena()+(14/100))
	+"\nCena bez PVN(14%): "+getCena()
	+"\n\t PALDIES PAR IEPIRKŪJUMU\t\n"
	+"-----------------------------\n";
	}
	
}


