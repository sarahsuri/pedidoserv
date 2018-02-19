package com.sarah.pedidoserv.domain;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity(name = "Pedidos")
public class Pedido {
    @Id
    @Column(name = "numeroControle")
    private int numeroControle;

    private int quantidade;
    private int codigoCliente;
    private String dataCadastro;
    private String nome;
    private float valor;

    public int getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(int numeroControle) {
        this.numeroControle = numeroControle;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Pedido() {}

}
