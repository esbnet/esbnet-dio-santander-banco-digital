package com;

import com.exceptionsBanco.EntradaInvalidaException;
import com.exceptionsBanco.SaldoInsuficienteException;

public interface IConta {

    void sacar(double valor) throws SaldoInsuficienteException, EntradaInvalidaException;
    void depositar(double valor) throws EntradaInvalidaException;
    void transferir(double valor,Conta destino);
    void receberTransferencia(double valor,Conta contaOrigem) throws EntradaInvalidaException;

}
