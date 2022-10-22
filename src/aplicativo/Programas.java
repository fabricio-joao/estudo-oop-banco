package aplicativo;

import entidades.Contrato;
import entidades.Prestaçoes;
import excecoes.DominioExcecoes;
import servicos.PayPalServicos;
import servicos.ServicosContratos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Programas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try{
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Entre com informaçoes: ");
            System.out.print("Nome do produto: ");
            String nome = sc.nextLine();
            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate data = LocalDate.parse(sc.next(), formatar);
            System.out.print("Valor do contrato: ");
            double valorTotal = sc.nextDouble();

            Contrato contrato = new Contrato(nome, data, valorTotal);

            System.out.print("Entre com numero de prestaçoes: ");
            int n = sc.nextInt();

            ServicosContratos servicosContratos = new ServicosContratos(new PayPalServicos());
            servicosContratos.processadoContratos(contrato, n);

            System.out.println("Parcelas ");
            System.out.println("Nome do produto: " + contrato.getNome());
            for(Prestaçoes p : contrato.getLista()){
                System.out.println(p);
            }
        }
        catch (InputMismatchException e){
            System.out.println("Error: entre com valores validos");
        }
        catch (DateTimeParseException e){
            System.out.println("Error: Entre com formato adequado (dd/MM/yyyy)");
        }
        catch (DominioExcecoes e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Error");
        }
        sc.close();
    }
}
