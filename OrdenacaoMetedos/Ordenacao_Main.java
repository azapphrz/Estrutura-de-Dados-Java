package OrdenacaoMetedos;

public class Ordenacao_Main {
	
	// Instancie e inicialize a classe Ordenação
	private static Ordenacao order = new Ordenacao();
	
	public static void main(String[] args) {
		
		System.out.println("\nTeste de Ordenacao\n");
		
		// Crie um vetor de inteiros, e gere 10 n�meros aleatorios
		int[] dados = order.geradorAleatorio(10, 10);
		
		// Exiba o vetor de n�meros aleatorios
		System.out.println("Numeros: " + order.exibirVetor(dados));
		
		// Instancie um vetor resultado, que contem o resultado da ordena��o
		int[] resultado;// Ordene o vetor de inteiros pelo metodo BubbleSort
		resultado = order.BubbleSort(dados);
		
		// Exiba o vetor ordenado
		System.out.println("BubbleSort: " + order.exibirVetor(resultado));
		
		// Ordene o vetor de inteiros pelo metodo SelectionSort
		resultado = order.SelectionSort(dados);
		
		// Exiba o vetor ordenado
		System.out.println("SelectionSort: " + order.exibirVetor(resultado));
		
		// Ordene o vetor de inteiros pelo metodo InsertionSort
		resultado = order.InsertionSort(dados);
		
		// Exiba o vetor ordenado
		System.out.println("InsertionSort: " + order.exibirVetor(resultado));
		
		// Ordene o vetor de inteiros pelo metodo QuickSort
		resultado = order.QuickSort(dados, 0, dados.length-1);
		
		// Exiba o vetor ordenado
		System.out.println("QuickSort: " + order.exibirVetor(resultado));
		
		// Ordene o vetor de inteiros pelo metodo MergeSort
		resultado = order.MergeSort(dados, 0, dados.length-1);
		
		// Exiba o vetor ordenado
		System.out.println("MergeSort: " + order.exibirVetor(resultado));

	}
}