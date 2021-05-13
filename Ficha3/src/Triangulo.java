//composição
public class Triangulo {

    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    public Triangulo(){
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }

    public Triangulo(Ponto p1, Ponto p2, Ponto p3){
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
    }

    public Triangulo(Triangulo t){
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public double calculaAreaTriangulo(){
        double s,a,b,c;
        a = this.p1.distancia(this.p2);
        b = this.p1.distancia(this.p3);
        c = this.p2.distancia(this.p3);
        s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public double calculaPerimetroTriangulo(){
        double a,b,c;
        a = this.p1.distancia(this.p2);
        b = this.p1.distancia(this.p3);
        c = this.p2.distancia(this.p3);
        return a+b+c;
    }

    public Ponto getP1(){
        return this.p1.clone();
    }

    public Ponto getP2(){
        return this.p2.clone();
    }

    public Ponto getP3(){
        return this.p3.clone();
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Triangulo t = (Triangulo) o;
        return (this.p1.equals(t.getP1()) && this.p2.equals(t.getP2()) && this.p3.equals(t.getP3()));
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }


}
