/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oficina.model;

import br.com.oficina.model.Clientes;

/**
 *
 * @author Walan
 */
public class OS {

    private int id;
    private String data;
    private String status;
    private Modelo modelo;
    private String tecnico;
    private String descricao_cliente;
    private String servico_executado;
    private Double valor;
    private Clientes cliente;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getDescricao_cliente() {
        return descricao_cliente;
    }

    public void setDescricao_cliente(String descricao_cliente) {
        this.descricao_cliente = descricao_cliente;
    }

    public String getServico_executado() {
        return servico_executado;
    }

    public void setServico_executado(String servico_executado) {
        this.servico_executado = servico_executado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
