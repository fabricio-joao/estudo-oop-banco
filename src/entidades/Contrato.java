package entidades;

import excecoes.DominioExcecoes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

    private String nome;
    private LocalDate data;
    private Double totalValor;
    private List<Prestaçoes>lista = new ArrayList<>();

    public Contrato(String nome, LocalDate data, Double totalValor) {
        LocalDate hoje = LocalDate.now();
        if(!data.isAfter(hoje)){
            throw new DominioExcecoes("Erro: Entre com data futura");
        }
        this.data = data;
        this.totalValor = totalValor;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getTotalValor() {
        return totalValor;
    }

    public List<Prestaçoes> getLista() {
        return lista;
    }

    public void setTotalValor(Double totalValor) {
        this.totalValor = totalValor;
    }

}
