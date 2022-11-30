package domain;

public class Colaborador_ferramenta {
    private int idColaboradorFerramenta;
    private int idColaborador;
    private int idFerramenta;

    public Colaborador_ferramenta(int idColaboradorFerramenta, int idColaborador, int idFerramenta) {
        this.idColaboradorFerramenta = idColaboradorFerramenta;
        this.idColaborador = idColaborador;
        this.idFerramenta = idFerramenta;
    }

    public int getIdColaboradorFerramenta() {
        return idColaboradorFerramenta;
    }

//    public void setIdColaboradorFerramenta(int idColaboradorFerramenta) {
//        this.idColaboradorFerramenta = idColaboradorFerramenta;
//    } NÃO SE ALTERA O ID

    public int getIdColaborador() {
        return idColaborador;
    }

//    public void setIdColaborador(int idColaborador) {
//        this.idColaborador = idColaborador;
//    } NÃO SE ALTERA O ID

    public int getIdFerramenta() {
        return idFerramenta;
    }

//    public void setIdFerramenta(int idFerramenta) {
//        this.idFerramenta = idFerramenta;
//    } NÃO SE ALTERA O ID
}
