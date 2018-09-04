/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.Scanner;

/**
 *
 * @author a1710648
 */
public class Exercicio4 {

    public static void main(String[] args) {

        Numero gerador = new Numero(1000000);
        for (int i = 0; i < 50; i++) {
            new executar(gerador).start();

        }
    }

}

class Numero {

    int count;
    int valorDigitado;
    AtomicInteger countAtomicInteger = new AtomicInteger(0);

    Numero(int numero) {
        this.count = 0;
        this.valorDigitado = numero;
    }

    public synchronized boolean printNumeroMetodo() {
        if (count > valorDigitado) {
            return false;
        }
        int divisores = 0;
        int numeroProcessar;
            numeroProcessar = count;
            count++;
        

        for (int i = 1; i <= numeroProcessar; i++) {
            if (numeroProcessar % i == 0) {
                divisores++;
                if (divisores > 2) {
                    return true;
                }

            }

        }
        if (divisores == 2) {
            //System.out.println("é primo : " + numeroProcessar);
        }

        return true;

    }

    public boolean printNumeroAtomico() {
        if (countAtomicInteger.get() > valorDigitado) {
            return false;
        }
        int divisores = 0;
        int numeroProcessar = countAtomicInteger.incrementAndGet();

        for (int i = 1; i < numeroProcessar; i++) {
            if (numeroProcessar % i == 0) {
                divisores++;
            }

        }
        if (divisores == 2) {
            //System.out.println("é primo : " + numeroProcessar);
        }
        return true;

    }
    
    public boolean printNumeroBloco() {
        if (count > valorDigitado) {
            return false;
        }
        int divisores = 0;
        int numeroProcessar;
        synchronized(this){
        numeroProcessar = count;
            count++;
        }

        for (int i = 1; i <= numeroProcessar; i++) {
            if (numeroProcessar % i == 0) {
                divisores++;
                if (divisores > 2) {
                    return true;
                }

            }

        }
        if (divisores == 2) {
            //System.out.println("é primo : " + numeroProcessar);
        }

        return true;

    }
    
    public boolean printNumero() {
        if (count > valorDigitado) {
            return false;
        }
        int divisores = 0;
        int numeroProcessar;
        numeroProcessar = count;
            count++;
        

        for (int i = 1; i <= numeroProcessar; i++) {
            if (numeroProcessar % i == 0) {
                divisores++;
                if (divisores > 2) {
                    return true;
                }

            }

        }
        if (divisores == 2) {
            //System.out.println("é primo : " + numeroProcessar);
        }

        return true;

    }

}

class executar extends Thread {

    Numero numero;

    public executar(Numero numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        
        //while (numero.printNumero());
        //while (numero.printNumeroAtomico());
        while (numero.printNumeroMetodo());
        //while (numero.printNumeroBloco());

    }

}
