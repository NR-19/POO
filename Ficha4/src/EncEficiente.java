import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EncEficiente {

    private String nomeCliente;
    private int nif;
    private String morada;
    private int nEnc;
    private LocalDate data;
    private List<LinhaEncomenda> encomendas;

    public EncEficiente(){
        this.nomeCliente = "n/a";
        this.nif = 0;
        this.morada = "n/a";
        this.nEnc = 0;
        this.data = LocalDate.now();
        this.encomendas = new ArrayList<>();
    }

    public EncEficiente(String nomeCliente, int nif, String morada, int nEnc, LocalDate data, List<LinhaEncomenda> encomendas) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.nEnc = nEnc;
        this.data = data;
        this.setEncomendas(encomendas);
    }

    public EncEficiente(EncEficiente encEficiente){
        this.nomeCliente = encEficiente.getNomeCliente();
        this.nif = encEficiente.getNif();
        this.morada = encEficiente.getMorada();
        this.nEnc = encEficiente.getnEnc();
        this.data = encEficiente.getData();
        this.encomendas = encEficiente.getEncomendas();
    }

    public void setEncomendas(List<LinhaEncomenda> enc){
        this.encomendas = enc.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }

    public List<LinhaEncomenda> getEncomendas(){
        return this.encomendas.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
        //return new ArrayList<>(this.encomendas);  -> agregação
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getnEnc() {
        return this.nEnc;
    }

    public void setnEnc(int nEnc) {
        this.nEnc = nEnc;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    //a
    public double calculaValorTotal(){
       double res = 0;
       for(LinhaEncomenda l : this.encomendas){
           res += l.calculaValorLinhaEnc();
       }
       return res;
    }

    public double calculaValorTotal_I(){
        return this.encomendas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }
    //b
    public double calculaValorDesconto() {
        return this.encomendas.stream().mapToDouble(LinhaEncomenda::calculaValorDesconto).sum();
    }

    //c
    public int numeroTotalProdutos(){
        return this.encomendas.stream().mapToInt(LinhaEncomenda::getQuantidade).sum();
    }

    //d
    public boolean existeProdutoEncomenda(String refProduto){
        boolean existe = false;
        int i = 0;
        while(!existe && i < this.encomendas.size()){
            if(this.encomendas.get(i).getReferencia().equals(refProduto))
                existe = true;
            i++;
        }
        return existe;
    }

    public boolean existeProdutoEncomenda_I(String refProduto){
        return this.encomendas.stream().anyMatch(e -> (e.getReferencia().equals(refProduto)));
    }

    //e
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomendas.add(linha.clone());
    }

    //f
    public void removeProduto(String codProd){
        this.encomendas.removeIf(linha -> codProd.equals(linha.getReferencia()));
    }

    public void removeProduto_It(String codProd){
        for (Iterator<LinhaEncomenda> it = this.encomendas.iterator(); it.hasNext();){
            LinhaEncomenda l = it.next();
            if(codProd.equals(l.getReferencia()))
                it.remove();
        }
    }

    //g
    public List<String> getListaProdutos(){
        return this.encomendas.stream().map(LinhaEncomenda::getReferencia).distinct().collect(Collectors.toList());
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        EncEficiente encf = (EncEficiente) o;
        return this.nomeCliente.equals(encf.getNomeCliente()) &&
                this.nif == encf.getNif() &&
                this.nEnc == encf.getnEnc() &&
                this.morada.equals(encf.getMorada()) &&
                this.data.equals(encf.getData()) &&
                this.encomendas.equals(encf.getEncomendas());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Encomenda {\n");
        sb.append("\tNome de cliente = '").append(nomeCliente).append("'\n");
        sb.append("\tNIF = ").append(nif).append('\n');
        sb.append("\tMorada = '").append(morada).append("'\n");
        sb.append("\tNúmero de encomenda = ").append(nEnc).append('\n');
        sb.append("\tData = ").append(data.toString()).append('\n');
        sb.append("\tEncomendas = ").append(encomendas.toString()).append('\n');
        sb.append('}');
        return sb.toString();
    }

    public EncEficiente clone(){
        return new EncEficiente(this);
    }

}
