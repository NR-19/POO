import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {

    private Map<String,Aluno> turma;
    private String nomeTurma;
    private String codTurma;

    public TurmaAlunos(){
        this.turma = new HashMap<>();
        this.nomeTurma = new String();
        this.codTurma = new String();
    }

    public TurmaAlunos(Map<String,Aluno> turma, String nomeTurma, String codTurma){
        this.turma = turma.values().stream().
                collect(Collectors.toMap(t->t.getNumero(), t->t.clone()));
        this.nomeTurma = nomeTurma;
        this.codTurma = codTurma;
    }

    public TurmaAlunos(TurmaAlunos turmaAlunos){
        this.turma = turmaAlunos.getTurma();
        this.nomeTurma = turmaAlunos.getNomeTurma();
        this.codTurma = turmaAlunos.getCodTurma();
    }

    public Map<String,Aluno> getTurma(){
        return this.turma.values().stream().
                collect(Collectors.toMap(t -> t.getNome(), t -> t.clone()));
    }

    public String getNomeTurma(){
        return this.nomeTurma;
    }

    public void setNomeTurma(String nomeTurma){
        this.nomeTurma = nomeTurma;
    }

    public String getCodTurma(){
        return this.codTurma;
    }

    public void setCodTurma(String codTurma){
        this.codTurma = codTurma;
    }

    //A
    public void insereAluno(Aluno a){
        this.turma.put(a.getNumero(), a.clone());
    }

    //B
    public Aluno getAluno(String codAluno){
        return this.turma.get(codAluno).clone();
    }

    //C
    public void removeAluno(String codAluno){
        if(this.turma.containsKey(codAluno))
            this.turma.remove(codAluno);
    }

    //D
    public Set<String> todosOsCodigos(){
        return new HashSet<>(this.turma.keySet());
    }

    //E
    public int qtsAlunos(){
        return this.turma.size();
    }

    //F
    public Collection<Aluno> alunosOrdemAlfabetica(){
        Comparator<Aluno> comp = (a1,a2) -> a1.getNome().compareTo(a2.getNome());
        return this.turma.values().stream().map(Aluno::clone).
                sorted(comp).collect(Collectors.toList());
    }



    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o == null || this.getClass() !=o.getClass()) return false;
        TurmaAlunos t = (TurmaAlunos) o;
        return this.turma.equals(t.getTurma()) &&
                this.codTurma.equals(t.getCodTurma()) &&
                this.nomeTurma.equals(t.getNomeTurma());
    }
}

