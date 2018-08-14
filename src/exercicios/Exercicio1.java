/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a1710648
 */
public class Exercicio1 {
    
    public Sequenciador i =new Sequenciador();
    
    public class Hello2 implements Runnable{
        @Override
        public void run(){
            while(true){
            System.out.println("Olá eu sou uma Runnable ID = "+ Thread.currentThread().getId()+" I = "+ i.getValor());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
    
    public class Hello extends Thread{
        @Override
        public void run(){
            while (true) {
                System.out.println("Olá eu sou uma Thread ID = "+ Thread.currentThread().getId()+" I = "+ i.getValor());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        }
    };
    public void ex(){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("entre com numero de threads ");
        int n = reader.nextInt();
        for (int i = 0; i < n; i++) {
            new Hello().start();
            new Thread(new Hello2()).start();  
        }
        
    }
    
}
