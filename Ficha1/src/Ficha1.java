import java.time.LocalDateTime;

public class Ficha1 {

    //pergunta 1
    public double celciusParaFarenheit(double graus){
        return graus * 1.8 + 32;
    }

    //PERGUNTA 2
    public int maximoNumeros(int a, int b){
        return Math.max(a,b);
    }

    //pergunta 3
    public String criaDescricaoConta(String nome, double saldo){
        return "O elemento " + nome + " tem " + saldo + " euros de saldo.";
    }

    //pergunta 4
    public double eurosParaLibras(double valor, double taxaConversao){
        return valor * taxaConversao;
    }

    //pergunta 5
    public String decrescenteMedia(int a, int b){
        int media = (a+b)/2;
        return "Valores por ordem decrescente: " + Math.max(a,b) + " " + Math.min(a,b)
                + " e a sua média é: " + media;
    }

    //pergunta 6
    public long factorial(int num){
        long res = num;
        for(long i = (num-1); i > 0; i--){
            res *= i;
        }
        return res;
    }

    //pergunta 7
    public long tempoGasto(){
        int inicial = LocalDateTime.now().getNano();
        long fac5000 = factorial(5000);
        int tempExec = LocalDateTime.now().getNano() - inicial;
        return tempExec;
    }
}
