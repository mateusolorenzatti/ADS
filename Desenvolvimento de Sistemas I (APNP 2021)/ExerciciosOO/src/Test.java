public class Test {

    public static void testaInvoice(){
        System.out.println("\n Teste Invoice -------------------------------- \n");

        Invoice i1 = new Invoice("21", "Bucha", 2, 15.5);
        Invoice i2 = new Invoice("25", "Pistão", 4, -21.0);

        System.out.println(" Total do " + i1.getDescricao() + ": " + i1.getInvoiceAmount());
        System.out.println(" Total do " + i2.getDescricao() + ": " + i2.getInvoiceAmount());

        System.out.println("\n ------------------------------------------------ \n");
    }

    public static void testaEmployee(){
        System.out.println("\n Teste Employee -------------------------------- \n");

        Employee e1 = new Employee("Mateus", "Lorenzatti", 2400);
        Employee e2 = new Employee("Alberto", "Batista", 4025);

        System.out.println(" Salario anual do " + e1.getNome() + ": " + e1.getSalarioAnual());
        System.out.println(" Salario anual do " + e2.getNome() + ": " + e2.getSalarioAnual());

        e1.aplicarReajuste(10);
        e2.aplicarReajuste(10);

        System.out.println("\n Aplicando reajuste ...");

        System.out.println(" Salario anual do " + e1.getNome() + ": " + e1.getSalarioAnual());
        System.out.println(" Salario anual do " + e2.getNome() + ": " + e2.getSalarioAnual());

        System.out.println("\n ------------------------------------------------ \n");
    }

    public static void testaData(){
        System.out.println("\n Teste Data -------------------------------- \n");

        Data d1 = new Data(19, 12, 2000);
        Data d2 = new Data(45, 11, 2032);
        Data d3 = new Data(12, 24, 32);

        d1.displayDate();
        d2.displayDate();
        d3.displayDate();

        System.out.println("\n ------------------------------------------------ \n");
    }

    public static void main(String[] args) {
        Test.testaInvoice();
        Test.testaEmployee();
        Test.testaData();
    }
}
