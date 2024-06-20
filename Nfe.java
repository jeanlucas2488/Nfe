import java.util.Date;

public class NFe {
    private String cnpj;
    private String razaoSocial;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private String ie;
    private String im;
    private String cnae;
    private Date dataEmissao;
    private String chaveAcesso;
    private String descricao;
    private double valorTotal;
    private String ncm;
    private String cfop;
    private String unidade;
    private double quantidade;
    private double valorUnitario;

    public NFe(String cnpj, String razaoSocial, String endereco, String cidade, String estado, String cep, String ie,
               String im, String cnae, Date dataEmissao, String chaveAcesso, String descricao, double valorTotal,
               String ncm, String cfop, String unidade, double quantidade, double valorUnitario) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.ie = ie;
        this.im = im;
        this.cnae = cnae;
        this.dataEmissao = dataEmissao;
        this.chaveAcesso = chaveAcesso;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.ncm = ncm;
        this.cfop = cfop;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    // Getters and Setters for each field

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "NFe{" +
			"cnpj='" + cnpj + '\'' +
			", razaoSocial='" + razaoSocial + '\'' +
			", endereco='" + endereco + '\'' +
			", cidade='" + cidade + '\'' +
			", estado='" + estado + '\'' +
			", cep='" + cep + '\'' +
			", ie='" + ie + '\'' +
			", im='" + im + '\'' +
			", cnae='" + cnae + '\'' +
			", dataEmissao=" + dataEmissao +
			", chaveAcesso='" + chaveAcesso + '\'' +
			", descricao='" + descricao + '\'' +
			", valorTotal=" + valorTotal +
			", ncm='" + ncm + '\'' +
			", cfop='" + cfop + '\'' +
			", unidade='" + unidade + '\'' +
			", quantidade=" + quantidade +
			", valorUnitario=" + valorUnitario +
			'}';
    }
}

