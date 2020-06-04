package Arvore;

class LBSTreeNode {
	
	Object item; // Armazenador de um item
	LBSTreeNode linkLeft; // Referencia para um item à esquerda
	LBSTreeNode linkRight; // Referencia para um item à direita
	
	// Construtor padrao inicialmente vazio
	public LBSTreeNode() {
	this(null);
	}
	// Construtor alternativo com valor inicial
	public LBSTreeNode(Object valorItem) {
		item = valorItem;
		linkLeft = linkRight = null;
	}
	// Comparar o valor do nodo como o parametro
	public int compararCom(Object valorItem) {
		String chaveAtual = (String) this.item;
		String chaveValor = (String) valorItem;
		return(chaveAtual.compareTo(chaveValor));
	}
	// Converte conteudo da classe para String
	public String toString() {
		return(item.toString());
	}
	
}

public class LBSTree {

	protected LBSTreeNode raiz; // Indicador da raiz da arvore
	protected int counter; // Contador de elementos na arvore
	protected String treeString; // Armazenador de itens na arvore
	
	public final int PREOrder = 1; // Raiz -> Esquerda -> Direita
	public final int INOrder = 2; // Esquerda -> Raiz -> Direita
	public final int POSTOrder = 3; // Esquerda -> Direita -> Raiz
	
	// Construtor padrao inicialmente vazia
	public LBSTree() {
		raiz = null;
		counter = 0;
	}
	// Testar se arvore vazia
	public boolean vazia() {
		return(raiz == null);
	}
	// Quantidade de itens na arvore
	public int tamanho() {
		return(counter);
	}
	// Inserir objeto na arvore
	public void inserir(Object newItem) {
		raiz = inserir(newItem, raiz);
	}
	// Inserir cadeia de caracteres na arvore
	public LBSTreeNode inserir(Object newItem, LBSTreeNode treeRef) {
		int result;
		if(treeRef == null) { // Arvore vazia
			LBSTreeNode newNode = new LBSTreeNode(newItem);
			treeRef = newNode;
			counter++;
		} else {
			result = treeRef.compararCom(newItem);
			if(result > 0) 
				treeRef.linkLeft = inserir(newItem, treeRef.linkLeft);	
			 else  
				 treeRef.linkRight = inserir(newItem, treeRef.linkRight);				
		}
		return(treeRef);
	}
	// Retirar um item da arvore
	public void retirar(Object item) {
		retirar(item, raiz);
	}
	// Remove um item da arvore
	public void retirar(Object item, LBSTreeNode treeRef) {
		LBSTreeNode antecessor = null;
		if(vazia()) { // Verificar se a arvore esta vazia
			System.out.println("EERO: Árvore vazia!");
		} else { // Obtem o sucessor (pai) di=o item a ser retirado
			while (treeRef != null && treeRef.item != item) {
				antecessor = treeRef;
				if(treeRef.compararCom(item) > 0)
					treeRef = treeRef.linkLeft;
				else 
					treeRef = treeRef.linkRight;
			}
			if(treeRef.linkLeft == null && treeRef.linkRight == null) { // Folha
				if(treeRef != raiz) { // Não é a raiz
					if(treeRef == antecessor.linkLeft)
						antecessor.linkLeft = null;
					else
					antecessor.linkRight = null;
				} else { //É a raiz
					raiz = null;
				}
			} else if(treeRef.linkLeft != null && treeRef.linkRight != null) { // Ramo com dois filhos
				LBSTreeNode sucessor;
//				if(treeRef == raiz)
					sucessor = valorMaximo(treeRef.linkLeft);
//				else
//					sucessor = valorMinimo(treeRef.linkRight);
				Object valorItem = sucessor.item;
				retirar(sucessor.item);
				treeRef.item = valorItem;
			} else { // Ramo com apenas um filhos
				LBSTreeNode folha = (treeRef.linkLeft != null) ? treeRef.linkLeft : treeRef.linkRight;
				if(treeRef != raiz) { // Não é a raiz
					if (treeRef == antecessor.linkLeft)
						antecessor.linkLeft = folha;
					else
						antecessor.linkRight = folha;
				} else { // É a raiz
					raiz = folha;
				}
			}
		}
	}
	// Encontra o item com menor valor na subarvore
	protected LBSTreeNode valorMaximo(LBSTreeNode treeNode) {
		while (treeNode.linkRight != null) {
			treeNode = treeNode.linkRight;
		}
		return(treeNode);
	}	
//	protected LBSTreeNode valorMinimo(LBSTreeNode treeNode) {
//		while (treeNode.linkLeft != null) {
//			treeNode = treeNode.linkLeft;
//		}
//		return(treeNode);
//	}
	// Procurar cadeia de caracteres na arvore
	LBSTreeNode buscar(Object valorItem) {
		LBSTreeNode treeRef = raiz;
		int result = 1;
		while(treeRef != null && result != 0) {
			result = treeRef.compararCom(valorItem);
			if (result > 0) 
				treeRef = treeRef.linkLeft; 
			else
				if (result < 0)
					treeRef = treeRef.linkRight;
		}
		return(treeRef);
	}
	// Percorrer os nodos na arvore em ordem
	protected void inOrder(LBSTreeNode treeRef) {
		if (treeRef != null) {
			treeString = treeString + "(";
			inOrder(treeRef.linkLeft);
			treeString = treeString + " " + treeRef.item + " ";
			inOrder(treeRef.linkRight);
			treeString = treeString + ")";
		} 
	}
	// Percorrer os nodos na arvore em pre-ordem
	protected void preOrder(LBSTreeNode treeRef) {
		if (treeRef != null) {
			treeString = treeString + "(";
			treeString = treeString + " " + treeRef.item + " ";
			preOrder(treeRef.linkLeft);
			preOrder(treeRef.linkRight);
			treeString = treeString + ")";
		} 
	}
	// Percorrer os nodos na arvore em pos-ordem
	protected void postOrder(LBSTreeNode treeRef) {
		if (treeRef != null) {
			treeString = treeString + "(";
			postOrder(treeRef.linkLeft);
			postOrder(treeRef.linkRight);
			treeString = treeString + " " + treeRef.item + " ";
			treeString = treeString + ")";
		} 
	}
	// Percorrer os nodos na arvore em ordem
	public String caminhar() {
		return (caminhar(INOrder));
	}
	// Percorrer os nodos em uma ordem desejada
	public String caminhar(int nodo) {
		treeString = "\n";
		switch (nodo) {
		case PREOrder:
			preOrder(raiz);
			break;
		case INOrder:
			inOrder(raiz);
			break;
		case POSTOrder:
			postOrder(raiz);
			break;
		default:
			System.out.println("ERRO: Modo de caminhamento desconhecido!");
		}
		return(treeString);
	}
	// Converter conteudo da classe para String ccom caminhamento em ordem
	public String toString() {
		treeString = "";
		inOrder(raiz);
		return(treeString);
	}

	public Object consultarRaiz() {
		Object aux = raiz;
		return(aux);
	}
	
	public int altura() {
		return(alturaArvore(raiz));
	}
	
	public int alturaArvore(LBSTreeNode treeRef) {
	     if(treeRef == null)
	       return (-1);
	     else 
	    	return(1 + Math.max(alturaArvore(treeRef.linkRight), 
	    			alturaArvore(treeRef.linkLeft)));
	     // Não usando função do Java
//	    	int le = alturaArvore (treeRef.linkLeft);
//	    	int ld = alturaArvore (treeRef.linkRight);
//	    	if (le < ld) 
//	    		return ld + 1;
//	    	else 
//	    		return le + 1;
	  }
	
	public int grau(LBSTreeNode treeRef) {
		if (vazia()) {
			System.out.println("ERRO: Arvore vazia!");
			return(-1);
		} else {
			if (buscar(treeRef) == null) {
				System.out.println("ERRO: Não existe o item na Arvore!");
				return(-1);
			} else {
				return()
			}
		}
	}
}