import java.util.Comparator;

public class PerímetroDecrescente implements Comparator<Triangulo> {

    public int compare(Triangulo t1, Triangulo t2){
        return (int) (t2.calculaPerimetroTriangulo() - t1.calculaPerimetroTriangulo());
    }
}
