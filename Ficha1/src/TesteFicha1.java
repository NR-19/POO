import java.util.Scanner;

public class TesteFicha1 {

    public static void main(String[] args) {
        //inicialização de um scanner para leitura
        Scanner sc = new Scanner(System.in);

        //criar um objeto da classe que implementa os métodos
        Ficha1 f1 = new Ficha1();

        //pergunta 1
        System.out.println("Insira Graus:");
        double graus = sc.nextDouble();
        double farenheit = f1.celciusParaFarenheit(graus);
        System.out.println(graus + "G são " + farenheit + "F");

        //pergunta 2
        System.out.println("Insira dois numeros:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = f1.maximoNumeros(a,b);
        System.out.println("O maior número é o: " + c);

        //pergunta 3
        System.out.println("Insira um nome:");
        String nome = sc.next();
        System.out.println("Insira um saldo:");
        int saldo = sc.nextInt();
        String descisão = f1.criaDescricaoConta(nome,saldo);
        System.out.println(descisão);

        //pergunta 4
        System.out.println("Insira um valor em euros:");
        double euros = sc.nextDouble();
        System.out.println("Insira a taxa de conversão para libras:");
        double taxa = sc.nextDouble();
        double euroLibra = f1.eurosParaLibras(euros,taxa);
        System.out.println("O valor convertido é: " + euroLibra);

        //pergunta 5
        System.out.println("Insira dois números:");
        int um = sc.nextInt();
        int dois = sc.nextInt();
        String dec = f1.decrescenteMedia(um,dois);
        System.out.println(dec);

        //pergunta 6
        System.out.println("Insira um numero para fazer o seu fatorial:");
        int num = sc.nextInt();
        long fac = f1.factorial(num);
        System.out.println("O fatorial é: " + fac);

        //pergunta 7
        long tempo = f1.tempoGasto();
        System.out.println("O tempo gasto foi: " + tempo/100000.0);


    }
}
