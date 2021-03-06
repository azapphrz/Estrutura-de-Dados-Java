package Pilha;

public class TestePilhaE {

	private static PilhaEstatica pilhaE; // Instacia a classe PilhaEstatica
		
	public static void main( String[] args ){
		
		System.out.println( ">>> Pilha Estatica <<<" );
	 	
		pilhaE = new PilhaEstatica(4); // Inicializa a classe PilhaEstatica
		
		System.out.println("Topo da pilha: " + pilhaE.consultarTopo());
		
		//System.out.println("A pilha esta vazia? " + pilhaE.vazia());
		
		pilhaE.empilhar("a1");
		pilhaE.empilhar("g1");
		pilhaE.empilhar("t1");
		pilhaE.empilhar("c1");
		pilhaE.empilhar("a2");
		pilhaE.empilhar("g2");
		pilhaE.empilhar("t2");
		pilhaE.empilhar("t3");
		
		System.out.println("Conteudo da pilha:" + pilhaE.toString() );
		
		System.out.println("Tamanho da pilha: " + pilhaE.tamanho());
		
		System.out.println("Topo da pilha: " + pilhaE.consultarTopo());
		
		System.out.println("Conteudo da pilha:" + pilhaE.toString());
		
		System.out.println("Tamanho da pilha: " + pilhaE.tamanho());
		
		pilhaE.desempilhar();
		
		System.out.println("Conteudo da pilha:" + pilhaE.toString());
		
		System.out.println("Tamanho da pilha: " + pilhaE.tamanho());
		
		pilhaE.aumentarCapacidade(10);
		
		System.out.println("Conteudo da pilha:" + pilhaE.toString());
		
		System.out.println("Tamanho da pilha: " + pilhaE.tamanho());
		
	}
}
