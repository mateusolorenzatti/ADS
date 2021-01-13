package Ex2;

public class Invoice {
    private String numero;
    private String descricao;
    private int quantidade;
    private Double valor_uni;

    public Invoice(String numero, String descricao, int quantidade, Double valor_uni) {
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade < 0 ? 0 : quantidade;
        this.valor_uni = valor_uni < 0.0 ? 0.0 : valor_uni;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }

    public Double getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(Double valor_uni) {
        this.valor_uni = valor_uni < 0.0 ? 0.0 : valor_uni;
    }

    public double getInvoiceAmount(){
        return this.quantidade * this.valor_uni;
    }
}
