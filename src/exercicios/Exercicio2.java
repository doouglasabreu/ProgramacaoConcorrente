/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1710648
 */
public class Exercicio2 {

    public Thread verifica1 = new Thread();
    public Thread verifica2 = new Thread();
    public Thread verifica3 = new Thread();

    public class Ex1 extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("Olá eu sou a Thread : " + Thread.currentThread().getId());
                Random tempo = new Random();
                Thread.sleep(1000 * tempo.nextInt(30));

                if (this.isInterrupted()) {
                    throw new InterruptedException();
                }

            } catch (InterruptedException ex) {
                //Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
                return;

            }
        }
    }

    public class Ex2 extends Thread {

        @Override
        public void run() {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader("./leitura"));
                while (br.ready()) {
                    String linha = br.readLine();
                    System.out.println(linha);
                    Thread.sleep(10000);

                    if (this.isInterrupted()) {
                        throw new InterruptedException();
                    }
                }
                br.close();

            } catch (FileNotFoundException ex) {
                //Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }

    public class Verifica extends Thread {

        @Override
        public void run() {
            while (true) {
                if (verifica1.isInterrupted()) {
                    System.out.println("Thread Recebeu sinal de interrupção ID = " + verifica1.currentThread().getId());
                }
                if (verifica2.isInterrupted()) {
                    System.out.println("Thread Recebeu sinal de interrupção ID = " + verifica1.currentThread().getId());
                }

                if (verifica3.isInterrupted()) {
                    System.out.println("Thread Recebeu sinal de interrupção ID = " + verifica1.currentThread().getId());
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }
    public class Ex5 extends Thread{
        
        @Override
        public void run(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("entre com numero");
        int n = reader.nextInt();
        }
    
    }

    public void executar() {
        new Ex1().start();
        new Ex1().start();
        new Ex1().start();

    }

    public void executar2() {
        new Ex2().start();
    }

    public void executar3() {
        Ex1 t1 = new Ex1();
        t1.start();
        t1.interrupt();

        Ex2 t2 = new Ex2();
        t2.start();
        t2.interrupt();

    }
    public void executa4(){
        Verifica ex4 = new Verifica();
        ex4.start();
    }
    public void executa5() throws InterruptedException{
        Ex5 ex5 = new Ex5();
        
        ex5.start();
        ex5.join();
        
    }

}
