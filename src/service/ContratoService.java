/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Contrato;
import entities.Parcela;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nathan
 */
public class ContratoService {

    private IPagamentoOnlineService pagamentoOnline;

    public ContratoService(IPagamentoOnlineService pagamentoOnline) {
        this.pagamentoOnline = pagamentoOnline;
    }
    

    public void processoDeContrato(Contrato contrato, int meses) {
        double valorParcelaBasica = contrato.getValorTotal() / meses;
        
        for (int i = 1; i <= meses; i++) {
            
            double ParcelaComTaxa = valorParcelaBasica + pagamentoOnline.taxaDePagamento(valorParcelaBasica);
            double ParcelaComJuros = ParcelaComTaxa + pagamentoOnline.juros(ParcelaComTaxa, i);
            
            Date data = adcionarMeses(contrato.getData(), i);

            contrato.adicionarParcela(new Parcela(data, ParcelaComJuros));
        }
    }

    private Date adcionarMeses(Date data, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, mes);
        return cal.getTime();
    }
}
