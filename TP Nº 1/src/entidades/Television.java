package entidades;

public class Television extends Electrodomesticos {
	private double resolucion;
	private boolean tdt;
	private static final double resolucionC=20;
	private static final boolean tdtC=false;
	
	public Television(int id) {
		super(id);
		this.id=id;
		this.precio_base=precioC;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = pesoC;
		this.resolucion = resolucionC;
		this.tdt = tdtC;
	}
	
	public Television(int id, double precio_base,double peso) {
		super(id,precio_base,peso);
		this.id=id;
		this.precio_base = precio_base;
		this.color = colorC;
		this.consumo_ener = consumoC;
		this.peso = peso;
		this.resolucion = resolucionC;
		this.tdt = tdtC;
	}
	
	public Television(int id,double precio_base, String color, char consumo_ener,
			double peso, double resolucion, boolean tdt) {
		super(id,precio_base, color, consumo_ener, peso);
		// TODO Auto-generated constructor stub
		this.resolucion = resolucion;
		this.tdt = tdt;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	
	public void precioFinal() {
		super.precioFinal();
		if(this.resolucion>40) {
			this.precio_base=this.precio_base + ((30*(this.precio_base))/100);	
		}
		if(this.tdt==true){
			this.precio_base = this.precio_base + 50;
		}
	}
	
	public String toString()
	{
		return (this.getId()+"\t"+this.getPrecio_base()+"\t"+this.getColor()+"\t"+this.getConsumo_ener()+"\t"+this.getPeso()+"\t"+this.getResolucion()+"\t"+this.isTdt());
	}
	
}
