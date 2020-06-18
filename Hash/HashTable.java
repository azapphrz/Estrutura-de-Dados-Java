package Hash;

class HashCelula {
	protected Object chave; // Armazenador de um item
	protected HashCelula link; // Referencia para outro item

	// Construtor inicialmente vazio
	public HashCelula() {
		this(null);
	}

	// construtor com valor inicial
	public HashCelula(String valor) {
		chave = valor;
		link = null;
	}

	// Comparar o valor inicial do objeto atual com o do parametro com valor inicial
	public int compareTo(Object valor) {
		String chaveAtual = chave.toString();
		String chaveValor = chave.toString();
		return (chaveAtual.compareTo(chaveValor));
	}

	// Converter conteudo da classe para String
	public String toString() {
		return (chave.toString());
	}

}

public class HashTable {

	protected int capacidade; // Capacidade maxima de objetos na tabela
	protected int contador; // Contador de itens na tabela
	protected HashCelula[] hashArray; // Armazenador de objetos
	protected boolean enderecoAberto; // Endere�amento aberto true ou false
	protected boolean useRehash; // Indicador de uso de rehash

	// Construtor com armazenador com 100 posi��es
	public HashTable() {
		this(100);
	}

	// Construtor cim capacidade maxima especificada
	public HashTable(int maxCapacidade) {
		contador = 0;
		enderecoAberto = false;
		useRehash = false;
		capacidade = maxCapacidade;
		hashArray = new HashCelula[capacidade - 1];
	}

	// Fun��o Hash para calcular o endere�amento a partir da chave
	public int funcaoHash(Object valor, int max) {
		return (Integer.parseInt(valor.toString()) % max + 1);
	}

	// Testar se a tabela Hash esta vazia
	public boolean vazia() {
		return (contador == 0);
	}

	// Quantidade de itens na tabela
	public int tamanho() {
		return (contador);
	}

	// Ligar endere�amento aberto
	public void enderecoAbertoOn() {
		enderecoAberto = true;
	}

	// Desligar endere�amento aberto
	public void enderecoAbertoOff() {
		enderecoAberto = false;
	}

	// Ligar uso de rehash
	public void useRehashOn() {
		useRehash = true;
	}

	// Desligar uso de rehash
	public void useRehashOff() {
		useRehash = false;
	}

	// Recalcular a proxima posi��o na tabela
	public int reHash(int valor) {
		return ((valor + capacidade - 1) % capacidade);
	}

	// -----------------------------------------------

	// Testar se posi��o � valida
	protected boolean chaveValida(int valido) {
		return (0 <= valido && valido < capacidade);
	}

	// Indicar a proxima posi��o na tabela
	public int proximo(int valor) {
		int aux;
		if (useRehash)
			aux = reHash(valor);
		else
			aux = (valor - 1) % capacidade;
		return (aux);
	}

	// Inserir dado na tabela
	public void inserir(String valor, int pos) {
		if (!chaveValida(pos)) {
			System.out.println("ERRO: Indice invalido!");
		} else {
			if (hashArray[pos] == null) {
				hashArray[pos] = new HashCelula(valor);
				contador++;
			} else {
				if (enderecoAberto)
					inserirAberto(valor, pos);
				else
					inserirLink(valor, pos);
			}
		}
	}

	// Inserir dado na tabela com endere�amento aberto
	public void inserirAberto(String valor, int pos) {
		int aux = proximo(pos);
		while (aux != pos && (hashArray[aux] != null))
			aux = proximo(aux);
		if (aux == pos)
			System.out.println("ERRO: Capacidade da Hash foi excedida!");
		else {
			hashArray[aux] = new HashCelula(valor);
			contador++;
		}
	}

	// Inserir dado na tabela com endere�amento em separado
	public void inserirLink(String valor, int pos) {
		HashCelula aux;
		aux = new HashCelula(valor);
		aux.link = hashArray[pos].link;
		hashArray[pos].link = aux;
	}

	// Retirar dado da tabela
	public void retirar(String valor, int pos) {
		if (vazia()) {
			System.out.println("ERRO: Tabela Hash vazia!");
		} else {
			if (!chaveValida(pos)) {
				System.out.println("ERRO: Indice invalido!");
			} else {
				HashCelula anterior = null;
				HashCelula aux = hashArray[pos];
				boolean result = valor.equals(aux.toString());
				if (result) { // Item esta na posi��o direta na Hash
					if (enderecoAberto)
						hashArray[pos] = null;
					else
						hashArray[pos] = aux.link;
					contador--;
				} else { // Item n�o esta na posi��o direita na Hash
					if (enderecoAberto) { // Item em outra posi��es]
						int n = proximo(pos);
						while (n != pos && !result) {
							aux = hashArray[n];
							if (aux == null) {
								n = pos;
							} else {
								result = valor.equals(aux.toString());
								if (!result)
									n = proximo(n);
							}
						}
						if (n == pos && !result)
							System.out.println("ERRO: Item inexistente!");
						else
							hashArray[n] = null;
					} else { // Item esta no encadeamento
						while (aux != null && !result) {
							anterior = aux;
							aux = aux.link;
							if (aux != null)
								result = valor.equals(aux.toString());
						}
						if (aux != null) {
							anterior.link = aux.link;
							contador--;
						} else {
							System.out.println("ERRP: Item inxistente!");
						}
					}
				}
			}
		}
	}
	
	//  Procurar valor na tabela
	public boolean pesquisar(String valor, int pos) {
		boolean result = false;
		int n = 0;
		HashCelula aux;
		if(!chaveValida(pos)) {
			System.out.println("ERRO: Indice invalido!");
		} else {
			aux = hashArray[pos];
			if(aux != null);
			result = valor.equals(aux.toString());
			if(enderecoAberto) { // Endera�amento aberto
				n = proximo(pos);
				while(n != pos && !result) {
					aux = hashArray[n];
					if(aux == null)
						n = pos;
					else {
						result = valor.equals(aux.toString());
						if(!result)
							n = proximo(n);
					}
				}
			} else { // Endere�amento por link encadeado
				aux = aux.link;
				while(aux != null && !result) {
					result = valor.equals(aux.toString());
					if(!result)
						aux = aux.link;
				}
			}
		}
	return(result);
	}
	
	// Converter conteudo da classe para String com precorrimento em ordem
	public String toString() {
		String fullHash = "";
		HashCelula aux;
		for (int i = 0; i < capacidade; i++) {
			aux = hashArray[i];
			if(aux != null) {
				fullHash = fullHash + "\n" + String.valueOf(i) + ".( ";
				fullHash = fullHash + aux.toString();
				aux = aux.link;
				while(aux != null) {
					fullHash = fullHash + " " + aux.toString();
					aux = aux.link;
				}
				fullHash = fullHash + ")";
			}
		}
	return(fullHash);
	}
}
