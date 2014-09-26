package entidades;

public class Lavarropas extends Electrodomesticos {
	private double carga;
	private static final double cargaC=5;
	
	public Lavarropas(int id) {
		super(id);
		this.id=id;
		this.precio_base=precioC;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = pesoC;
		this.carga=cargaC;
	}

	public Lavarropas(int id,double precio_base,double peso) {
		super(id,precio_base,peso);
		this.id = id;
		this.precio_base = precio_base;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = peso;
		this.carga = cargaC;
	}

	public Lavarropas(int id, double precio_base, String color, char consumo_ener,
			double peso, double carga) {
		super(id, precio_base, color, consumo_ener, peso);
		// TODO Auto-generated constructor stub
		this.carga = carga;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}
	
	public String toString()
	{
		return (this.getId()+"\t"+this.getPrecio_base()+"\t"+this.getColor()+"\t"+this.getConsumo_ener()+"\t"+this.getPeso()+"\t"+this.getCarga());
	}
	
	public void precioFinal() {
		super.precioFinal();
		if(this.carga>30) {
			this.precio_base=this.precio_base+50;	
		}	
	}
}
