package domain;

import javax.persistence.*;
import java.time.LocalDate;

public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObra;

    @Column(nullable = false, length = 120)
    private String nomeObra;

    @Column(nullable = false)
    private double orcamentoObra;
    private LocalDate prazoObra = LocalDate.EPOCH.plusYears(3);

    @OneToOne
    @JoinColumn(name = "id_engenheiro", nullable = false)
    private Engenheiro engenheiro;

    public Obra(Integer idObra, String nomeObra, double orcamentoObra, LocalDate prazoObra) {
        this.idObra = idObra;
        this.nomeObra = nomeObra;
        this.orcamentoObra = orcamentoObra;
        this.prazoObra = prazoObra;
    }

    public int getIdObra() {
        return idObra;
    }

//    public void setIdObra(int idObra) {
//        this.idObra = idObra;
//    } NÃO SE ALTERA O ID

    public String getNomeObra() {

        return nomeObra;
    }

    public void setNomeObra(String nomeObra) {

        if(nomeObra.length() < 30 ){
            this.nomeObra = nomeObra;
        } else {
            System.out.println("Nome precisa ter menos de 30 caracteres");
        }

    }

    public double getOrcamentoObra() {
        return orcamentoObra;
    }

    public void setOrcamentoObra(double orcamentoObra) {

        if(orcamentoObra < 300000 ){
            this.orcamentoObra = orcamentoObra;
        } else {
            System.out.println("Valor do orçamento acima do permitido");
        }

    }

    public LocalDate getPrazoObra() {
        return prazoObra;
    }

    public void setPrazoObra(LocalDate prazoObra) {

        if(prazoObra.getYear() < 2025){
            this.prazoObra = prazoObra;
        } else {
            System.out.println("O prazo precisa ser antes de 2025");
        }

    }
}
