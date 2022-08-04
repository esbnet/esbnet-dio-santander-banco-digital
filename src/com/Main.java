package com;

import com.exceptionsBanco.EntradaInvalidaException;

public class Main {
    public static void main(String[] args) throws EntradaInvalidaException {

     ContaCorrente lucas = new ContaCorrente(322);
     ContaCorrente matheus = new ContaCorrente();

        System.out.println(lucas.toString());
        System.out.printf("---------------------------------------\n");
        System.out.println(matheus.toString());
        System.out.println("\n\n");

        lucas.transferir(100,matheus);

        System.out.println(lucas.toString());
        System.out.printf("---------------------------------------\n");
        System.out.println(matheus.toString());
        System.out.println("\n\n");

        matheus.transferir(100,lucas);
        matheus.transferir(50000,lucas);

        System.out.println(lucas.toString());
        System.out.printf("---------------------------------------\n");
        System.out.println(matheus.toString());
        System.out.println("\n");

        lucas.depositar(3000);
        System.out.println("Lucas:\n" +lucas.getExtrato());
        System.out.println("-------------------------------------------");
        System.out.println("Matheus:\n"+matheus.getExtrato());
    }
}
