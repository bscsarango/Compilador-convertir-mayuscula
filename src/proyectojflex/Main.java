/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojflex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;
//import static jflex.Main.generate;

/**
 *
 * @author barcelona
 */
public class Main {
 FileWriter fw  = null;
   FileReader fr= null;
    PrintWriter pw = null;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        
        Main m = new Main();
    String path = "D:\\proyectosNEtbeans\\ProyectoJflex\\src\\proyectojflex\\Convertir.flex";
     //   generarArchivo(path);
    int menu = 4;
       do {
 System.out.println("********eliga en el menu");
        System.out.println("1: para generar");
        System.out.println("2: para escribir en archivo");
        System.out.println("3: para leer token");
        System.out.println("4: salir");
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        menu = scan.nextInt();
        
        switch(menu){
        case 1:
            generarArchivo(path);
            break;
        case 2:
            System.out.println("ingrese los datos de token");
            String datos  = scan1.nextLine();
            m.escribir_fichero(datos);
            break;
        case 3:
//        m.leer_datos();break;
            default:
                System.out.println("escoja numero del menu por favor");
        }
        
       }while( menu != 4);
    
    
            
    }
    
    public static void generarArchivo(String path) throws IOException{
        File file=new File(path);
       JFlex.Main.generate(file);
//        leer_datos();
    }
    public void escribir_fichero(String escribir) throws IOException{
    fw = new FileWriter("D:\\BORYS\\9MODULO\\Compiladores\\fichero.txt");
   // fr = new FileReader("D:\\BORYS\\9MODULO\\Compiladores\\fichero.txt");
 
    pw = new PrintWriter(fw);
  pw.print(escribir);
  //if (null != fw)
  fw.close();
  
  } 
 
//    public static void leer_datos() throws FileNotFoundException, IOException{
//    Reader reader = new BufferedReader(new FileReader("D:\\BORYS\\9MODULO\\Compiladores\\fichero.txt"));
//        Convertir con = new Convertir(reader);
//        String resultado="";

//    while (true){
//    Token token =con.yylex();
//if (token == null){

              //resultado=resultado+"error";
//              System.out.println(" "+resultado+"");
//              return;
//}
//switch (token){
//    case letra:
//        resultado=resultado+ "token "+token+ "  " + con.retorno + "\n ";
//break;
//    case numero:
//        resultado=resultado+ "token  "+token+ " "+ con.retorno + "\n ";
//break;
//        case espacio:
//        resultado=resultado+ "token "+token+ "  " + con.retorno + "\n ";
//break;
//            case convertir:
//        resultado=resultado+ "token "+token+ "  " + con.retorno + "\n ";
//break;
//            case suma:
//                    resultado=resultado+"token + suma"+"\n";
//                    break;
//            
//                        case error:
//                            resultado=resultado+ "simbolo desconocido"+"\n";
//                            break;
//                default:
//                    resultado=resultado+ "token "+ con.retorno + "\n ";
//
//    }
//
//    }
}
    
