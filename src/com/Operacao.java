package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ConstantesCores.*;

public class Operacao {

    private LocalDateTime dataHora;
    private double valor;
    private double saldoAnterior;
    private double saldoNovo;
    private Operacoes operacao;
    private int numeroContaRelacao;

    public Operacao(double valor,double saldoAnterior, double saldoNovo, Operacoes operacao) {
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.saldoAnterior = saldoAnterior;
        this.saldoNovo = saldoNovo;
        this.operacao = operacao;
    }

    public Operacao(double valor,double saldoAnterior, double saldoNovo, Operacoes operacao,int numeroContaRelacao) {
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.saldoAnterior = saldoAnterior;
        this.saldoNovo = saldoNovo;
        this.operacao = operacao;
        this.numeroContaRelacao = numeroContaRelacao;
    }

    public Operacao() {
    }

    @Override
    public String toString() {
        if (operacao.equals(Operacoes.TRANSFERENCIA) ){
            return operacao + ": Valor: R$ " + ConstantesCores.ANSI_RED+ valor + ConstantesCores.ANSI_RESET+" , Saldo Anterior: R$ " + saldoAnterior + " , Novo Saldo: R$ "+
                    ConstantesCores.ANSI_YELLOW+saldoNovo+ ConstantesCores.ANSI_RESET + " , com.Conta Destino : " + numeroContaRelacao + " , "
                    +dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")) + ".\n";
        }else if (operacao.equals(Operacoes.RECEBER_TRANSFERENCIA)){
            return operacao + ": Valor: R$ " + ConstantesCores.ANSI_GREEN+"+"+ valor + ConstantesCores.ANSI_RESET + " , Saldo Anterior: R$ " + saldoAnterior + " , Novo Saldo: R$ "+
                    ConstantesCores.ANSI_YELLOW+saldoNovo+ ConstantesCores.ANSI_RESET + " , com.Conta Origem : " + numeroContaRelacao + " , "
                    +dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")) + ".\n";
        }else if (operacao.equals(Operacoes.SAQUE)){
            return operacao + ": Valor: R$ " + ConstantesCores.ANSI_RED+ valor + ConstantesCores.ANSI_RESET +" , Saldo Anterior: R$ " + saldoAnterior + " , Novo Saldo: R$ "+
                    ConstantesCores.ANSI_YELLOW+saldoNovo+ ConstantesCores.ANSI_RESET + " , "
                    +dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")) + ".\n";
        }else
           return operacao + ": Valor: R$ " + ConstantesCores.ANSI_GREEN+"+"+valor + ConstantesCores.ANSI_RESET +" , Saldo Anterior: R$ " + saldoAnterior + " , Novo Saldo: R$ "+
                   ConstantesCores.ANSI_YELLOW+saldoNovo+ ConstantesCores.ANSI_RESET + " , "
                    +dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")) + ".\n";

    }
}
