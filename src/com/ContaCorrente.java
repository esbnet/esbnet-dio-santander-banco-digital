package com;

import com.exceptionsBanco.EntradaInvalidaException;

public class ContaCorrente extends Conta{

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(double saldo) throws EntradaInvalidaException {
        super();
        this.depositar(saldo);
    }

    @Override
    public String toString(){
       return "Agência: " + getAgencia() + "\nNumero: " + getNumero() + ".\n" + "R$ " + getSaldo();
    }
}
