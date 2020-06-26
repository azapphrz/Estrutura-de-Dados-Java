package Lista;

class Celula {
	
	Object item; // Armazenador de onbjeto
	Celula link; // Referrncia para outra Celula (objeto)

	// Construtor com arzenador de objeto e referencia nulos
	public Celula() {
		item = null;
		link = null;
	}
	// Construtor com valor inicial e referencia nula
	public Celula(Object valorItem) {
		item = valorItem;
		link = null;
	}
	// Construtor altenativo com valor e referencia
	public Celula(Object valorItem, Celula linkCelula) {
		item = valorItem;
		link = linkCelula;
	}
}

public class ListaDinamica {
	
	private Celula inicio; // Referencia para o inicio da lista
	private Celula fim; // Referencia para o fim da lista
	private int contador; // Contador de itens na lista
	
	// Construtor com referencias e contador nulos
	public ListaDinamica() {
		inicio = fim = null;
		contador = 0;
	}
	//Testar se lista vazia
	public boolean vazia() {
		return(contador == 0);
	}
	// Quantidade de itens na lista
	public int tamanho() {
		return(contador);
	}
	// Testar se posicao valida
	public boolean chaveValida(int x) {
		return(1 <= x && x <= contador);
	}
	// Inserir objeto na lista em uma certa posi��o
	public void inserir(Object novoItem, int posicao) {
		Celula novaCelula, tempCelula;
		int i;
		if(posicao == contador+1) {  // Inserir no fim da lista
			novaCelula = new Celula(novoItem);
			if(inicio == null) {
				inicio = novaCelula;
			} else {
				fim.link = novaCelula;
			}
			fim = novaCelula;
			contador++;
		} else {
			if (posicao == 1) { // Inserir no inicio da lista
				novaCelula = new Celula(novoItem, inicio);
				if(fim == null) {
					fim = novaCelula;
				}
				inicio = novaCelula;
				contador++;
			} else { // Inserir no meio da lista
				if(!chaveValida(posicao)) {
					System.out.println("ERRO: Indice invalido!");
				} else {
					tempCelula = inicio;
					for (i = 0; i < posicao; i++) {
						tempCelula = tempCelula.link;
					}
					novaCelula = new Celula(tempCelula.item, tempCelula.link);
					tempCelula.link = novaCelula;
					if(tempCelula == fim) {
						fim = novaCelula;
					}
					tempCelula.item = novoItem;
					contador++;
				}
			}
		}
	}
	// Inserir objeto na lista
	public void inserir(Object novotem) {
		inserir(novotem, contador+1);
	}
	// Inserir objeto no inicio da lista
	public void inserirInicio(Object novoItem) {
		inserir(novoItem, 1);
	}
	// Inserir objeto no fim da lista
	public void inserirFim(Object novoItem) {
		inserir(novoItem, contador+1);
	}
	// Retirar objeto de uma posicao da lista
	public Object retirar(int posicao) {
		Object x = null;
		Celula tempCelula;
		int i;
		if(vazia()) {
			System.out.println("ERRO: Lista vazia!");
		} else {
			if (posicao == 1) { // Retirar no inicio da lista
				x = inicio.item;
				inicio = inicio.link;
				if(inicio == null) {
					fim = null;
				}
				contador--;
			} else {
				if(posicao == contador) { // Retira no fim da Lista
					tempCelula = inicio;
					for (i = 1; i < contador-1; i++) {
						tempCelula = tempCelula.link;
					}
					x = fim.item;
					fim = tempCelula;
					if(fim == null) {
						inicio = fim;
					} else {
						fim.link = null;
					}
					contador--;
				} else { // Retirar no meio da Lista
					if(!chaveValida(posicao)) {
						System.out.println("ERRO: Indice invalido!");
					} else {
						tempCelula = inicio;
						for(i = 1; i < posicao-1; i++) {
							tempCelula = tempCelula.link;
						}
					x = tempCelula.link.item;
					tempCelula.link = tempCelula.link.link;
					contador--;
					}
				}
			}
		}
		return(x);
	}
	// Retirar objeto no inicio da lista
	public Object retirarInicio() {
		return(retirar(1));
	}
	
	// Reitrar objeto no fim da lista
	public Object retirarFim() {
		return(retirar(contador));
	}
	// Conveter conteudo da classe para String
	public String toString() {
		String listaCompleta = "";
		if(vazia()) {
			listaCompleta = listaCompleta + null;
		} else {
			Celula listaCelula = inicio;
			while(listaCelula != null) {
				listaCompleta = listaCompleta + "\n" + listaCelula.item;
				listaCelula = listaCelula.link;
			}
			listaCompleta = listaCompleta + "";
		}
		return (listaCompleta);
	}
	// Limpar o conteudo da lista
	@SuppressWarnings("unused")
	public void limpar() {
		for (int i = contador; i >= 0; i--) {
			Object item = retirar(i);
			inicio = fim = null;
		}
	}
	// Consultar o primeiro item da lista
	public Object consultarInicio() {
		if(!vazia())
			return(inicio.item); 
		else
		return("Erro: lista vazia");
	}
	// Consultar o ultimo item da lista
	public Object consultarFim() {
		if(!vazia())
			return(fim.item);
		else
		return("Erro: lista vazia");
	}
		
	public Celula buscar(Object item) {
		Celula atual = inicio;

		while (atual != null) {
			if (atual.item.equals(item)) {
				return atual;
			}
			atual = atual.link;
		}
		return atual;
		
	}

    public void trocar(Object item1, Object item2) {
        if (vazia()) {
            System.out.println("ERRO: Lista vazia!");
        } else {
            if ((buscar(item1) != null) && (buscar(item2) != null)) {
                Celula x = inicio;
                while(x != null) {
                    if(x.item == item1) {
                        x.item = item2;
                    } else if (x.item == item2) {
                    	x.item = item1;
                    }
                    x = x.link;
                }
            } else {
                System.out.println("ERRO: Um dos itens n�o existe!");
            }
        }
    }
	
//	public Celula consultar(Object item) {
//		Celula atual = inicio; 	
//		if(vazia())
//			return (atual == null);
//		else
//		while (atual != null) {
//			if (atual.item.equals(item)) {
//				return atual;
//			}
//			atual = atual.link;
//		}
//		return atual;
//		
//	}
}
