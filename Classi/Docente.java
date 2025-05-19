        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

/**
 *
 * @author predieric
 */
public class Docente {
     String matricolaDocente;
     String nome;
     String cognome;
     Disciplina disciplinaDocente;// riferimento alla disciplina assegnata al docente 1 e solo 1 

    public Docente(String matricolaDocente, String nome, String cognome, Disciplina disciplinaDocente) {
        this.matricolaDocente = matricolaDocente;
        this.nome = nome;
        this.cognome = cognome;
        this.disciplinaDocente = disciplinaDocente;
    }

    @Override
    public String toString() {
        return this.matricolaDocente+";"+this.nome+";"+this.cognome+";"+disciplinaDocente.getCodiceDisciplina();
    }
    
    public boolean equals(String code) {
        
       return code.equals(getMatricolaDocente());
    }

    public String getMatricolaDocente() {
        return matricolaDocente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Disciplina getDisciplinaDocente() {
        return disciplinaDocente;
    }
    
    
}
