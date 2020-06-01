package Fila;

public class FilaEstatica{
	private int inicio; // indicador do inicio da fila
	private int fim; // indicador do fim da fila
	private int contador; // contador de elementos na fila
	private int capacidade; // capacidade maxima da fila
	private Object[] itemArray; // armazenador de objetos

	public FilaEstatica(){
		this( 100 );
	}

	public FilaEstatica( int maxCapacidade ){
		inicio = 0;
		fim = 0;
		contador = 0;
		capacidade = maxCapacidade;
		itemArray = new Object[ capacidade ];
	}

	public boolean vazia(){
		return( contador == 0 );
	}

	public int tamanho(){
		return( contador );
	}
	
	public void enfileirar( Object newItem ){
		if( contador == capacidade ){
			System.out.println( "Erro: Capacidade da Fila foi excedida!" );
		} else {
 			itemArray[ fim ] = newItem;
	 		fim = ( fim + 1 ) % capacidade;
			contador++;
		}
	}
	
	public boolean cheia() {
		return (contador == capacidade);
	}

	public Object desenfileirar(){
		Object x = null;
		if( vazia() ){
			System.out.println( "Erro: Fila vazia!" );
		} else {
			x = itemArray[ inicio ];
			inicio = ( inicio + 1 ) % capacidade;
			contador--;
		}
		return( x );
	}

	public Object consultarInicio(){
		Object x = null;
		if( vazia() ){
			System.out.println( "Erro: Fila vazia!" );
		} else {
			x = itemArray[ inicio ];
		}
		return( x );
	}

	public Object consultarFim(){
		Object x = null;
		if( vazia() ){
 			System.out.println( "Erro: Fila vazia!" );
		} else {
			if( fim == 0 ){
				x = itemArray[ capacidade-1 ];
			} else {
				x = itemArray[ fim-1 ];
			}
		}
		return( x );
	}
	
	public String toString() {
		String filaCompleta = "";
		if( vazia() ){
			filaCompleta = null;
		} else {
			int j = inicio;
			for( int i = 0; i < contador; i++ ){
				filaCompleta = filaCompleta + "\n" + itemArray[ j ];
				j = ( j + 1 ) % capacidade;
			}
		}
		return( filaCompleta );
	}
	
	public boolean buscar(Object item) {
		String busca = item.toString();
		return (toString().contains(busca));
	}
	
	public void limpar() {
		for (int i = 0; i <= tamanho()+6; i++) {
			itemArray[i] = desenfileirar();
		}
	}
}