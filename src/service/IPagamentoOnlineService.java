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
public interface IPagamentoOnlineService {
    public double taxaDePagamento(double valor);
    public double juros(double valor, int mes);
}
