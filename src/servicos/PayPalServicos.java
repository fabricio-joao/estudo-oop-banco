package servicos;

public class PayPalServicos implements PaamentoOnline{

    @Override
    public double taxaPagamento(double valor) {
        double tp = (valor*2)/100;
        return valor + tp ;
    }

    @Override
    public double juros(double valor, int mes) {
        double v = (valor*mes)/100;
        return valor + v;
    }
}
