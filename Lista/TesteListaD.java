package Lista;

public class TesteListaD {

	public static void main(String[] args) {
		
		System.out.println("Lista Dinamica");
		
		//Criando a lista
		ListaDinamica listaD = new ListaDinamica(); 
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaD.vazia());
		
		//Inserindo itens na lista
		listaD.inserir("C");
		listaD.inserir("D");
		listaD.inserirInicio("E");
		listaD.inserir("A");
		listaD.inserir("B");
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaD.vazia());
		
		//Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaD.tamanho());
		
		//Imprimindo o conteudo da lista
		System.out.println(listaD.toString());
		
		//Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaD.consultarInicio());

		//Vericando o último item da lista
		System.out.println("Último item: " + listaD.consultarFim());
		
		//Retirando um item da lista
		System.out.println("Retirar: " + listaD.retirarFim());
		
		//Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaD.tamanho());
				
		//Imprimindo o conteudo da lista
		System.out.println(listaD.toString());
		
		//Limpando o conteudo da lista
		listaD.limpar();
		
		//Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaD.tamanho());
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaD.vazia());		
		//Inserindo itens na lista
		listaD.inserir(1);
		listaD.inserir(2);
		listaD.inserirInicio(3);
		listaD.inserir(4);
		listaD.inserir(5);
		
		//Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaD.tamanho());
		
		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaD.vazia());

		//Imprimindo o conteudo da lista
		System.out.println(listaD.toString());
		
		//Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaD.consultarInicio());

		//Vericando o último item da lista
		System.out.println("Último item: " + listaD.consultarFim());
		
	}
}
