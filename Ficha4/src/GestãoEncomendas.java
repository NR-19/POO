import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestãoEncomendas {
    private Map<Integer,EncEficiente> encomendas;

    public GestãoEncomendas(){
        this.encomendas = new HashMap<>();
    }

    public GestãoEncomendas(Map<Integer,EncEficiente> encs){
        this.encomendas = encs.values().stream().
                collect(Collectors.toMap(e -> e.getnEnc(), e -> e.clone()));
    }

    public GestãoEncomendas(GestãoEncomendas gt){
        this.encomendas = gt.getEncomendas();
    }

    public Map<Integer,EncEficiente> getEncomendas(){
        return this.encomendas.values().stream().collect(Collectors.toMap(e -> e.getnEnc(), e -> e.clone()));
    }

    //a
    public Set<Integer> todosCodigosEnc(){
        return new TreeSet<Integer>(this.encomendas.keySet());
    }

    //b
    public void addEncomenda(EncEficiente enc){
        this.encomendas.put(enc.getnEnc(), enc.clone());
    }

    //c
    public EncEficiente getEncomenda(Integer codEnc){
        return (this.encomendas.get(codEnc)).clone();
    }

    //d
    public void removeEncomenda(Integer codEnc){
        this.encomendas.remove(codEnc);
    }

    //e
    public Integer encomendaComMaisProdutos(){
        TreeSet<EncEficiente> aux =
                new TreeSet<>((e1,e2) -> e1.numeroTotalProdutos() - e2.numeroTotalProdutos());
        for(EncEficiente encf : this.encomendas.values())
            aux.add(encf.clone());
        return aux.last().getnEnc();
    }

    //f
    public Set<Integer> encomendasComProduto(String codProd){
        Set<Integer> res = new TreeSet<>();
        for(EncEficiente enc : this.encomendas.values()){
            if(enc.existeProdutoEncomenda(codProd))
                res.add(enc.getnEnc());

        }
        return res;
    }

    public Set<Integer> encomendasComProduto_I(String codProd){
        return this.encomendas.values().stream().
                filter(e -> e.existeProdutoEncomenda(codProd)).
                map(EncEficiente::getnEnc).collect(Collectors.toSet());
    }

    //g
    public Set<Integer> encomendasAposData(LocalDate d){
        return this.encomendas.values().stream().
                filter(e -> e.getData().isAfter(d)).
                map(EncEficiente::getnEnc).collect(Collectors.toSet());
    }

    //h
    public Set<EncEficiente> encomendasValorDecrescente(){
        Comparator<EncEficiente> comp = (e1,e2) -> (int)(e2.calculaValorTotal() - e1.calculaValorTotal());
        Set<EncEficiente> res  = new TreeSet<>(comp);
        for(EncEficiente enc : this.encomendas.values())
            res.add(enc.clone());
        return res;
    }

    //i

    public Map<String,List<Integer>> encomendasDeProduto(){
        Map<String,List<Integer>> res = new HashMap<>();
        for(EncEficiente enc : this.encomendas.values()){
            for(String s : enc.getListaProdutos())
                aux(s,enc.getnEnc(),res);
        }
        return res;
    }

    private void aux(String ref, Integer nEnc, Map<String,List<Integer>> encomendas){
        if(encomendas.containsKey(ref)){
            List<Integer> l = encomendas.get(ref);
            l.add(nEnc);
        }
        else{
            List<Integer> nova = new ArrayList<Integer>();
            nova.add(nEnc);
            encomendas.put(ref,nova);
        }
    }





}
