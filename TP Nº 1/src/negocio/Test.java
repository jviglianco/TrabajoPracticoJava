package negocio;

import java.util.ArrayList;

import entidades.Lavarropas;
import entidades.Television;

public class Test {
	
	private data.Colorido dataColor;
	private data.Consumo dataConsumo;
	private data.Lavarropas dataLavarropas;
	private data.Television dataTelevision;
	

	public data.Colorido getDataColor() {
		return dataColor;
	}
	public void setDataColor(data.Colorido dataColor) {
		this.dataColor = dataColor;
	}
	public data.Consumo getDataConsumo() {
		return dataConsumo;
	}
	public void setDataConsumo(data.Consumo dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	public data.Lavarropas getDataLavarropas() {
		return dataLavarropas;
	}
	public void setDataLavarropas(data.Lavarropas dataLavarropas) {
		this.dataLavarropas = dataLavarropas;
	}
	public data.Television getDataTelevision() {
		return dataTelevision;
	}
	public void setDataTelevision(data.Television dataTelevision) {
		this.dataTelevision = dataTelevision;
	}
	
	public Test() {
		setDataColor(new data.Colorido());
		setDataConsumo(new data.Consumo());
		setDataLavarropas(new data.Lavarropas());
		setDataTelevision(new data.Television());
	}
	
	public entidades.Consumo[] getAllConsumos()
	{
		return (getDataConsumo().getAll());
	}
	public entidades.Colorido[] getAllColores()
	{
		return (getDataColor().getAll());
	}
	
	public ArrayList<entidades.Lavarropas> getAllLavarropas()
	{
		return getDataLavarropas().getAll();										
	}
	
	public ArrayList<entidades.Television> getAllTelevisores()
	{
		return getDataTelevision().getAll();										
	}
	
	public void crearLavarropa(int id,double precio_base, String color, char consumo_ener,
			double peso, double carga)
	{
		entidades.Lavarropas lavarropa=new Lavarropas(id,precio_base, color, consumo_ener, peso, carga);
		lavarropa.precioFinal();
		getDataLavarropas().agregarElectrodomestico(lavarropa);
		
	}
	
	public void crearTelevisor(int id,double precio_base, String color, char consumo_ener,
			double peso, double resol, boolean tdt)
	{
		entidades.Television televisor=new Television( id, precio_base, color, consumo_ener, peso,resol, tdt);
		televisor.precioFinal();
		getDataTelevision().agregarElectrodomestico(televisor);
		
	}
	

}
