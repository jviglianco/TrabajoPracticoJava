package entidades;

public class Colorido {
	String valorColor;
	
	public Colorido(String valorColor) {
		this.setValorColor(valorColor);
	}

	public String getValorColor() {
		return valorColor;
	}

	public void setValorColor(String valorColor) {
		this.valorColor = valorColor;
	}
	
	public String toString()
	{
		return (this.getValorColor());
	}
	
}
