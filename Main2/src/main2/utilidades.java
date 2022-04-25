/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main2;

import java.util.Scanner;

/**
 *
 * @author eptek
 */
public class utilidades {

    private Scanner lector = new Scanner(System.in);
    private double numero1;
    private double numero2;
    private double res;
    private String operacion;

    public void seleccionarOpcion() {
        boolean comprobar = false;
        do {
            System.out.println("\n Operació? (Indica el signe)");
            System.out.println("Introdueix la operaccio desitjada"
                    + "'+' = sumar \n "
                    + "'-' = restar \n"
                    + "'x' = multiplicar \n "
                    + "'/' = dividir \n "
                    + "'*' = elevar primer num al segon num.\n"
                    + "'%' = residu");
            operacion = lector.nextLine();
            comprobar = operacion.equals("+") || operacion.equals("-")
                    || operacion.equals("x")
                    || operacion.equals("X")
                    || operacion.equals("/")
                    || operacion.equals("%")
                    || operacion.equals("*");
            if (comprobar == false) {
                System.out.println("Opció incorrecta");
            }

        } while (comprobar != true);

    }

    public void setNumero1(String texto) {
        String numero1;
        do {
            System.out.println(texto);
            numero1 = lector.nextLine();
        } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));

        this.numero1 = new Double(numero1);
    }

    public void setNumero2(String texto) {
        String numero2;
        do {
            System.out.println(texto);
            numero2 = lector.nextLine();
        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));

        this.numero2 = new Double(numero2);
    }

    @SuppressWarnings("empty-statement")
    public void realizarOperacion() {
        boolean comprobacion = true;
        do {
            comprobacion = true;
            switch (operacion) {
                case "+":
                    res = numero1 + numero2;
                    break;
                case "-":
                    res = numero1 - numero2;
                    break;
                case "x":
                case "X":
                    res = numero1 * numero2;
                    break;
                case "/":
                    while (numero2 == 0) {

                        setNumero2(" Al denominador hi ha un zero \n"
                                + "per a  evitar errors coloca un altre valor.");

                    }
                    res = numero1 / numero2;
                    break;
                case "*":
                    res = Math.pow(numero1, numero2);
                    break;
                case "%":
                    while (numero2 == 0) {
                        
                            setNumero2("per a  evitar errors coloca un altre valor."
                                    + " Al denominador hi ha un zero \n");
                         }
  
                        res = numero1 % numero2;

                        break;
            }
        }while (comprobacion != true);
    }
    

    @Override
    public String toString() {
        return "operació" + numero1 + "" + operacion + "" + numero2 + "" + " = " + res;
    }
    
    
    public String continuarOperant(String seleccion){
        boolean comprobacio = true;
        System.out.println(seleccion);
        do {
            
            seleccion = lector.nextLine();
            if(!(seleccion.equalsIgnoreCase("S")||seleccion.equalsIgnoreCase("N"))){
               System.err.println("Error valor no valid, introdueix de nou el valor\n");
               comprobacio=false;
            }
        }while (comprobacio != true);
        return seleccion;
    
}

}
