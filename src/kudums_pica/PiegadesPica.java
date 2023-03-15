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
	
	
	
}


