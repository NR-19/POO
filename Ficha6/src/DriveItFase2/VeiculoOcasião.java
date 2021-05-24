package DriveItFase2;

import java.util.ArrayList;

public class VeiculoOcasião extends Veiculo {

    private boolean emPromoção;

    public VeiculoOcasião(){
        super();
        this.emPromoção = false;
    }

    public VeiculoOcasião(String marca, String modelo, String matricula,
                          int ano, double velociademedia, double precokm,
                          ArrayList<Integer> classificacao,
                          int kms, int kmsUltimo, boolean emPromoção){
        super(marca,modelo,matricula,ano,velociademedia,precokm,classificacao,kms,kmsUltimo);
        this.emPromoção = emPromoção;
    }

    public VeiculoOcasião(VeiculoOcasião vo){
        super(vo);
        this.emPromoção = vo.getEmPromoção();
    }

    public boolean getEmPromoção(){
        return this.emPromoção;
    }

    public void setEmPromoção(boolean emPromoção){
        this.emPromoção = emPromoção;
    }

    public double custoRealKM(){

        double valor = getPrecokm()*(2-1/Math.exp(getKms()));
        return this.emPromoção ? 0.75 * valor : valor;
    }

    public VeiculoOcasião clone(){
        return new VeiculoOcasião(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasião v = (VeiculoOcasião) o;
        return super.equals(v) && this.emPromoção == v.getEmPromoção();
    }

    public String toString() {
        return super.toString() + " Em Promoção: "+ this.emPromoção;
    }
}
