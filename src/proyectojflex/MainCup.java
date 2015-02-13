/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojflex;

import java.io.BufferedWriter;
import java_cup.runtime.Symbol;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.parser;
import java.util.Scanner;

class MainCup {

    static public void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        //Scanner leer = new java.util.Scanner(System.in);
        int menu;
        String entrada;
        do {
            System.out.println("********eliga en el menu");
            System.out.println("1: para generar");
            System.out.println("2: para ejecuta");
            System.out.println("3: salir");
            //  java.util.Scanner scan1 = new java.util.Scanner(System.in);
            menu = scan.nextInt();
            switch (menu) {
                case 1: {
                    /*PAra generar el archivo cup*/
                    System.out.println("archivo sintactico");
                    String opciones[] = new String[5];
                    
                    //parametros enviador para crear el archivo
                    opciones[0] = "-destdir";
                    opciones[1] = "src\\proyectojflex";
                    opciones[2] = "-parser";
                    opciones[3] = "ConvertirSintactico";
                    opciones[4] = "D:\\proyectosNEtbeans\\ProyectoJflex\\src\\proyectojflex\\Convertir.cup";
                    try {
                        //llama a metodo que genera el archivo
                        java_cup.Main.main(opciones);
                    } catch (Exception e) {
                        System.out.println("error cup");
                        System.out.print(e);
                    }
                    /*Para generar el archivo Convertir.java*/
                    String path = "D:\\proyectosNEtbeans\\ProyectoJflex\\src\\proyectojflex\\Convertir.flex";
                    File file = new File(path);
                    System.out.println("\n*** Generando Archivo Lexico***\n");
                    
                    //Llama al metodo para generar el archivo
                    JFlex.Main.generate(file);
                    System.out.println("Archivos Generados!");
                    break;
                }
                case 2: {
                    /*  Ejecutamos el analizador lexico y sintactico
                     sobre un archivo de pruebas. 
                     */
                    Scanner ss = new Scanner(System.in);
                    System.out.println("Ingrese los datos a evaluar");
                    entrada = ss.nextLine();
                    //Dirección donde se encuentra nuestro fichero a leer
                    File ar = new File("D:\\proyectosNEtbeans\\ProyectoJflex\\src\\proyectojflex\\fichero.txt");
                    BufferedWriter bw;
                    if (ar.exists()) {
                        ar.delete();
                        
                        //Pra escribir en el arhivo
                        bw = new BufferedWriter(new FileWriter(ar));
                        bw.write(entrada);
                        bw.close();
                        System.out.println("__*__*_ Resultado _*__*__");

                        /*Ceramos un objeto de nuestro convertidor Sintáctico y enviamos
                        el archivo que vamos a leer*/
                       ConvertirSintactico c_sin = new ConvertirSintactico(new Convertir(new FileInputStream(ar)));
                        try {
                        //Llamaos al codigo parser para ejecutar los metodos elaborados
                        c_sin.parse();
                        } catch (Exception ex) {
                            Logger.getLogger(MainCup.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Archivo Compilado!");
                        System.out.println("[*-*- Finalizo proceso -*-*]");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Gracias por usar el programa!");
                    break;
                }
               default: {
                    System.out.println("Opcion no valida!");
                    break;
                }
            }
        } while (menu != 3);
    }
}
