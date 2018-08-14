/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author a1710648
 */
public class LambdaExpression {
    public void criar()
    {
        Runnable thread = () -> {
            System.out.println("Thread criada " + Thread.currentThread().getId());
            
        };
        Thread t = new Thread(thread);
        t.start();
        
        Thread t2 = new Thread(thread);
        t2.start();
        System.out.println("Thread Principal ID: " + Thread.currentThread().getId());
    }
        
};

