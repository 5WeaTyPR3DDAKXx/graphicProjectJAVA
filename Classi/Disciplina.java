/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

import java.util.Objects;

/**
 *
 * @author predieric
 */         
public class Disciplina {
    String codiceDisciplina;
    String nomeDisciplina;
    int cfu;
    Corso corsoDisciplina;// riferimento al corso assegnato 

    public Disciplina(String codiceDisciplina, String nomeDisciplina, int cfu, Corso corsoDisciplina) {
        this.codiceDisciplina = codiceDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cfu = cfu;
        this.corsoDisciplina = corsoDisciplina;
        corsoDisciplina.getDisciplineAssegnati().add(this);
    }

    public String getCodiceDisciplina() {
        return codiceDisciplina;
    }

    @Override
    public String toString() {
        return this.codiceDisciplina+";"+this.nomeDisciplina+";"+this.cfu+";"+this.corsoDisciplina.getCodiceCorso();
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public int getCfu() {
        return cfu;
    }

    public Corso getCorsoDisciplina() {
        return corsoDisciplina;
    }

    public void setCorsoDisciplina(Corso corsoDisciplina) {
        this.corsoDisciplina = corsoDisciplina;
    }

    

    
    public boolean equals(String code) {
        
       return code.equals(getCodiceDisciplina());
    }

    

    
}
