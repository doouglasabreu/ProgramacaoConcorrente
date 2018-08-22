/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1710648 Douglas Vinicius de Abreu Essa classe resolve os exercicios
 * do slide 28 sobre aula de threads na main está comentado todos as execuções
 * dos exercicios em ordem
 */
public class Exercicio3 {

    int num_threads = 0;

    public static void main(String[] args) throws InterruptedException {

//        Threads t1 = new Threads();
//        t1.start();
//        
//        Threads t2 = new Threads();
//        t2.start();
//        
//        Executa1 monitor = new Executa1(t1,t2);
//        monitor.start();
//
//        ThreadGroupDemo runnable = new ThreadGroupDemo();
//        ThreadGroup t = new ThreadGroup("Grupo");
//
//        Thread t1 = new Thread(t, runnable, "um");
//        t1.start();
//        Thread t2 = new Thread(t, runnable, "dois");
//        t2.start();
//        Thread t3 = new Thread(t, runnable, "tres");
//        t3.start();
//
//        System.out.println("nome grupo: " + t.getName());
//        t.list();
//    Primos primo = new Primos();
//    primo.start();
//    int [] vetor = {2,54,574,4,22,35};
//    Busca buscar = new Busca(54, vetor, 0, vetor.length/2);
//    Busca buscar2 = new Busca(54, vetor, 0, vetor.length/2 +1);
//    buscar.start();
//    buscar2.start();
        int v[] = {6, 8, 2, 234, 23, 90, 97, 5};

        Mergesort merge = new Mergesort(v, 0, v.length/2);
        Mergesort merge2 = new Mergesort(v, v.length/2+1, v.length-1);
        Mergesort fim = new Mergesort(v, 0, v.length-1);
        merge.start();
        merge2.start();
        fim.start();
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }

    }
}

class Busca extends Thread {

    int valor;
    int[] vetor;
    int posicaoinicial;
    int posicaofinal;

    public Busca(int valor, int[] vetor, int posicaoinicial, int posicaofinal) {
        this.valor = valor;
        this.vetor = vetor;
        this.posicaoinicial = posicaoinicial;
        this.posicaofinal = posicaofinal;
    }

    public void run() {
        for (int i = posicaoinicial; i < posicaofinal; i++) {
            if (vetor[i] == valor) {
                System.out.println("Encontrado " + valor + "Na thread com id " + this.getId());
            }
        }
    }

}

class Mergesort extends Thread {

    int[] array;
    int low;
    int high;

    public Mergesort(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        mergeSort(array, low, high);
    }

    void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    void merge(int[] array, int low, int middle, int high) {
        int[] helper = new int[array.length];
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;

            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

}

class Primos extends Thread {

    public void run() {
        for (int i = 1; i < 100000; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count <= 2) {
                System.out.println(i);
            }
        }
    }
}

class ThreadGroupDemo implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    class Threads extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Sou a Thread de ID : " + this.getId());
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println(e);
                    return;
                }

            }
        }
    }

    class Executa1 extends Thread {

        Threads t1;
        Threads t2;

        public Executa1(Threads t1, Threads t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Thread Id " + t1.getId() + " Estado : " + t1.getState());
                System.out.println("Thread Id " + t2.getId() + " Estado : " + t2.getState());
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
}
