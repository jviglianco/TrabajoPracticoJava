package data;

public class Colorido {
	
	private static entidades.Colorido[] colores;
	public static entidades.Colorido[] getColores() {
		
		if (colores==null)
		{
			colores= new entidades.Colorido[] {
					new entidades.Colorido("blanco"),
					new entidades.Colorido("negro"),
					new entidades.Colorido("rojo"),
					new entidades.Colorido("azul"),
					new entidades.Colorido("gris"),
					};
		}
		return colores;
	}
	
	public entidades.Colorido[] getAll()
	{
		
		return getColores();
	}
}