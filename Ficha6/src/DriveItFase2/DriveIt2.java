package DriveItFase2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt2 implements Serializable {

    private String nome;
    private Map<String, Veiculo> veiculos;

    public DriveIt2(){
        this.nome = "";
        this.veiculos = new HashMap<>();
    }

    public DriveIt2(String nome, Map<String, Veiculo> v){
        this.nome = nome;
        this.veiculos = v.entrySet().stream().collect(Collectors.toMap(ve->ve.getKey(), ve->ve.getValue().clone()));
    }

    public DriveIt2(DriveIt2 d){
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
    public Veiculo getVeiculo(String cod) throws VeiculoNaoExistenteException{
        if(this.veiculos.containsKey(cod))
            return this.veiculos.get(cod).clone();
        else
            throw new VeiculoNaoExistenteException(cod);
    }

    //E
    public void adiciona(Veiculo v) throws VeiculoExistenteException{
        if(this.veiculos.containsKey(v.getMatricula()))
            throw new VeiculoExistenteException(v.getMatricula());
        else
            this.veiculos.putIfAbsent(v.getMatricula(),v.clone());
    }

    //F
    public List<Veiculo> getVeiculos(){
        return this.veiculos.values().stream().map(Veiculo::clone).
                collect(Collectors.toList());
    }

    //G
    public void adiciona(Set<Veiculo> vs) throws VeiculoExistenteException {
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

    /**
     * Fase 2
     */
    public Set<Veiculo> ordenarVeiculos(){
        Set<Veiculo> res = new TreeSet<>();
        for(Veiculo v : this.veiculos.values())
            res.add(v.clone());
        return res;
    }

    public List<Veiculo> ordenarVeiculosL(){
        return this.veiculos.values().stream().map(Veiculo::clone).collect(Collectors.toList());
    }

    public Map<String,List<Veiculo>> porMarca_modelo(){
        Comparator<Veiculo> comp = (v1,v2) -> v1.getModelo().compareTo(v2.getModelo());
        return this.veiculos.values().stream().map(Veiculo::clone).
                sorted(comp).collect(Collectors.groupingBy(Veiculo::getMarca));
    }

    public Map<String,List<Veiculo>> porMarca_modelo2(){
        Comparator<Veiculo> comp = (v1,v2) -> v1.getModelo().compareTo(v2.getModelo());
        Map<String,List<Veiculo>> res = new HashMap<>();
        for(Veiculo v : this.veiculos.values()){
            String marca = v.getMarca();
            res.putIfAbsent(marca,new ArrayList<>());
            res.get(marca).add(v.clone());
        }
        for(List<Veiculo> l : res.values())
            l.sort(comp);
        return res;
    }

    /**
     * Fase 3
     */
    /*
    public List<BonificaKms> daoPontos(){
        List<BonificaKms> res = new ArrayList<>();
        for(Veiculo v : this.veiculos.values()){
            if(v instanceof BonificaKms)

        }
        return res;
    }
    */
    public List<BonificaKms> daoPontos(){
        return this.veiculos.values().stream().
                filter(v -> v instanceof BonificaKms).
                map(v -> (BonificaKms) v).
                collect(Collectors.toList());
    }

    /**
     * Fase 4
     */

    public void escreveFicheiroTexto(String nomeFicheiro) throws FileNotFoundException{
        PrintWriter fich = new PrintWriter(nomeFicheiro);
        fich.println(this.toString());
        fich.flush();
        fich.close();
    }

    //gravar em ficheiro objeto
    public void guardaEstado(String nomeFicheiro) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public DriveIt2 carregaFicheiro(String fich) throws FileNotFoundException, IOException, ClassNotFoundException{

    }


    public DriveIt2 clone(){
        return new DriveIt2(this);
    }

}

