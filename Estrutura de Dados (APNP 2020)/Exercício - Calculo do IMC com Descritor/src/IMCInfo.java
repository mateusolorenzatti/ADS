public class IMCInfo {

    private String descricao;
    private Double min;
    private Double max;

    public IMCInfo() {
    }

    public IMCInfo(String descricao, Double min, Double max) {
        this.descricao = descricao;
        this.min = min;
        this.max = max;
    }

    public boolean alunoEstaNaSituacao(Aluno aluno){
        Double imcAluno = (aluno.getPeso() / (Math.pow(aluno.getAltura(), 2))) * 10000;

        // System.out.println(" DEBUG: Aluno(a)" + aluno.getNome() + " tem IMC: " + imcAluno);

        return imcAluno >= this.min && imcAluno <= this.max;
    }

    public static String calculaImc(int peso, int altura) {
        String situacao = "";
        Double indice = (peso / (Math.pow(altura, 2))) * 10000;

        IMCInfo[] IMCs = {
                new IMCInfo("abaixo", 0.0, 18.4),
                new IMCInfo("normal", 18.5, 24.9),
                new IMCInfo("sobrepeso", 25.0, 29.9),
                new IMCInfo("obesidade_I", 30.0, 34.9),
                new IMCInfo("obesidade_II", 35.0, 39.9),
                new IMCInfo("obesidade_III", 40.0, 1000.0),
        };

        for (IMCInfo info : IMCs) {
            if ( (info.getMin() <= indice) && (indice <= info.getMax())){
                situacao = info.getDescricao();
            }
        }

        return situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static IMCInfo getIMC(String situacao){
        IMCInfo[] IMCs = {
                new IMCInfo("abaixo", 0.0, 18.4),
                new IMCInfo("normal", 18.5, 24.9),
                new IMCInfo("sobrepeso", 25.0, 29.9),
                new IMCInfo("obesidade_I", 30.0, 34.9),
                new IMCInfo("obesidade_II", 35.0, 39.9),
                new IMCInfo("obesidade_III", 40.0, 1000.0),
        };

        for (IMCInfo info : IMCs) {
            if (info.getDescricao().equals(situacao)){
                return info;
            }
        }

        return null;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
