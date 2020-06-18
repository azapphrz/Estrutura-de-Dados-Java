package Lista;

public class ListaEstatica {

	private int inicio;	// Indicador do inicio da lista
	private int fim;	// Indicador do fim da lista
	private int contador;  // Contado de elementos na lista
	private int capacidade; //Capacidade m�xima da lista
	private Object[] itemArray;  // Armazenador de objetos 
	
	public ListaEstatica() {
		this(10);
	}
	//Construtor com capacidade m�xima especificada
	public ListaEstatica(int maxCapacidade) {
		inicio = 0;
		fim = 0;
		contador = 0;
		capacidade = maxCapacidade; 
		itemArray = new Object[capacidade];
	}
	
	public boolean vazia() {
		return(contador == 0);
	}
	
	public int tamanho() {
		return (contador);
	}
	
	private boolean chaveValida(int posicao) {
		return(1 <= posicao && posicao <= contador);
	}
	// Inserir objeto na lista
	public void inserir(Object novotem) {
		inserir(novotem, contador+1);
	}
	// Inserir objeto no inicio da lista 
	public void inserirInicio(Object novoItem) {
		inserir(novoItem, 0);
	}
	// Inserir objeto no fim da lista
	public void inserirFim(Object novoItem) {
		inserir(novoItem, contador);
	}
	// Inserir objeto na lista em um certa posicao 
	public void inserir(Object novoItem, int posicao) { 
		if(contador == capacidade){ 
			System.out.println("Erro: Capacidade da Lista foi excedida!");
		} else { 
			if(posicao == contador+1){ // Inserir no fim 
			itemArray[fim] = novoItem; 
			fim = (fim + 1) % capacidade;
			contador++;
			} else { 
				if(posicao == 0){ // Inserir no inicio 
					mover(inicio, fim, 1); 
					itemArray[0] = novoItem; 
					inicio = 0; 
					contador++;
				} else { 
					if(!chaveValida(posicao)) { 
						System.out.println("Erro: Indice invalido!");
					} else { 
						mover(posicao-1, fim, 1); 
						itemArray[posicao-1] = novoItem;
						contador++;
					} 
				}
			}
		}
	}
	// Deslocar itens na lista para a direita(1) ou esquerda(-1)
	private void mover(int begin, int end, int shift) {
		int i, j;
		if(shift == 1) { // Deslocamento para a direita
			if(end <= capacidade) { // Indice dentro do vetor
				if(end == fim) {
					fim = ( fim + 1 ) % capacidade;
				}
				if( fim != inicio) { // A lista nao esta cheia 
					j = ( end + 1 ) % capacidade;
					i = end;
				} else { // Caso a lista esteja cheia
					j = end;
					i = end-1;
				}
				while(i != begin && i != inicio){ // Procede o deslocamento
					itemArray[j] = itemArray[i];
					j = i;
					i = (i + capacidade-1) % capacidade;
				}
				itemArray[j] = itemArray[i];
				if(begin == inicio) { // Atualiza indice inicio, se lista cheia
					inicio = (inicio + 1) % capacidade;
				} 
			} 
		} else { // Deslocamento para a esquerda
			if(begin <= capacidade) {	// Indice dentro do vetor
				if(begin <= capacidade) { // Atualiza indice inicio
					inicio = (inicio + capacidade - 1) % capacidade;
				}
				if(fim != inicio) {  //
					j = begin-1;
					i = begin;
				} else { // Caso a lista esteja cheia
					j = begin-1;
					i = begin % capacidade;
				}
				while(i != end && i != fim) { //Procede o deslocamento
					itemArray[j] = itemArray[i];
					j = i;
					i = (i + 1) % capacidade;
				}
				if(end != fim) { // Retirando item da lista cheia
					itemArray[j] = itemArray[i];
				}
				if(end == fim) {
					fim = (fim + capacidade - 1) % capacidade;
				}
			}		
		} 
	}
	// Retirar objeto no inicio da lista 
	public Object retirarInicio(){ 
		return(retirar(inicio));
	}
	// Retirar objeto no fim da lista 
	public Object retirarFim() { 
		return(retirar(contador));
	}
	
	public Object retirar(int posicao) {
		Object x = null;
		int i, j;
		if(vazia()) { 
			x = "'Erro: Lista vazia!'";
		} else {
			if(posicao == inicio) { // Retirar do inicio
				x = itemArray[inicio];
				inicio = (inicio + 1) % capacidade;
				contador--;
			} else {
				if(posicao == fim) { // Retirar do fim
					if(fim != 0) { 
						x = itemArray[fim-1];
						fim = (fim + capacidade-1) % capacidade;
					} else { 
						fim = (fim + capacidade-1) % capacidade;
						x = itemArray[fim];
					}
					contador--;
				} else { // Retirar do meio
					if(!chaveValida(posicao)) {
						x = "'Erro: Indice invalido!'";
					} else {
						i = inicio;
						for(j = 1; j < posicao; j++) {
							i = (i + 1) % capacidade;
						} 
					x = itemArray[i];
					mover(posicao+1, fim, -1);
					contador--;
					}
				}
			}
		}			
		return(x);
	}
	//Converter conteudo da classe para String 
	public String toString() { 
		String listaCompleta = "";
		if(vazia()) {
			listaCompleta = null;
		} else {
			int i = inicio;
			for(int j = 1; j <= contador; j++) {
				listaCompleta = listaCompleta + "\n" + itemArray[i];
				i = ( i + 1 ) % capacidade;
			} 
		}
	return(listaCompleta); 
	}
	// Limpar o conteudo da lista
	public void limpar() {
		for (int i = 0; i <= contador+1; i++) {
			itemArray[i] = retirar(i);
		}
	}
	// Consultar o primeiro item da lista
	public Object consultarInicio() {
		return(itemArray[inicio]); 
	}
	// Consultar o ultimo item da lista
	public Object consultarFim() {
		return(itemArray[contador-1]); 
	}
	//Buscar um item na lista
	public int buscar(Object busca) {
		int posicao = -1;
		if (!vazia()) {
			for (int i = 0; i < contador; i++) {
				if (itemArray[i] == busca) {
					posicao = i+1;
				}
			}
		} else {
			System.out.println(("ERRO: Lista Vazia!"));
		}
		return(posicao);
	}
	
//	public void intersecao(){
//		PilhaEstatica pilhaComun;
//		if (!vazia()) {
//			for (int i = 0; i < contador; i++) {
//				if (itemArray[i] == pilhaComun[i]) {
//					
//				}
//			}
//		} else {
//			System.out.println(("ERRO: Lista Vazia!"));
//		}
//	}
}
