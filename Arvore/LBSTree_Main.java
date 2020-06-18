package Arvore;

public class LBSTree_Main {

	public static void main(String[] args) {
		
		String[] vetorNum = new String[] {"5", "8", "3", "6", "9", "1", "4", "7", "2", "0"};
		
		// Criando a �rvore
		LBSTree tree = new LBSTree(); 
		
		// Inserindo todo o coteudo de "vetorNum" na arvore 
		for(int i = 0; i < vetorNum.length; i++) {
			tree.inserir(vetorNum[i]);
		}

		// Imprimindo o tamanho da arvore
		System.out.println("Tamanho: " + tree.tamanho());
		
		// Imprimindo o coteudo da arvore 
		System.out.println("Conteudo da Arvore:\n" + tree.toString());
		
		// Caminhamento Pre-Order da �rvore
		System.out.println("\nCaminhamento Pre-Order:" + tree.caminhar(1));
		
		// Caminhamento In-Order da arvore
		System.out.println("Caminhamento In-Order:" + tree.caminhar(2));
		
		// Caminhamento Post-Order da arvore
		System.out.println("Caminhamento Post-Order:" + tree.caminhar(3));
		
		//Verifacando se a um item esta na arvore (5)
		System.out.println("\nBuscar o item: " + tree.buscar("510"));
		
		//Imprimindo a raiz da avore
		System.out.println("A raiz: " + tree.consultarRaiz());
		
		// Imprimindo a altura da arvore
		System.out.println("Altura: "+ tree.altura());

		// Imprimindo o coteudo da arvore 
		System.out.println("Conteudo da Arvore: " + tree.toString());
		
		//Imprimindo a raiz da arvore
		System.out.println("A raiz: " + tree.consultarRaiz());
		
		// Retirando os itens 0, 6 e 3 da �rvore
//		tree.retirar("0");
//		tree.retirar("6");
//		tree.retirar("3");

		// Imprimindo o coteado da arvore 
		System.out.println("Conteudo da Arvore: " + tree.toString());

		System.out.println("Grau: " + tree.grauArvore("5"));
	}
}
