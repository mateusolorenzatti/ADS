public class Menu {
    Leitura leTec;
    ListaPedidos lista;

    public Menu() {
        leTec = new Leitura();
        lista = new ListaPedidos();
        menu();
    }

    private void opcoes() {
        System.out.println("");
        System.out.println("1 - Inserir novo Pedido na lista. ");
        System.out.println("2 - Atender o próximo pedido. ");
        System.out.println("3 - Exibir a lista em ordem de atendimento. ");
        System.out.println("4 - Informações sobre o pedido. ");

        System.out.println("0 - Sair\n");
    }


    private Pedido leDados() {
        Pedido aux_ped = new Pedido();
        aux_ped.setNumero(leTec.leInt(" Numero do Pedido: "));
        aux_ped.setTempoAtendimento(leTec.leInt(" Tempo de atendimento: "));
        return aux_ped;
    }

    public void menu() {
        String aux_nome;
        int pos = 0;
        char opc;
        Pedido pedido;

        opcoes();
        opc = leTec.leChar("Digite a sua Op��o: ");
        while (opc != '0') {
            switch (opc) {
                case '1':
                    pedido = leDados();

                    if (lista.insereFim(pedido)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '2':
                    if (lista.atendePedido()) {
                        System.out.println("Pedido atendido! ");
                    } else {
                        System.out.println("N�o foi poss�vel atender!");
                    }
                    break;

                case '3':
                    System.out.println(lista.exibeLista());
                    break;

                case '4':
                    int numPedido = leTec.leInt(" Número do pedido: ");

                    System.out.println(lista.informacoesPedido(numPedido));
                    break;
            }
            opcoes();
            opc = leTec.leChar("Digite a sua opção: ");
        }
    }
}