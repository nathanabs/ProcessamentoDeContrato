/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nathan
 */
public class Contrato {

    private Integer numero;
    private Date data;
    private Double valorTotal;
    private List<Parcela> parcelas = new ArrayList<>();

    public Contrato(Integer numero, Date data, Double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void adicionarParcela(Parcela p) {
        parcelas.add(p);
    }

    public void removerParcela(Parcela p) {
        parcelas.remove(p);
    }
}
