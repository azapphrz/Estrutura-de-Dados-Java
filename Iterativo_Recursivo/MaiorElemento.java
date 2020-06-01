package Iterativo_Recursivo;

public class maiorElemento{

    public static int maiorElemento(int[] elementos){
        int temp;
        temp = elementos[0];
        for(int i = 1; i < elementos.length; i++){
            if(temp < elementos[i]){
                temp=elementos[i];
                
            }
          
        }
        return (temp);		
    }

     public static void main(String[]args) {
    	 int[] vet ={5,8,-9,2,0,3,-12};
    	System.out.print(maiorElemento(vet));    
    }
}
