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
		
		//Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaD.consultarInicio());

		//Vericando o Ultimo item da lista
		System.out.println("Ultimo item: " + listaD.consultarFim());
		
		//Retirando um item da lista
		System.out.println("Retirar: " + listaD.retirarFim());
				
		//Imprimindo o conteudo da lista
		System.out.println(listaD.toString());
		
		listaD.trocar("A", "D");
		System.out.println(listaD.toString());
		
	}
}
