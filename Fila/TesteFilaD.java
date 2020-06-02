package Fila;

public class TesteFilaD {
	
	private static FilaDinamica filaD;
	
	public static void main(String[] args) {
		
		System.out.println(">>> Fila Dinamica <<<");
		
		filaD = new FilaDinamica(); // Construtor da Pilha dinamica
		
		System.out.println( "Frente da Fila: " + filaD.consultarInicio() );
	 	
		System.out.println( "A Fila esta vazia? " + filaD.vazia() );
		
	 	filaD.enfileirar("Item 1");
 		filaD.enfileirar(3.14);
		filaD.enfileirar(21);
		
		System.out.println("Frente da Fila: " + filaD.consultarInicio());
		
		filaD.enfileirarPrioridade(2323);
		filaD.enfileirarPrioridade(455);
		filaD.enfileirar( "Item 2" );
		
		System.out.println("Conteudo da Fila:" + filaD.toString());
 		
		System.out.println( "Tamanho da Fila: " + filaD.tamanho() );
		
 		filaD.desenfileirar();
		
		System.out.println("Conteudo da Fila:" + filaD.toString());
		System.out.println("Tamanho da Fila: " + filaD.tamanho());

	}
}
