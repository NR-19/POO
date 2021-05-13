import java.util.Arrays;
import java.util.Scanner;

public class TesteEx1 {
    public static void main(String[] args) {

        Ex1 ex1 = new Ex1();
        Scanner sc = new Scanner(System.in);
        //a)
        System.out.println("\tAlinea a)");
        System.out.println("Quantos números quer ler?");

        int dim = sc.nextInt();
        int[] numeros = new int[dim];
        System.out.println("Insira " + dim + " números: ");
        for (int i = 0; i<dim; i++){
            numeros[i] = sc.nextInt();
        }
        int min = ex1.minimo(numeros);
        System.out.println("O mínimo é: " + min);
        //b)
        System.out.println("Alinea b)");
        System.out.println("Insira um índice do array:");
        int ini = sc.nextInt();
        System.out.println("Insira um posterior índice do array:");
        int fini = sc.nextInt();
        int[] parteArray = ex1.arrayEntreIndices(numeros,ini,fini);
        System.out.println("O array entre esses indices é: " + Arrays.toString(parteArray));
        //c)
        System.out.println("Vamos criar um novo array!");
        System.out.println("Quantos números quer ler?");
        int dim2 = sc.nextInt();
        int[] numeros2 = new int[dim2];
        System.out.println("Insira " + dim2 + " números: ");
        for (int i = 0; i<dim2; i++){
            numeros2[i] = sc.nextInt();
        }
        int[] comuns = ex1.elementosComuns(numeros,numeros2);
        System.out.println("Os elementos comuns são: " + Arrays.toString(comuns));
    }
}
