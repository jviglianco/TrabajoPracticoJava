package data;

import java.util.ArrayList;

public class Lavarropas {
	
	private static ArrayList<entidades.Lavarropas> lavarropas = new ArrayList<entidades.Lavarropas>();
	
	public static ArrayList<entidades.Lavarropas> getLavarropas()
	{
		if (lavarropas.isEmpty())
		{
			entidades.Lavarropas lava1= new entidades.Lavarropas(1,900,"blanco",'A',100,120);
			entidades.Lavarropas lava2= new entidades.Lavarropas(2,800,"negro",'B',125,150);
			entidades.Lavarropas lava3= new entidades.Lavarropas(3,700,"rojo",'C',150,180);
			lava1.precioFinal();
			lava2.precioFinal();
			lava3.precioFinal();
			lavarropas.add(lava1);
			lavarropas.add(lava2);
			lavarropas.add(lava3);
	}
		return lavarropas;

}
	
	public ArrayList<entidades.Lavarropas> getAll()
	{
		
		return getLavarropas();
	}
	
	public void agregarElectrodomestico(entidades.Lavarropas lavarropa)
	{
		getLavarropas().add(lavarropa);													
	} 

}
