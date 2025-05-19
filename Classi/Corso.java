/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

/**
 *
 * @author predieric
 */
import java.util.ArrayList;
public class Corso {
    String codiceCorso;
    String nomeCorso;
    int durataAnni;
    ArrayList<Disciplina>disciplineAssegnati;

    public Corso(String codiceCorso, String nomeCorso, int durataAnni) {
        this.codiceCorso = codiceCorso;
        this.nomeCorso = nomeCorso;
        this.durataAnni = durataAnni;
        disciplineAssegnati=new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.codiceCorso+";"+this.nomeCorso+";"+this.durataAnni;
    }

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public int getDurataAnni() {
        return durataAnni;
    }

    
    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public void setDurataAnni(int durataAnni) {
        this.durataAnni = durataAnni;
    }

    public void aggiungiDiscipline(Disciplina get) {
        this.disciplineAssegnati.add(get);
    }
    
      public boolean equals(String code) {
        
       return code.equals(getCodiceCorso());
    }

    public ArrayList<Disciplina> getDisciplineAssegnati() {
        return disciplineAssegnati;
    }
    

}
