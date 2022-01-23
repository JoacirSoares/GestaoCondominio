/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import entities.enums.StatusPagamento;
import entities.enums.TipoDespesa;
import java.util.Date;

/**
 *
 * @author Joacir
 */
public class DespesaUnidade {
    private int iddespesaUnidade;
    private TipoDespesa tipoDespesa;
    private double valor;
    private String descricao;
    private String vencimentoFatura;
    private StatusPagamento statusPagamento;
    

    /**
     * @return the iddespesaUnidade
     */
    public Integer getIddespesaUnidade() {
        return iddespesaUnidade;
    }

    /**
     * @param iddespesaUnidade the iddespesaUnidade to set
     */
    public void setIddespesaUnidade(Integer iddespesaUnidade) {
        this.iddespesaUnidade = iddespesaUnidade;
    }

    /**
     * @return the tipoDespesa
     */
    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    /**
     * @param tipoDespesa the tipoDespesa to set
     */
    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the vencimentoFatura
     */
    public String getVencimentoFatura() {
        return vencimentoFatura;
    }

    /**
     * @param vencimentoFatura the vencimentoFatura to set
     */
    public void setVencimentoFatura(String vencimentoFatura) {
        this.vencimentoFatura = vencimentoFatura;
    }

    /**
     * @return the statusPagamento
     */
    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    /**
     * @param statusPagamento the statusPagamento to set
     */
    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

}
