import java.time.LocalDate;

public class Sinalizacao {
    private int anoDataExtracao;
    private int mesDataExtracao;
    private int diaDataExtracao;
    private int horaDataExtracao;
    private int minDataExtracao;
    private int diaImplantacao;
    private int mesImplantacao;
    private int anoImplantacao;
    private double numInicial;
    private double numFinal;
    private String descricao;
    private String lado;
    private String localImplantacao;
    private LocalDate date;
    public Sinalizacao(int anoDataExtracao, int mesDataExtracao, int diaDataExtracao, int horaDataExtracao,
            int minDataExtracao, int diaImplantacao, int mesImplantacao, int anoImplantacao, double numInicial,
            double numFinal, String descricao, String lado, String localImplantacao, LocalDate date) {
        this.anoDataExtracao = anoDataExtracao;
        this.mesDataExtracao = mesDataExtracao;
        this.diaDataExtracao = diaDataExtracao;
        this.horaDataExtracao = horaDataExtracao;
        this.minDataExtracao = minDataExtracao;
        this.diaImplantacao = diaImplantacao;
        this.mesImplantacao = mesImplantacao;
        this.anoImplantacao = anoImplantacao;
        this.numInicial = numInicial;
        this.numFinal = numFinal;
        this.descricao = descricao;
        this.lado = lado;
        this.localImplantacao = localImplantacao;
        this.date = date;
    }
    
    public int getAnoDataExtracao() {
        return anoDataExtracao;
    }
    public int getMesDataExtracao() {
        return mesDataExtracao;
    }
    public int getDiaDataExtracao() {
        return diaDataExtracao;
    }
    public int getHoraDataExtracao() {
        return horaDataExtracao;
    }
    public int getMinDataExtracao() {
        return minDataExtracao;
    }
    public int getDiaImplantacao() {
        return diaImplantacao;
    }
    public int getMesImplantacao() {
        return mesImplantacao;
    }
    public int getAnoImplantacao() {
        return anoImplantacao;
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
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sinalizacao [Data da extração:" + diaDataExtracao + "/" + mesDataExtracao + "/" + anoDataExtracao + ", horaDataExtracao=" + horaDataExtracao
                + ", minDataExtracao=" + minDataExtracao + ", diaImplantacao=" + diaImplantacao + ", mesImplantacao="
                + mesImplantacao + ", anoImplantacao=" + anoImplantacao + ", numInicial=" + numInicial + ", numFinal="
                + numFinal + ", descricao=" + descricao + ", lado=" + lado + ", localImplantacao=" + localImplantacao
                + ", date=" + date + "]";
    }


}
