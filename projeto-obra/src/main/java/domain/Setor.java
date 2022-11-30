package domain;

import java.time.LocalDate;

public class Setor {
    private int idSetor;
    private String nomeSetor;
    private double orcamentoSetor;
    private LocalDate prazoSetor;
    private int idObra;

    public Setor(int idSetor, String nomeSetor, double orcamentoSetor, LocalDate prazoSetor, int idObra) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
        this.orcamentoSetor = orcamentoSetor;
        this.prazoSetor = prazoSetor;
        this.idObra = idObra;
    }

    public int getIdSetor() {
        return idSetor;
    }

//    public void setIdSetor(int idSetor) {
//        this.idSetor = idSetor;
//    } NÃO SE ALTERA O ID

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {

        if(nomeSetor.length() < 30){
            this.nomeSetor = nomeSetor;
        } else {
            System.out.println("Nome precisa ter menos de 30 caracteres");
        }

    }

    public double getOrcamentoSetor() {
        return orcamentoSetor;
    }

    public void setOrcamentoSetor(double orcamentoSetor) {

        if(orcamentoSetor < 100000 ){
            this.orcamentoSetor = orcamentoSetor;
        } else {
            System.out.println("Valor do orçamento acima do permitido");
        }

    }

    public LocalDate getPrazoSetor() {
        return prazoSetor;
    }

    public void setPrazoSetor(LocalDate prazoSetor) {

        if(prazoSetor.getYear() < 2025){
            this.prazoSetor = prazoSetor;
        } else {
            System.out.println("O prazo precisa ser antes de 2025");
        }

    }

    public int getIdObra() {
        return idObra;
    }

//    public void setIdObra(int idObra) {
//        this.idObra = idObra;
//    } NÃO SE ALTERA O ID
}
