package Lista;

public class TesteListaE {
 
	public static void main(String[] args) {
		
		System.out.println("Lista Estatica");
		
		// Criando a lista
		ListaEstatica listaE = new ListaEstatica(4); 
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());
		
		//Buscando um item na lista
		listaE.buscar(1);
		
		// Inserindo itens na lista
		listaE.inserir("A");
		listaE.inserirInicio("B");
		listaE.inserir("C");
		listaE.inserir("D");
		listaE.inserir("E");

		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());
		
		// Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaE.tamanho());
		
		// Imprimindo o conteudo da lista
		System.out.println(listaE.toString());
		
		// Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaE.consultarInicio());

		// Vericando o último item da lista
		System.out.println("Último item: " + listaE.consultarFim());
		
		// Retirando um item da lista
		listaE.retirarFim();
		
		// Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaE.tamanho());
				
		// Imprimindo o conteudo da lista
		System.out.println(listaE.toString());
		
		// Limpando o conteudo da lista
		listaE.limpar();
		
		// Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaE.tamanho());
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());
		
		// Inserindo itens na lista
		listaE.inserir(1);
		listaE.inserir(2);
		listaE.inserirInicio(3);
		listaE.inserir(4);
		listaE.inserir(5);
		

		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());
		
		// Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaE.tamanho());
		
		// Imprimindo o conteudo da lista
		System.out.println(listaE.toString());
		
		// Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaE.consultarInicio());

		// Vericando o último item da lista
		System.out.println("Último item: " + listaE.consultarFim());
		
		
	}
}
