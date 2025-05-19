/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

import java.util.ArrayList;

/**
 *
 * @author predieric
 */
public class Studente {
    String matricolaStudente;
    String nome;
    String cognome;
    Corso corsoIscritto;//uno studente è iscritto a un solo corso 
    ArrayList<Appello>appelliIscritti;
    

    public Studente(String matricolaStudente, String nome, String cognome, Corso corsoIscritto) {
        this.matricolaStudente = matricolaStudente;
        this.nome = nome;
        this.cognome = cognome;
        this.corsoIscritto = corsoIscritto;
        this.appelliIscritti=new ArrayList<>();
    }

    public ArrayList<Appello> getAppelliIscritti() {
        return appelliIscritti;
    }

    @Override
    public String toString() {
        return this.matricolaStudente+";"+this.nome+";"+this.cognome+";"+this.corsoIscritto.getCodiceCorso();
    }

    public String getMatricolaStudente() {
        return matricolaStudente;
    }
    
    
    
      public boolean equals(String code) {
        
       return code.equals(getMatricolaStudente());
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Corso getCorsoIscritto() {
        return corsoIscritto;
    }

}
