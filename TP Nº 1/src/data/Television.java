package data;

import java.util.ArrayList;

public class Television {
	
	private static ArrayList<entidades.Television> televisores = new ArrayList<entidades.Television>();
	
	public static ArrayList<entidades.Television> getTelevisores()
	{
		if (televisores.isEmpty())
		{
			entidades.Television tele1= new entidades.Television(4,900,"blanco",'D',100,40,true);
			entidades.Television tele2= new entidades.Television(5,800,"azul",'E',125,30,false);
			entidades.Television tele3= new entidades.Television(6,700,"gris",'F',150,50,true);
			tele1.precioFinal();
			tele2.precioFinal();
			tele3.precioFinal();
			televisores.add(tele1);
			televisores.add(tele2);
			televisores.add(tele3);
	}
		return televisores;

}
	
	public ArrayList<entidades.Television> getAll()
	{
		
		return getTelevisores();
	}
	
	public void agregarElectrodomestico(entidades.Television televisor)
	{
		getTelevisores().add(televisor);													
	} 

}
