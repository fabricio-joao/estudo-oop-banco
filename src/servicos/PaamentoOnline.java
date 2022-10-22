package servicos;

public interface PaamentoOnline {
    double taxaPagamento(double valor);
    double juros(double valor, int mes);
}
