/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.Scanner;

/**
 *
 * @author a1710648
 */
public class Exercicio1 {
    

    public class Hello2 implements Runnable{
        @Override
        public void run(){
            System.out.println("Olá eu sou uma Runnable ID = "+ Thread.currentThread().getId());
        }
    };
    
    public class Hello extends Thread{
        @Override
        public void run(){
            System.out.println("Olá eu sou uma Thread ID = "+ Thread.currentThread().getId());
           
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
