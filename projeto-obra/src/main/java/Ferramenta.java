public class Ferramenta {
    private int idFerramenta;
    private String nomeFerramenta;
    private double preco;
    private int quantidade;
    private String descricao;

    public Ferramenta(int idFerramenta, String nomeFerramenta, double preco, int quantidade, String descricao) {
        this.idFerramenta = idFerramenta;
        this.nomeFerramenta = nomeFerramenta;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

//    public void setIdFerramenta(int idFerramenta) {
//        this.idFerramenta = idFerramenta;
//    } NÃO SE ALTERA O ID

    public String getNomeFerramenta() {
        return nomeFerramenta;
    }

    public void setNomeFerramenta(String nomeFerramenta) {

        if(nomeFerramenta.length() < 30){
            this.nomeFerramenta = nomeFerramenta;
        } else {
            System.out.println("Nome precisa ter menos de 30 caracteres");
        }

    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {

        if(preco < 10000 ){
            this.preco = preco;
        } else {
            System.out.println("Valor da ferramenta acima do permitido, contate seu superior para aprovação");
        }

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        if(quantidade < 10000 ){
            this.quantidade = quantidade;
        } else {
            System.out.println("Valor da quantidade acima do normal, contate seu superior para aprovação");
        }

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
