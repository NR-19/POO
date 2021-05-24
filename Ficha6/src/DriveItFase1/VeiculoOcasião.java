package DriveItFase1;

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
        return this.emPromoção ? 0.75 * super.custoRealKM() : super.custoRealKM();
    }
}
