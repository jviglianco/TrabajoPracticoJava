package entidades;

public class Electrodomesticos {
	protected int id;
	protected double precio_base;
	protected String color;
	protected char consumo_ener;
	protected double peso;
	protected static final String colorC = "blanco";
	protected static final double precioC = 100;
	protected static final char consumoC = 'F';
	protected static final double pesoC = 5;

	public Electrodomesticos(int id, double precio_base, String color,
			char consumo_ener, double peso) {
		super();
		this.id = id;
		this.precio_base = precio_base;
		this.color = color;
		this.consumo_ener = consumo_ener;
		this.peso = peso;
	}

	public Electrodomesticos(int id, double precio_base, double peso) {
		super();
		
		this.precio_base = precio_base;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = peso;
	}

	public Electrodomesticos(int id) {
		super();
		this.id = id;
		this.precio_base = precioC;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = pesoC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio_base() {
		return precio_base;
	}
	
	public void setPrecio_base(double precio_base) {
		this.precio_base = precio_base;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color ;
	}
	
	public char getConsumo_ener() {
		return consumo_ener;
	}
	
	public void setConsumo_ener(char consumo_ener) {
		this.consumo_ener = consumo_ener;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	private void comprobarConsumoEnergetico(char letra) {
		int ban=0;
		char letras[] = new char[6];
		letras[0]='A';
		letras[1]='B';
		letras[2]='C';
		letras[3]='D';
		letras[4]='E';
		letras[5]='F';
		for(int i=0;i>=7;i++) {
			if(letras[i]==letra){
				ban=1;
			}
		}
		if(ban==0){
			this.consumo_ener = consumoC;
		}	
	}
	
	private void comprobarColor(String colors) {
		int ban=0;
		String colores[] = new String[5];
		colores[0]="blanco";
		colores[1]="negro";
		colores[2]="rojo";
		colores[3]="azul";
		colores[4]="gris";
		for(int i=0;i>=7;i++) {
			if(colores[i]==colors){
				ban=1;
			}
		}
		if(ban==0){
			this.color = colorC;
		}	
	}
	
	public void precioFinal() {
		switch (this.consumo_ener){
		case 'A':
			this.precio_base=this.precio_base+100;
			break;
		case 'B':
			this.precio_base=this.precio_base+80;
			break;
		case 'C':
			this.precio_base=this.precio_base+60;
			break;
		case 'D':
			this.precio_base=this.precio_base+50;
			break;
		case 'E':
			this.precio_base=this.precio_base+30;
			break;
		case 'F':
			this.precio_base=this.precio_base+10;
			break;
		}
		if(this.peso>0 && this.peso<=16) {
			this.precio_base=this.precio_base+10;
			}
			else if(this.peso>=20 && this.peso<=49){
				this.precio_base=this.precio_base+50;	
			}
			else if(this.peso>=50 && this.peso<=79){
				this.precio_base=this.precio_base+80;	
			}
			else if(this.peso>=80){
				this.precio_base=this.precio_base+100;	
			}
	}
}
