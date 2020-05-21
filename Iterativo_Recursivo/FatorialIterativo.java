package Iterativo_Recursivo;

public class FatorialIterativo {

	public static void main(String[] args) {
		int resultado = fatorialIterativo2(3);
		  System.out.println(resultado);
		}

	public static int fatorialIterativo2(int valor) {
		int x = valor;
		for (int i = 1; i<valor; i++) {
			x= x*i;
		}
		return x;
	}

	public static int fatorialIterativo1(int valor) {
		int x = valor;
		for (int i = valor; i>0; i--) {
			x= x*i;
		}
		return x;
	}
}
