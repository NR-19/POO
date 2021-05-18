import java.util.*;
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
        Triangulo tM = new Triangulo();
        for(Triangulo t : this.triangulos){
            double area = t.calculaAreaTriangulo();
            if(area > areaM) {
                areaM = area;
                tM = t.clone();
            }
        }
        return tM;
    }
    //versao com iteradores
    public Triangulo maiorAreaIt(){
        double areaM = 0;
        Triangulo tM = new Triangulo();
        Iterator<Triangulo> it = this.triangulos.iterator();
        while(it.hasNext()){
            Triangulo t = it.next();
            double area = t.calculaAreaTriangulo();
            if(area > areaM) {
                areaM = area;
                tM = t;
            }
        }
        return tM.clone();
    }

    //outra implemantação do metodo recorrendo a ordenação com Set<Triangulo>
    //orden natural - confiar na implemantação de compareTo da classe Triangulo
    public Triangulo maiorAreaOrd(){
        TreeSet<Triangulo> ord = new TreeSet<>();
        for(Triangulo t : this.triangulos){
            ord.add(t);
        }
        return ord.last().clone();
    }

    //outra implemantação do metodo recorrendo a ordenação com Set<Triangulo>
    //comparador - defenir uma implementação de comparação
    public Triangulo maiorAreaOrdv2(){
        Comparator<Triangulo> comp = (t1,t2) -> (int)(t1.calculaAreaTriangulo() - t2.calculaAreaTriangulo());

        TreeSet<Triangulo> ord = new TreeSet<>(comp);
        for (Triangulo t : this.triangulos)
            ord.add(t);

        return ord.last().clone();
    }

    //devolver um Set<Triangulo> ordenado descrescentemente por perímetro
    public Set<Triangulo> ordenaOrdemDecrescente(){
        TreeSet<Triangulo> res = new TreeSet<>(new PerímetroDecrescente());
        for (Triangulo t: this.triangulos)
            res.add(t.clone());
        return res;
    }
}
