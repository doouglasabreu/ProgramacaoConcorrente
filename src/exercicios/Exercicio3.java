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
 * @author a1710648
 */
public class Exercicio3 {
   
    public static void main(String[] args) {
        
        Threads t1 = new Threads();
        t1.start();
        
        Threads t2 = new Threads();
        t2.start();
        
        Executa1 monitor = new Executa1(t1,t2);
        monitor.start();

    }
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
