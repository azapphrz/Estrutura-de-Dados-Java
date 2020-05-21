package Iterativo_Recursivo;

public class FibonacciIterativo {

	private static int iterativo(int n){
		
		int valorAtual = 1;
		int valorAnterior = 0;
		
		for(int aux = 1; aux <= (n-2); aux++){
			
			valorAtual=valorAtual+valorAnterior;
			}
		
		return (valorAtual);
	}
	
	public static void main(String[] args) {
		
		System.out.print("Fibonacci iterativo: " +iterativo(7));
	}
}
