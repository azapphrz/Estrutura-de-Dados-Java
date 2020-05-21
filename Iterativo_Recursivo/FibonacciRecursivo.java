package Iterativo_Recursivo;

public class FibonacciRecursivo {

	private static int recursivo(int n) {
	
		if(n<2){
			return(n);
		}else {
			return(recursivo(n-1) + recursivo(n-2));
		}
	}

	public static void main(String[] args){
		
		  System.out.print("Fibonacci recursivo: " +recursivo(7));
	}
}