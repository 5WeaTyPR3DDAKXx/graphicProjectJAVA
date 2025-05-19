/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

import java.util.ArrayList;

/**
 *
 * @author wuyi
 */
public class GestioneDocenti {
    private static ArrayList<Docente>docenti=new ArrayList<>();
    
    // insegna una sola disciplina non ancora implementata

    public GestioneDocenti(ArrayList<String> dati) {
          String separatore=";";
        for(String i: dati){
            Docente tmp;
            String[] d=i.split(separatore);
            Disciplina dis=GestioneDiscipline.cercaDisciplina(d[3]);
            if(dis==null) break;
            else tmp = new Docente(d[0],d[1],d[2],dis);
            docenti.add(tmp);
        }
    }
    
    public void cambiaCognome(String code, String cognome) {
        for (Docente i : docenti) {
            if (i.getMatricolaDocente().equals(code)) {
                i.cognome=cognome;
            }
        }
    }
    
    public void cambiaNome(String code, String nome) {
        for (Docente i : docenti) {
            if (i.getMatricolaDocente().equals(code)) {
                i.nome=nome;
            }
        }
    }
    
    public void cambiaDisciplina(String code, Disciplina disciplina) {
        for (Docente i : docenti) {
            if (i.getMatricolaDocente().equals(code)) {
                i.disciplinaDocente=disciplina;
            }
        }
    }
    
    public boolean inserisciDocente(String matricola, String nome, String cognome, Disciplina disciplina){
         if (cercaDocente(matricola)==null ) {
            docenti.add(new Docente(matricola, nome, cognome, disciplina));
            return true;
        } else return false;
    }
    
     public void elimina(String codice) {
        ArrayList<Docente> daRimuovere=new ArrayList<>();
        for (Docente d : docenti) {

            if (d.equals(codice)) {
                daRimuovere.add(d);
            }
        }
        System.out.println(docenti.remove(daRimuovere.get(0)));

    }
    
    public Docente cercaDocente (String matricolona){
         for(Docente i:docenti){
            if(i.equals(matricolona))return i;
        }
        return null;
     }
    
    public ArrayList<Docente> visualizzaDocenti(){
        return docenti;
    }
}
