/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progettoinfo;
import grafica.MainFrame;
import Classi.*;
import java.util.ArrayList;

/**
 *
 * @author predieric
 */
public class ProgettoInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestioneCorsi gc = new GestioneCorsi();
      //  gc.creaCorso("fd", "nome", 0);
        //gc.creaCorso("fd", "nome", 0);
        //gc.creaCorso("fd", "nome", 0);
        //gc.visualizzaCorsi();
        //gc.modificaCorso("fd","fdsdfsgdyusgfhd",334);
        //gc.visualizzaCorsi();
        GestioneLettura gl= new GestioneLettura();
        ArrayList<String>dati=gl.readFile("corsi.csv");
        MainFrame.main();
        System.out.println(dati);
    }

}
