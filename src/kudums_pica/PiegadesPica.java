package kudums_pica;

public class PiegadesPica extends Pica {
	//Atribūti
	private String adrese;
	
	//Konstruktors
	public PiegadesPica(String tips, String merce, double cena, int izmers, boolean piegade, int skaits,String[] piedevaIzvele,String adrese) {
		
		super(tips, merce, cena, izmers, piegade, skaits, piedevaIzvele);
			this.adrese = adrese;
	}

	//Metodes
	public String getAdrese(){
		return adrese;
	}
	
	public String checks(){
		String teksts="";
		if(getPiedevas(1) == null && getPiedevas(2) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: Nav izvēlētas!"
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir pasūtīta uz: "+getAdrese();
			
		}else if(getPiedevas(1) == null && getPiedevas(2) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(3)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir pasūtīta uz: "+getAdrese();
			
		}else if(getPiedevas(1) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(2)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir pasūtīta uz: "+getAdrese();
			
		}else if(getPiedevas(2) == null && getPiedevas(3) == null){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: "+getPiedevas(1)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir pasūtīta uz: "+getAdrese();
			
		}else if(getPiedevas(1) == "Bekons" && getPiedevas(2) == "Siers" && getPiedevas(3) == "Sēnes"){
			teksts = "Picas tips: "+getTips()
			+"\nPicas merce: "+getMerce()
			+"\nPicas piedevas: 1.Piedeva "+getPiedevas(1)+" 2. Piedeva "+getPiedevas(2)+" 3. Piedeva"+getPiedevas(3)
			+"\nPicas izmērs: "+getIzmers()
			+"\nPicas cena: "+getCena()
			+"\nPica ir pasūtīta uz: "+getAdrese();
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
	+"\n| Pica ir pasūtīta uz: "+getAdrese()
	+"\n| Pasūtijuma cena: "+getCena()
	+"\n\t PALDIES PAR IEPIRKUMU\t\n"
	+"-----------------------------\n";
	}
	
}


