public class Engenheiro {
    private int idEngenheiro;
    private String nomeEngenheiro;
    private int idadeEngenheiro;
    private String email;
    private double salario;
    private int idObra;

    public Engenheiro(int idEngenheiro, String nomeEngenheiro, int idadeEngenheiro, String email, double salario, int idObra) {
        this.idEngenheiro = idEngenheiro;
        this.nomeEngenheiro = nomeEngenheiro;
        this.idadeEngenheiro = idadeEngenheiro;
        this.email = email;
        this.salario = salario;
        this.idObra = idObra;
    }

    public int getIdEngenheiro() {
        return idEngenheiro;
    }

//    public void setIdEngenheiro(int idEngenheiro) {
//        this.idEngenheiro = idEngenheiro;
//    } NÃO SE ALTERA O ID

    public String getNomeEngenheiro() {
        return nomeEngenheiro;
    }

    public void setNomeEngenheiro(String nomeEngenheiro) {

        if(nomeEngenheiro.length() < 30){
            this.nomeEngenheiro = nomeEngenheiro;
        } else {
            System.out.println("Nome precisa ter menos de 30 caracteres");
        }

    }

    public int getIdadeEngenheiro() {
        return idadeEngenheiro;
    }

    public void setIdadeEngenheiro(int idadeEngenheiro) {
        if(idadeEngenheiro < 90 && idadeEngenheiro > 18){
            this.idadeEngenheiro = idadeEngenheiro;
        } else {
            System.out.println("Idade inválida");
        }

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        if(email.contains("@") && email.contains(".")){
            this.email = email;
        } else {
            System.out.println("Forneça um e-mail válido");
        }

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {

        if(salario < 20000){
            this.salario = salario;
        } else {
            System.out.println("Valor de salário muito alto");
        }

    }

    public int getIdObra() {
        return idObra;
    }

//    public void setIdObra(int idObra) {
//        this.idObra = idObra;
//    } NÃO SE ALTERA O ID
}
