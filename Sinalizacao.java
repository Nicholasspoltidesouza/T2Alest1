import java.time.LocalDate;

public class Sinalizacao {
    private double numInicial;
    private double numFinal;
    private String descricao;
    private String lado;
    private String localImplantacao;
    private LocalDate dataImplantacao;
    
    public Sinalizacao(double numInicial, double numFinal, String descricao, String lado, String localImplantacao,
            LocalDate dataImplantacao) {
        this.numInicial = numInicial;
        this.numFinal = numFinal;
        this.descricao = descricao;
        this.lado = lado;
        this.localImplantacao = localImplantacao;
        this.dataImplantacao = dataImplantacao;
    }

    public double getNumInicial() {
        return numInicial;
    }

    public double getNumFinal() {
        return numFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLado() {
        return lado;
    }

    public String getLocalImplantacao() {
        return localImplantacao;
    }

    public LocalDate getDataImplantacao() {
        return dataImplantacao;
    }

    @Override
    public String toString() {
        return "Sinalizacao [numInicial=" + numInicial + ", numFinal=" + numFinal + ", descricao=" + descricao
                + ", lado=" + lado + ", localImplantacao=" + localImplantacao + ", dataImplantacao=" + dataImplantacao
                + "]";
    }

}
