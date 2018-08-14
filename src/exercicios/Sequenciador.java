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
public class Sequenciador {
    private int valor;
    
    public  Sequenciador(){
        valor = 0;
    }

    public int getValor() {
        valor = valor + 1;
        return valor;
    }
    
    
}
