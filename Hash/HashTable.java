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
}

public class HashTable {

}
