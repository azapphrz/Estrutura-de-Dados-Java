package Pilha;

public class TestePilhaD {
	
	private static PilhaDinamica pilhaD; // Instacia a classe PilhaDinamica
	
	public static void main(String[] args){
		
		System.out.println( "\n>>> Pilha Dinamica <<<\n" );
		
		pilhaD = new PilhaDinamica(); // Construtor da Pilha Dinamica
		
		System.out.println("Topo da pilha: " + pilhaD.consultarTopo());
		
		System.out.println("A pilha esta vazia? " + pilhaD.vazia());
 		
		pilhaD.empilhar("Item 1");
		pilhaD.empilhar(3.14);
		pilhaD.empilhar(21);
		
		System.out.println("Topo da pilha: " + pilhaD.consultarTopo());
		
		pilhaD.empilhar("Item 2");
		pilhaD.empilhar(99.78);
		
		System.out.println("Conteudo da pilha:" + pilhaD.toString());
		
		System.out.println("Tamanho da pilha: " + pilhaD.tamanho());
		
		System.out.println("A pilha esta vazia? " + pilhaD.vazia());
		
		pilhaD.desempilhar();
		pilhaD.desempilhar();
		
		System.out.println("Conteudo da pilha:" + pilhaD.toString());
		
		System.out.println("Tamanho da pilha: " + pilhaD.tamanho());
	
	}
}
