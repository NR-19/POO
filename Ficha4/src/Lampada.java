import java.time.Duration;
import java.time.LocalDateTime;

public class Lampada {
    private State state;
    private double powerNormal;
    private double powerEco;
    private LocalDateTime criação;


    public Lampada(){
        this.state = State.OFF;
        this.powerNormal = 15;
        this.powerEco = 10;
        this.criação = LocalDateTime.now();
    }

    public Lampada(double powerNormal, double powerEco){
        this.state = State.OFF;
        this.powerNormal = powerNormal;
        this.powerEco = powerEco;
        this.criação = LocalDateTime.now();
    }

    public Lampada(State state, double powerNormal, double powerEco, LocalDateTime criação){
        this.state = state;
        this.powerNormal = powerNormal;
        this.powerEco = powerEco;
        this.criação = criação;
    }

    public Lampada(Lampada l){
        this.state = l.getState();
        this.powerNormal = l.getPowerNormal();
        this.powerEco = l.getPowerEco();
    }

    public State getState(){
        return this.state;
    }

    public double getPowerNormal(){
        return this.powerNormal;
    }

    public double getPowerEco(){
        return this.powerEco;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPowerNormal(double powerNormal){
        this.powerNormal = powerNormal;
    }

    public void setPowerEco(double powerEco) {
        this.powerEco = powerEco;
    }

    public LocalDateTime getCriação(){
        return this.criação;
    }

    public void lampON(){
        this.state = State.ON;
    }

    public void lampECO(){
        this.state = State.OFF;
    }

}
