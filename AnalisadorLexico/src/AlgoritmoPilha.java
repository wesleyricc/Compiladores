/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wesley Ricardo
 */
public class AlgoritmoPilha {

    private TestePilha pilha = new TestePilha(0);
    private Parsing parsing = new Parsing();

    String x = pilha.peek();
    String a = "o que recebe?"; //verificar

    
    do{
    
    if (x == "$") {
            pilha.pop();
            x = pilha.peek();
        } else if (x == "terminal") { //verificar
            if (x == a) {
                pilha.pop();
                //return; verificar
            } else {
                System.out.println("ERRO!");
                System.exit(0);
            }
        } else if (parsing.getParsing() == null) { //verificar

            pilha.pop();
            pilha.push(null); //o que adiciona?
            x = pilha.peek();
        } else {
            System.out.println("ERRO!");
            System.exit(0);
        }
    }while(x != "$");
}
