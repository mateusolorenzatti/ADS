import java.util.HashMap;
import java.util.Map;

public class Descritor {
    Nodo inicio;
    int tamanho;
    Nodo fim;

    Map<String, Integer> imcInfo = new HashMap<String, Integer>();

    Descritor() {
        inicio = null;
        tamanho = 0;
        fim = null;

        initIMC();
    }

    private void initIMC() {
        this.imcInfo.put("abaixo", 0);
        this.imcInfo.put("normal", 0);
        this.imcInfo.put("sobrepeso", 0);
        this.imcInfo.put("obesidade_I", 0);
        this.imcInfo.put("obesidade_II", 0);
        this.imcInfo.put("obesidade_III", 0);
    }

    void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    void setFim(Nodo fim) {
        this.fim = fim;
    }

    void incrementaTamanho() {
        tamanho++;
    }

    void decrementaTamanho() {
        tamanho--;
    }

    Nodo getInicio() {
        return inicio;
    }

    Nodo getFim() {
        return fim;
    }

    int getTamanho() {
        return tamanho;
    }

    public boolean incrementaIMC(String chave) {
        for (Map.Entry imc : imcInfo.entrySet()) {
            if (imc.getKey().equals(chave)) {
                imc.setValue((int) imc.getValue() + 1);
                return true;
            }
        }
        return false;
    }

    public boolean decrementaIMC(String chave) {
        for (Map.Entry imc : imcInfo.entrySet()) {
            if (imc.getKey().equals(chave)) {
                if((int) imc.getValue() == 0) return false;
                imc.setValue((int) imc.getValue() - 1);
                return true;
            }
        }
        return false;
    }

    public String getInfoIMC(){
        String info = "Situação dos Alunos: \n";

        for (Map.Entry imc : imcInfo.entrySet()) {

            info += " " + imc.getKey() + " --> " + imc.getValue() + "\n";
        }

        return info;
    }
}
