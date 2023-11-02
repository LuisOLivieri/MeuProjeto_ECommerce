package entitie;

public class EnderecoSalvoPrincipal {
    private String nomeRua;
    private String bairro;
    private Integer cep;

    public EnderecoSalvoPrincipal (){}

    public EnderecoSalvoPrincipal(String nomeRua, String bairro, Integer cep) {
        this.nomeRua = nomeRua;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String toString(){
        String endSalvo;
        return endSalvo =  getNomeRua() + ", Bairro: " + getBairro() + ", Cep: " + getCep();
    }
}
