public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    public void setDia(int dia) {
        if(dia > 0 && dia <= 31) {
            this.dia = dia;
        }else{
            this.dia = 1;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int mes) {
        if(mes > 0 && mes <= 12) {
            this.mes = mes;
        }else{
            this.mes = 1;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setAno(int ano) {
        if(ano >= 0) {
            this.ano = ano;
        }else{
            this.ano = 0;
        }
    }

    public int getAno() {
        return ano;
    }

    public void displayDate() {
        System.out.println(" " + getDia() + "/" + getMes() + "/" + getAno());
    }
}
