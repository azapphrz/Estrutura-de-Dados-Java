package Pilha;

public class PilhaEstatica {
	
	private int topo; // Indicador do topo da pilha
	private int contador; // Contador de itens na pilha
	private int capacidade; // Capacidade maxima da pilha
	private Object[] itemArray; // Armazenador de objetos/itens/elementos
	
	public PilhaEstatica() {
		this(10);
	}

	public PilhaEstatica(int maxCapacidade) {
		topo = 0;
		contador = 0;
		capacidade = maxCapacidade;
		itemArray = new Object[capacidade];
	}
	
	public boolean vazia() {
		return (topo == 0);
	}
	
	public int tamanho() {
		return (contador);
	}
	
	public int capacidade() {
		return(capacidade);
	}
	
	public void empilhar(Object novoItem) {
		if (topo == capacidade) {
			System.out.println("Erro: Capacidade da Pilha excecidida!");
		}else {
			itemArray[topo++] = novoItem;
			contador++;
		}
	}
	
	public Object desempilhar() {
		Object x = null;
		if (vazia()) {
			System.out.println("Erro: Pilha vazia!");
 		}else {
			x = itemArray[--topo];
			contador--;
		}
		return (x);
	}
	
	public Object consultarTopo() {
		Object x = null;
		if(vazia()) {
			System.out.println("Erro: Pilha vazia!");
		}else{
			x = itemArray[topo-1];
		}
			return( x );
	}
	
	public String toString() {
		String pilhaCompleta = "";
		if(vazia()) {
			pilhaCompleta = null;
 		}else{
 			for(int i = topo-1; i >= 0; i--) {
				pilhaCompleta = pilhaCompleta + "\n" + itemArray[i];
			}
		}
		return(pilhaCompleta);
	}
	
	public void inverse() {
		Object[] pilhaInverse = new Object[capacidade];
		if(vazia()) {
		 System.out.println("ERRO: pilha vazia!");
		} else {
			for (int aux = 0; aux < capacidade; aux++) {
				System.out.println(contador);
				pilhaInverse[aux] = desempilhar();
			}
			for (int aux = 0; aux < pilhaInverse.length; aux++) {
				empilhar(pilhaInverse[aux]);
			}
		}
		for(int i = 0; i < pilhaInverse.length; i++) {
			empilhar( pilhaInverse[i]);
		}
	}
	
	@SuppressWarnings("null")
	public Object clonar() {
		Object pilhaClone = null;
		if (vazia() ) {
			System.out.println("ERRO: Impossivel clonar");
		} else
			for (int aux = 0; aux <= topo-1; aux++) {
				pilhaClone += "\n" + itemArray[aux];
			}
		return(pilhaClone);
	}

	public NewPilhaEstatica(int maxCapacidade) {
		topo = 0;
		contador = 0;
		capacidade = maxCapacidade;
		itemArray = new Object[capacidade];
	}	

}