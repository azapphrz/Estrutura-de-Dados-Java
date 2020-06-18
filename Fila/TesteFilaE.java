package Fila;

public class TesteFilaE {
	
	private static FilaEstatica filaE;
	
	public static void main( String[] args ) {
		
		System.out.println(">>> Fila Estatica <<<");
		
		filaE = new FilaEstatica(9); // Construtor da Pilha estatica
		
		System.out.println("Frente da Fila: " + filaE.consultarInicio());
		
		System.out.println("A Fila esta vazia? " + filaE.vazia());
		
		filaE.enfileirar("a1");
		filaE.enfileirar("g1");
		filaE.enfileirar("t1");
		filaE.enfileirar("c1");
	 	filaE.enfileirar("a2");
		filaE.enfileirar("g2");  
		filaE.enfileirar("t2");
		filaE.enfileirar("t3");
		
		System.out.println("Frente da Fila: " + filaE.consultarInicio());
		
		System.out.println("A Fila esta cheia? "+ filaE.cheia());
		
		System.out.println("Conteudo da Fila:" + filaE.toString());
		
		System.out.println("Tamanho da Fila: " + filaE.tamanho());
		
		System.out.println("Exite o item na Fila? " + filaE.buscar(1.322));
		
		System.out.println("re: "+filaE.desenfileirar());
		System.out.println("Conteudo da Fila:" + filaE.toString());
		System.out.println("Tamanho da Fila: " + filaE.tamanho());
		
	}
}
