package Classi;

import java.util.ArrayList;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wuyir
 */
public class IscrizioneAppello {
    public class Pair<F, S> {
    public F fst;
    public S snd;

    public Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

        @Override
        public String toString() {
            return fst+";"+snd;
        }

       
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair<?, ?> other = (Pair<?, ?>) obj;
            if (!Objects.equals(this.fst, other.fst)) {
                return false;
            }
            return Objects.equals(this.snd, other.snd);
        }
        
    
}

    ArrayList<Pair<String,String>>iscrizioni=new ArrayList<>();

    public IscrizioneAppello(ArrayList<String>dati) {
          String separatore=";";
        for(String i: dati){
            Pair<String,String>tmp;
            String[] d=i.split(separatore);
            tmp=new Pair(d[0],d[1]);
            iscrizioni.add(tmp);
        }
        
    }
    
    
    public boolean iscriviAppello(Appello a,Studente s){
        if(s.getCorsoIscritto().getDisciplineAssegnati().contains(a.getDisciplinaAssegnata()) && !getIscrizioni().contains(new Pair(a.getIdAppello(),s.getMatricolaStudente()))){
            s.getAppelliIscritti().add(a);
            this.iscrizioni.add(new Pair(a.getIdAppello(),s.getMatricolaStudente()));
            return true;
        }
        return false;
        
       
    }

    public ArrayList<Pair<String, String>> visualizzaIscrizioni() {
        return iscrizioni;
    }

    public ArrayList<Pair<String, String>> getIscrizioni() {
        return iscrizioni;
    }
    
        
     public void elimina(String codice) {
        ArrayList<Pair<String,String>> daRimuovere=new ArrayList<>();
        for (Pair<String,String> d : iscrizioni) {
                System.out.println(d.snd+" "+codice);
            if (d.snd.equals(codice)) {
                daRimuovere.add(d);
                System.out.println("S");
            }
        }
        System.out.println(iscrizioni.remove(daRimuovere.get(0)));

    }

}
