package com;

import com.exceptionsBanco.EntradaInvalidaException;
import com.exceptionsBanco.SaldoInsuficienteException;

import java.util.LinkedList;
import java.util.Queue;

import com.Operacoes.*;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO  =1;
    private static int CONTROLE  = 1;

    private int agencia;
    private int numero;
    private double saldo;
    private Queue<Operacao> extrato = new LinkedList<>();

    public Conta(){
        this.agencia =  AGENCIA_PADRAO;
        this.numero = CONTROLE++;
    }

    public Queue<Operacao> getExtrato() {
        return extrato;
    }

    public static int getCONTROLE() {
        return CONTROLE;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void receberTransferencia(double valor, Conta contaOrigem) throws EntradaInvalidaException{
        if(valor < 0 ) throw new EntradaInvalidaException("Entrada inválida");
        else {
            this.setSaldo(getSaldo() + valor);
            adicionarExtrato(Operacoes.RECEBER_TRANSFERENCIA,valor,contaOrigem);
        }
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, EntradaInvalidaException {
        if( valor < 0){
            throw new EntradaInvalidaException("Entrada inválida");
        }else if (this.getSaldo() - valor < 0){
            throw new SaldoInsuficienteException("Você não tem saldo suficiente para realizar a operação.");
        }else {
            this.setSaldo(this.getSaldo() - valor);
            adicionarExtrato(Operacoes.SAQUE,valor,null);
        }
    }

    @Override
    public void depositar(double valor) throws EntradaInvalidaException {
        if (valor > 0){
            this.setSaldo(getSaldo() + valor);
            adicionarExtrato(Operacoes.DEPOSITO,valor,null);
        }else
            throw new EntradaInvalidaException("Entrada inválida");
    }

    @Override
    public void transferir(double valor, Conta destino){
        try{
//            sacar(valor);
            if (valor > getSaldo() ){
                throw new SaldoInsuficienteException("Saldo insuficiente para realizar operação.");
            }
            saldo -= valor;
            destino.receberTransferencia(valor,this);
            adicionarExtrato(Operacoes.TRANSFERENCIA,valor,destino);
        } catch (SaldoInsuficienteException | EntradaInvalidaException e) {
            e.printStackTrace();
        }
    }

    public void adicionarExtrato(Operacoes operacao, double valor, Conta contaDestino){
        switch (operacao) {
            case TRANSFERENCIA -> extrato.add(new Operacao(-valor,saldo-valor, saldo, Operacoes.TRANSFERENCIA, contaDestino.getNumero()));
            case SAQUE -> extrato.add(new Operacao(-valor,(saldo + valor), saldo, Operacoes.SAQUE));
            case DEPOSITO -> extrato.add(new Operacao(valor,(saldo-valor), saldo, Operacoes.DEPOSITO));
            case RECEBER_TRANSFERENCIA -> extrato.add(new Operacao(valor,saldo - valor,saldo, Operacoes.RECEBER_TRANSFERENCIA,getNumero()));
        }
    }

    @Override
    public String toString() {
        return "com.Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
