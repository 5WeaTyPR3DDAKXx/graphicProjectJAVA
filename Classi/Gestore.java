/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

/**
 *
 * @author wuyi
 */
public class Gestore {

    static public IscrizioneAppello ia;
    static public GestioneDiscipline gd;
    static public GestioneDocenti gdoc;
    static public GestioneCorsi gc;
    static public GestioneStudenti gs;
    static public GestioneAppelli ga;
    static public GestioneLettura gl = new GestioneLettura();

    public Gestore() {
        ia = new IscrizioneAppello(gl.readFile("iscrizioni_appelli.csv"));
        gc = new GestioneCorsi(gl.readFile("corsi.csv"));
        gs = new GestioneStudenti(gl.readFile("studenti.csv"));
        gd = new GestioneDiscipline(gl.readFile("discipline.csv"));
        gdoc = new GestioneDocenti(gl.readFile("docenti.csv"));
        ga = new GestioneAppelli(gl.readFile("appelli.csv"));

    }

    public void stampa() {
        System.out.println("xx");
    }
}
