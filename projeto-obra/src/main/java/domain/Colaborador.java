package domain;

import java.time.LocalDate;

public class Colaborador {
    private int idColaborador;
    private String nomeColaborador;
    private double salarioColaborador;
    private LocalDate dataNasc;
    private int idSetor;

    public Colaborador(int idColaborador, String nomeColaborador, double salarioColaborador, LocalDate dataNasc, int idSetor) {
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
        this.salarioColaborador = salarioColaborador;
        this.dataNasc = dataNasc;
        this.idSetor = idSetor;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

//    public void setIdColaborador(int idColaborador) {
//        this.idColaborador = idColaborador;
//    } NÃO SE ALTERA O ID

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {

        if(nomeColaborador.length() < 30){
            this.nomeColaborador = nomeColaborador;
        } else {
            System.out.println("Nome precisa ter menos de 30 caracteres");
        }

    }

    public double getSalarioColaborador() {
        return salarioColaborador;
    }

    public void setSalarioColaborador(double salarioColaborador) {

        if(salarioColaborador < 10000 ){
            this.salarioColaborador = salarioColaborador;
        } else {
            System.out.println("Valor do orçamento acima do permitido");
        }

    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {

        if(dataNasc.getYear() < 2004 && dataNasc.getYear() > 1940){
            this.dataNasc = dataNasc;
        } else {
            System.out.println("Insira uma data válida");
        }

    }

    public int getIdSetor() {
        return idSetor;
    }

//    public void setIdSetor(int idSetor) {
//        this.idSetor = idSetor;
//    } NÃO SE ALTERA O ID
}
