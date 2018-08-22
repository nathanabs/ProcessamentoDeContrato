/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Nathan
 */
public class PaypalService implements IPagamentoOnlineService{

    @Override
    public double taxaDePagamento(double valor) {
        return valor * 0.02;
    }

    @Override
    public double juros(double valor, int mes) {
        return valor * mes * 0.01;
    }
    
}
