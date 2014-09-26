package entidades;


public class Consumo {
	char valorConsumo;

	public Consumo(char valorConsumo) {
		this.setValorConsumo(valorConsumo);
	}

	public char getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(char valorConsumo) {
		this.valorConsumo = valorConsumo;
	}
	
	public String toString()
	{	
		char valor = this.getValorConsumo();
		String valorReal = Character.toString(valor);
		return (valorReal);
	}
	
}
