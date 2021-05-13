import java.util.Arrays;

/**
 * Classe com os métodos do Exercicio 1 Ficha 2
 */
public class Ex1 {
    /**
     * Calcular o mínimo dum array de inteiros
     */
    public int minimo(int[] numeros){
        int min = Integer.MAX_VALUE;
        for (int n : numeros){
            if(n < min) min = n;
        }
        return min;
    }

    /**
     * Método que deternima o array entre dois indices
     */
    public int[] arrayEntreIndices(int[] numeros, int i, int f){
        int dim = f-i+1;
        int[] res = new int[dim];
        System.arraycopy(numeros,i,res,0,dim);
        return res;
    }

    /**
     * Método que lê dois arrays e determina o array com os elemntos comuns aos dois arrays
     */
    public int[] elementosComuns(int[] a1, int[] a2){
        int dim = 0;
        int[] comuns = new int[a1.length+a2.length];
        for (int i : a1){
            for (int j : a2){
                if (i == j){
                    if (!existeNoArray(i,comuns)) {
                        comuns[dim] = i;
                        dim++;
                    }
                }
            }
        }
        int[] resultado = new int[dim];
        System.arraycopy(comuns,0,resultado,0,dim);
        return resultado;
    }

    /**
     * Método auxiliar que verifica se um dado elemento se encontra no array
     */
    public boolean existeNoArray(int x, int[] numeros){
        for (int n : numeros){
            if(x == n) return true;
        }
        return false;
    }
}
