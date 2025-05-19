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
public class Appello {
    String idAppello;
    String data;
    Disciplina disciplinaAssegnata;
    ArrayList<Studente>studeniIscritti;

    public Appello(String idAppello, String data, Disciplina disciplinaAssegnati) {
        this.idAppello = idAppello;
        this.data = data;
        this.disciplinaAssegnata = disciplinaAssegnati;
        this.studeniIscritti= new ArrayList<>();
    }

    public ArrayList<Studente> getStudeniIscritti() {
        return studeniIscritti;
    }

    public String getIdAppello() {
        return idAppello;
    }

    public String getData() {
        return data;
    }

    public Disciplina getDisciplinaAssegnata() {
        return disciplinaAssegnata;
    }
    

    @Override
    public String toString() {
        /*
        String s = "";
        for(Studente i :studeniIscritti){
            s+=i.getMatricolaStudente()+",";
        }
        if(s!="")s=s.substring(s.length()-1);*/
        return idAppello+";"+data+";"+disciplinaAssegnata.getCodiceDisciplina();
    }
    
    public boolean equals(String code) {
        
       return code.equals(getIdAppello());
    }
    
}
