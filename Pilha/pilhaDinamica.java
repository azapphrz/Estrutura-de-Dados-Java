package Pilha;

public class pilhaDinamica {

	private class Celula {
		Object item; // Armazena o item/elemento/objeto
		Celula anterior; // Referencia para o objeto anterior
		
		public Celula() {
			item = null;
			anterior = null;
		}
		
		public Celula(Object valorItem) {
			item = valorItem;
			anterior = null;
		}
		
 		public Celula(Object valorItem, Celula celulaAnterior) {
			item = valorItem;
			anterior = celulaAnterior;
		}
	}
	
	private Celula topo; // Referencia para o topo da pilha
	private int contador; // Contador do numero de itens na pilha
	
	public void PilhaDinamica() { 
		topo = null;
		contador = 0;
	}
	
	public boolean vazia() {
		return(topo == null);
	}
	
	public int tamanho() {
		return(contador);
	}
	
	public void empilhar(Object novoItem) {
		Celula novaCelula = new Celula(novoItem);
		novaCelula.anterior = topo;
		topo = novaCelula;
		contador++;
	}
	
	public Object desempilhar() {
		Object x = null;
		if (vazia()) {
			System.out.println("Erro: Pilha vazia!");
		}else{
			Celula tempCelula = topo;
			topo = topo.anterior;
			contador--;
			x = tempCelula.item;
		}
		return(x);
	}
		
	public Object consultarTopo() {
		Object x = null;
		if(vazia()) {
			System.out.println("Erro: Pilha vazia!");
		}else{
			x = topo.item;
		}
		return(x);
	}
	
	public Object clonar() {
		pilhaDinamica tempPilha = new pilhaDinamica();
		pilhaDinamica copiaPilha = new pilhaDinamica();
		while(!vazia()){
			tempPilha.empilhar( desempilhar() );
		}
		while(!tempPilha.vazia()) {
			Object x = tempPilha.desempilhar();
			empilhar(x);
			copiaPilha.empilhar( x );
		}
		return(copiaPilha);
	}
	
	public String toString() {
		String pilhaCheia = "";
		if(vazia()) {
			pilhaCheia = null;
		}else{
			pilhaDinamica copiaPilha = (pilhaDinamica) clonar();
			while(!copiaPilha.vazia()) {
					pilhaCheia += "\n" + copiaPilha.desempilhar();
			}
		}
		return(pilhaCheia);
	}
}
