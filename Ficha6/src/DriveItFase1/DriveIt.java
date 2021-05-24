package DriveItFase1;

import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {

    private String nome;
    private Map<String, Veiculo> veiculos;

    public DriveIt(){
        this.nome = "";
        this.veiculos = new HashMap<>();
    }

    public DriveIt(String nome, Map<String, Veiculo> v){
        this.nome = nome;
        this.veiculos = v.entrySet().stream().collect(Collectors.toMap(ve->ve.getKey(), ve->ve.getValue().clone()));
    }

    public DriveIt(DriveIt d){
        this.nome = d.getNome();
        this.veiculos = d.getViaturas();
    }

    public String getNome(){
        return this.nome;
    }

    public Map<String, Veiculo> getViaturas(){
        return this.veiculos.entrySet().stream().collect(Collectors.toMap(v->v.getKey(), v->v.getValue().clone()));
    }

    //A
    public boolean existeVeiculo(String cod){
        return this.veiculos.containsKey(cod);
    }

    //B
    public int quantos(){
        return this.veiculos.size();
    }

    //C
    public int quantos(String marca){
        return (int) this.veiculos.values().stream().
                filter(v->v.getMarca().equals(marca)).count();
    }

    //D
    public Veiculo getVeiculo(String cod){
        if(this.veiculos.containsKey(cod))
            return this.veiculos.get(cod).clone();
        else return null;
    }

    //E
    public void adiciona(Veiculo v){
        this.veiculos.putIfAbsent(v.getMatricula(), v.clone());
    }

    //F
    public List<Veiculo> getVeiculos(){
        return this.veiculos.values().stream().map(Veiculo::clone).
                collect(Collectors.toList());
    }

    //G
    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v : vs)
            adiciona(v);
    }

    //H
    public void registarAluguer(String codVeiculo, int numKms){
        if(this.veiculos.containsKey(codVeiculo))
            this.veiculos.get(codVeiculo).addViagem(numKms);
    }

    //I
    public void classificarVeiculo(String cod, int classificacao){
        if(this.veiculos.containsKey(cod))
            this.veiculos.get(cod).addClassificacao(classificacao);
    }

    //J
    public int custoRealKm(String cod){
        int custo = 0;
        if(this.veiculos.containsKey(cod))
            custo = (int) this.veiculos.get(cod).custoRealKM();
        return custo;
    }

    //calcular o veiculo com o custo real km mais baixo
    //se dois veiculos tiverem o mesmo custo ordena-se por ordem alfabetica da matricula
    public Veiculo veiculoMaisBarato(){
        Comparator<Veiculo> comp = (v1, v2) -> (v1.custoRealKM() != v2.custoRealKM() ? (int) (v1.custoRealKM() - v2.custoRealKM()) : v1.getMatricula().compareTo(v2.getMatricula()));
        Set<Veiculo> aux = new TreeSet<>(comp);
        for(Veiculo v : this.veiculos.values())
            aux.add(v.clone());
        return aux.stream().findFirst().get();
    }

    //calcular o veiculo menos utilizado, isto é, com mais kms
    public Veiculo veiculoMaisUtilizado(){
        Comparator<Veiculo> comp = (v1, v2) -> (v1.getKms() != v2.getKms() ? v2.getKms()-v1.getKms() : v2.getMatricula().compareTo(v1.getMatricula()));
        /*
        Set<DriveItFase1.Veiculo> aux = new TreeSet<>(comp);
        for(DriveItFase1.Veiculo v : this.veiculos.values())
            aux.add(v.clone());
        return aux.stream().findFirst().get();
        */
        return this.veiculos.values().stream().sorted(comp).findFirst().get().clone();
    }

    public void colocaEmpresaEmPromoção(){
        for(Veiculo v : this.veiculos.values())
            if(v instanceof VeiculoOcasião)
                ((VeiculoOcasião) v).setEmPromoção(true);
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

}
