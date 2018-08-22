/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Contrato;
import entities.Parcela;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import service.ContratoService;
import service.PaypalService;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite os dados do contrato: ");
        System.out.print("Numero: ");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.print("Data (dd/MM/yyyy): ");
        Date data = sdf.parse(sc.nextLine());
        System.out.print("Valor do contrato: ");
        double valor = sc.nextDouble();
        
        Contrato contrato = new Contrato(numero, data, valor);
        
        System.out.print("Digite o numero de parcelas: ");
        int quantidade = sc.nextInt();
        
        ContratoService cs = new ContratoService(new PaypalService());
        
        cs.processoDeContrato(contrato, quantidade);
        
        System.out.println("Parcelas: ");
        
        for(Parcela p : contrato.getParcelas()){
            System.out.println(p.getDataVencimento()+" - "+ p.getValor());
        }
    }

}
