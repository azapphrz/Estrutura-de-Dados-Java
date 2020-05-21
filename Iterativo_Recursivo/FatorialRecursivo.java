package Iterativo_Recursivo;

public class FatorialRecursivo {
	
	private static int fatorial(int n){
		
		if (n <= 1) {
			return (1);
		}else {
			return (n * fatorial (n-1));
		}
}

	public static void main (String[]args) {	
		
		System.out.print("Fatorial recursivo: "+fatorial(6));

	}
}
