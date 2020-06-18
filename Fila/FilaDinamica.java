package Fila;

public class FilaDinamica {

	class Celula {
		
		Object item; // Armazena o item/elemento/objeto
		Celula anterior; // referencia para o objeto anterior
		
		public Celula() {
			item = null;
			anterior = null;
		}
		
		public Celula(Object valorItem) {
			item = valorItem;
			anterior = null;
		}
		
		public Celula(Object valorItem, Celula celulaSeguinte) {
			item = valorItem;
			anterior = celulaSeguinte;
		}
	}
	
		private Celula inicio;  // Referencia para o inicio da fila
		private Celula fim ;   // Referencia para o fim da fila
		private int contador; // Contador de itens na fila
		
		public FilaDinamica() {
			inicio = null;
			fim = null;
			contador = 0;
		}
		
		public boolean vazia(){
			return( contador == 0 );
		}
		
		public int tamanho() {
			return(contador);
		}
		
		public void enfileirar(Object novoItem) {
			Celula novaCelula = new Celula(novoItem);
			if(inicio == null) {
				inicio = novaCelula;
			} else {
				fim.anterior = novaCelula;
			}
			fim = novaCelula;
			contador++;
		}
		
		public void enfileirarPrioridade (Object preferencial) {
			Celula novaCelula = new Celula(preferencial);
			if (inicio != null) {
 				novaCelula.anterior = inicio;
			}
			inicio = novaCelula;
			contador++;
		}
		
		public void enfileirarPenalidade (Object penalisado) {
			if(vazia()) {
				System.out.println("ERRO: Fila vazia");
			} else {
				
			}
		}
		public Object desenfileirar() {
			Object x = null;
			if(vazia()) {
				System.out.println("Erro: Fila vazia!");
		} else {
			x = inicio.item;
			inicio = inicio.anterior;
				if( inicio == null ){
					fim = null;
				}
				contador--;
		}
		return(x);
		}
		
		public Object consultarInicio() {
			Object x = null;
			if( vazia() ){
				System.out.println("Erro: Fila vazia!");
			} else {
					x = inicio.item;
			}
		return(x);
		}
		
		public Object consultarFim() {
			Object x = null;
			if(vazia()) {
				System.out.println("Erro: Fila vazia!");
			} else {
				x = fim.item;
			}
			return(x);
		}
		
		public Object clonar() {
			FilaDinamica itemAux = new FilaDinamica();
			FilaDinamica cloneFila = new FilaDinamica();
			while(!vazia()){
				itemAux.enfileirar(desenfileirar());
			}
			while(!itemAux.vazia()) {
				Object x = itemAux.desenfileirar();
				enfileirar(x);
				cloneFila.enfileirar( x );
			}
		return( cloneFila );
		}
		
		public String toString() {
			String filaCompleta = "";
			if(vazia()) {
				filaCompleta = null;
			} else {
				for(int i = 0; i < contador; i++) {
					Object tempObject = desenfileirar();
					filaCompleta = filaCompleta + "\n" + tempObject;
					enfileirar(tempObject);
				}
			}
			return(filaCompleta);
		}
		
}