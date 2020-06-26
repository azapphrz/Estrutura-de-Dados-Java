package Lista;
import java.util.Collection;
public class TesteListaE {

	public static void main(String[] args) {

		System.out.println("Lista Estatica");

		// Criando a lista
		ListaEstatica listaE = new ListaEstatica();

		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());

		// Inserindo itens na lista
		listaE.inserir(5);
		listaE.inserirInicio(1);
		listaE.inserir(2);
		listaE.inserir(7);
		listaE.inserir(6);
		listaE.inserir(3);
		listaE.inserir(0);

		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());

		// Buscando um item
		System.out.println("Buscar: " + listaE.buscar("J"));

		// Verificando o tamanho da lista
		System.out.println("Tamanho da lista: " + listaE.tamanho());
		
		// Imprimindo o conteudo da lista
		System.out.println(listaE.toString());

		// Vericando o primeiro item da lista
		System.out.println("Primeiro item: " + listaE.consultarInicio());

		// Vericando o ultimo item da lista
		System.out.println("Ultimo item: " + listaE.consultarFim());


		// Retirando um item da lista
		listaE.retirarFim();

		System.out.println("Consultar: "+ listaE.consultar(1));
		
		// Limpando o conteudo da lista
		listaE.limpar();

		// Verificando se a lista esta vazia
		System.out.println("Lista vazia? " + listaE.vazia());

	
	}
}
