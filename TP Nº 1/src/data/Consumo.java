package data;

public class Consumo {
	private static entidades.Consumo[] consumos;
	public static entidades.Consumo[] getConsumos() {
		if (consumos==null)
		{
			consumos= new entidades.Consumo[] {
					new entidades.Consumo('A'),
					new entidades.Consumo('B'),
					new entidades.Consumo('C'),
					new entidades.Consumo('D'),
					new entidades.Consumo('E'),
					new entidades.Consumo('F')
					};
		}
		return consumos;
	}
	
	public entidades.Consumo[] getAll()
	{
		
		return getConsumos();
	}

}
