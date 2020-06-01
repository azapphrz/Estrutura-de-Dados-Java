package Arvore;

public class LBSTree_Main {

	public static void main(String[] args) {
		
		String[] vetorNum = new String[] {"5", "8", "3", "6", "9", "1", "4", "7", "2", "0"};
		
		// Criando a árvore
		LBSTree tree = new LBSTree(); 
		
		// Inserindo todo o coteúdo de "vetorNum" na árvore 
		for(int i = 0; i < vetorNum.length; i++) {
			tree.inserir(vetorNum[i]);
		}

		// Imprimindo o tamanho da árvore
		System.out.println("Tamanho: " + tree.tamanho());
		
		// Imprimindo o coteúdo da arvore 
		System.out.println("Conteúdo da árvore:\n" + tree.toString());
		
		// Caminhamento Pre-Order da árvore
		System.out.println("\nCaminhamento Pre-Order:" + tree.caminhar(1));
		
		// Caminhamento In-Order da árvore
		System.out.println("Caminhamento In-Order:" + tree.caminhar(2));
		
		// Caminhamento Post-Order da árvore
		System.out.println("Caminhamento Post-Order:" + tree.caminhar(3));
		
		//Verifacando se a um item esta na árvore (5)
		System.out.println("\nBuscar o item: " + tree.buscar("5"));
		
		//Imprimindo a raiz da árvore
		System.out.println("A raiz: " + tree.consultarRaiz());
		
		// Imprimindo a altura da árvore
		System.out.println(tree.altura());
		
		// Retirando a raiz da árvore
		tree.retirar("8");

		// Imprimindo o coteúdo da arvore 
		System.out.println("Conteúdo da árvore: " + tree.toString());
		
		//Imprimindo a raiz da árvore
		System.out.println("A raiz: " + tree.consultarRaiz());
		
		// Retirando os itens 0, 6 e 3 da árvore
		tree.retirar("0");
		tree.retirar("6");
		tree.retirar("3");

		// Imprimindo o coteúdo da arvore 
		System.out.println("Conteúdo da árvore: " + tree.toString());
	}
}
