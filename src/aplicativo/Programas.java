package aplicativo;

import entidades.Contrato;
import entidades.Prestaçoes;
import servicos.PayPalServicos;
import servicos.ServicosContratos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com informaçoes: ");
        System.out.print("Números: ");
        Integer num = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), formatar);
        System.out.print("Valor do contrato: ");
        double valorToatal = sc.nextDouble();

        Contrato contrato = new Contrato(num,data,valorToatal);

        System.out.print("Entre com numero de prestaçoes: ");
        int n = sc.nextInt();

        ServicosContratos servicosContratos = new ServicosContratos(new PayPalServicos());
        servicosContratos.processadoContratos(contrato, n);

        System.out.println("Parcelas ");
        for(Prestaçoes p : contrato.getLista()){
            System.out.println(p);
        }
        sc.close();
    }
}
