package Iterativo_Recursivo;

public class FuncaoRecursiva {

private static int funcaoRecursiva(int z, int n){
	
	if (n < 1) {
		return (1);
	} else {
		return z * funcaoRecursiva(z, n - 1);
	}
}


public static void main (String[]args) {	
	
	System.out.println("Função recursiva: "+funcaoRecursiva(3, 3));

	}
}