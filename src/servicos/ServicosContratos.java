package servicos;

import entidades.Contrato;
import entidades.Prestaçoes;

import java.time.LocalDate;

public class ServicosContratos {
    private PaamentoOnline paamentoOnline;

    public ServicosContratos(PaamentoOnline paamentoOnline) {
        this.paamentoOnline = paamentoOnline;
    }

    public void processadoContratos(Contrato contrato, int meses){

        double v = contrato.getTotalValor()/meses;
        for(int i=1; i<= meses; i++){
            LocalDate data = contrato.getData().plusMonths(i);
            double j = paamentoOnline.juros(v,i);
            double taxa = paamentoOnline.taxaPagamento(j);
            contrato.getLista().add( new Prestaçoes(data, taxa));
        }
    }
}
