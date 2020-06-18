package OrdenacaoMetedos;

import java.util.*;

public class Ordenacao{

    // Gerar uma sequencia de dados aleatorios
    public  int [] geradorAleatorio (int qtde, int intervalo){
        Random gerador = new Random();
        int [] numeros = gerador.ints(0, intervalo).limit(qtde).toArray();
        return (numeros);
    }

    // Exibe o vetor passado como parametro
    public String exibirVetor (int[] vet) {
        String strVet = "";
        for (int i = 0; i < vet.length; i++){
            strVet += vet[i] + " ";
        }
    return (strVet);
    }

    public  int[] BubbleSort(int[] vet){
        for (int i = 0; i < vet.length; i++){
            for (int j = 0; j < vet.length -1; j++){
                if (vet[j] > vet[j + 1]){
                    int aux = vet[j];
                    vet [j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        return(vet);
    }

    public  int[] SelectionSort(int[] vet){
        for( int fixo = 0; fixo < vet.length-1; fixo++ ){
            int menor = fixo;
            for( int i = menor + 1; i < vet.length; i++ ){
                if( vet[ i ] < vet[menor]){
                    menor = i;
                }
            }
            if(menor != fixo){
                int aux = vet[fixo];
                vet[fixo] = vet[menor];
                vet[menor] = aux;
            }
        }
        return(vet);
    }

    public  int[] InsertionSort (int[] vet){
    	int chave, j;
    	for(int i = 0; i < vet.length; i++) {
    		chave = vet[i];
    		j = i - 1;
    		while(j >= 0 && vet[j] > chave) {
				vet[j + 1] = vet[j];
    			j = j - 1;
    		}
    		vet[j + 1] = chave;
    	}
    	return(vet);
    }
    
    public int[] QuickSort(int[] vet, int inicio, int fim) {
    	if( inicio < fim ) {
    		int posicaoPivo = separar(vet, inicio, fim);
    		QuickSort(vet, inicio, posicaoPivo - 1);
    		QuickSort(vet, posicaoPivo + 1, fim);
    	}
    	return( vet );
    }
    private  int separar(int[] vet, int inicio, int fim) {
    	int pivo = vet[inicio];
    	int i = inicio + 1, f = fim;
    	while(i <= f) {
    		if(vet[i] <= pivo) {
    			i++;
    		}
    		else if( pivo < vet[ f ] ) {
    			f--;
    		}
    		else {
    			int troca = vet[ i ];
    			vet[ i ] = vet[ f ];
    			vet[ f ] = troca;
		    	i++;
		    	f--;
		    }
    	}
    	vet[inicio] = vet[ f ];
    	vet[f] = pivo;
    	return(f);
    }
    
    public int[] MergeSort(int[] vet, int baixo, int alto){
    	if(baixo < alto){
    		int medio = ( baixo + alto ) / 2;
    		MergeSort(vet, baixo, medio );
    		MergeSort(vet, medio+1, alto );
    		Merge( vet, baixo, medio, alto );
    	}
    	return(vet);
    }
    private void Merge( int[] vet, int baixo, int medio, int alto ){
    	int[] vetAux = new int[ vet.length ];
    	for( int i = baixo; i <= alto; i++ ){
    		vetAux[i] = vet[i];
    	}
    	int vetEsquerdo = baixo;
    	int vetDireito = medio + 1;
    	int atual = baixo;
    	while(vetEsquerdo <= medio && vetDireito <= alto ){
    		if(vetAux[ vetEsquerdo ] <= vetAux[ vetDireito ]){
    			vet[atual] = vetAux[vetEsquerdo];
    			vetEsquerdo++;
    		} else {
    			vet[atual] = vetAux[vetDireito];
    			vetDireito++;
    		}
    	atual++;
    	}
    	int restante = medio - vetEsquerdo;
    	for(int i = 0; i <= restante; i++) {
    		vet[atual + i] = vetAux[vetEsquerdo + i];
    	}
    }
    
	public int[] ShellSort(int[] vet){
	    int i , j , temp, size = vet.length;
	    int incremento = 1;
	    while(incremento < size) {
	        incremento = 3 * incremento + 1;
	    }
	     
	    while (incremento > 1) {
	        incremento /= 3;
	        
	        for(i = incremento; i < size; i++) {
	            temp = vet[i];
	            j = i - incremento;
	            while (j >= 0 && temp < vet[j]) {
	                vet[j + incremento] = vet[j];
	                j -= incremento;
	            }
	            vet [j + incremento] = temp;
	        }
	    }	
	    return(vet);
	}
}