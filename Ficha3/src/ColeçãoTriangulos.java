import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ColeçãoTriangulos {

    private List<Triangulo> triangulos;

    public ColeçãoTriangulos(){
        this.triangulos = new ArrayList<>();
    }

    public ColeçãoTriangulos(List<Triangulo> tr){
        this.triangulos = new ArrayList<>();
        for(Triangulo t : tr){
            this.triangulos.add(t.clone());
        }
    }

    public ColeçãoTriangulos(ColeçãoTriangulos ct){
        this.triangulos = ct.getTriangulos();
    }

    public List<Triangulo> getTriangulos(){
        /*
        List<Triangulo> res = new ArrayList<>();
        for(Triangulo t : this.triangulos){
            res.add(t.clone());
        }
        return res;
        */
        return this.triangulos.stream().map(Triangulo::clone).collect(Collectors.toList());
    }

    public void inserir(Triangulo t){
        this.triangulos.add(t.clone());
    }

    public boolean existeTriangulo(Triangulo t){
        return this.triangulos.contains(t);
    }

    public Triangulo maiorArea(){
        double areaM = 0;
        Triangulo tM = null;
        for(Triangulo t : this.triangulos){
            double area = t.calculaAreaTriangulo();
            if(area > areaM) {
                areaM = area;
                tM = t.clone();
            }
        }
        return tM;
    }

}
