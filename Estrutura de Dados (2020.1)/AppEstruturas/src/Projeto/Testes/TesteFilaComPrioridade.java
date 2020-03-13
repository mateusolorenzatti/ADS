package Projeto.Testes;

import Estruturas.Fila.FilaComPrioridade;
import Projeto.Interfaces.I_TesteEstrutura;
import Projeto.Model.Onibus;

/*
 * @author mateusolorenzatti
 */
public class TesteFilaComPrioridade implements I_TesteEstrutura{

    FilaComPrioridade<Onibus> fp;

    public TesteFilaComPrioridade() {
        this.fp = new FilaComPrioridade<Onibus>();

        incluirNaEstrutura(new Onibus("Mercedes Marcopolo", 2010, 56));

        incluirNaEstrutura(new Onibus("Volvo Marcopolo", 2005, 45));
        
        incluirNaEstrutura(new Onibus("Scania Newbus", 2018, 65));
        
        removerDaEstrutura();
        
        incluirNaEstrutura(new Onibus("Agrale Volare", 1995, 22));
        
        removerDaEstrutura();
        
        removerDaEstrutura();
        
        removerDaEstrutura();
    }
    
    public void incluirNaEstrutura(Object param) {
        fp.insere((Onibus) param);
    
        this.mostrarElementos();
    }

    public void removerDaEstrutura() {
        fp.remove();
        
        this.mostrarElementos();
    }
    
    public static void main(String[] args) {
        TesteFilaComPrioridade tf = new TesteFilaComPrioridade();
    }

    @Override
    public void mostrarElementos() {
        System.out.println(fp.toString());
    }
}
