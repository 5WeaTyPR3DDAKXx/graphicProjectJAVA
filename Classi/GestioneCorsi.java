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
public class GestioneCorsi {

    private static ArrayList<Corso> corsi = new ArrayList<>();

    public GestioneCorsi(ArrayList<String> dati) {
        String separatore = ";";
        for (String i : dati) {

            String[] d = i.split(separatore);
            if(d[0]==null) break;
            Corso tmp = new Corso(d[0], d[1], Integer.parseInt(d[2]));
            corsi.add(tmp);
        }
    }
    
    public void cambiaNome(String code, String nome) {
        for (Corso i : corsi) {
            if (i.getCodiceCorso().equals(code)) {
                i.nomeCorso=nome;
            }
        }
    }
    
    public void cambiaAnni(String code, int anni) {
        for (Corso i : corsi) {
            if (i.getCodiceCorso().equals(code)) {
                i.durataAnni=anni;
            }
        }
    }

    public GestioneCorsi() {
        corsi = new ArrayList<>();
    }

    public void assegnaCorso(Disciplina d, Corso c) {
        d.setCorsoDisciplina(c);
        c.aggiungiDiscipline(d);
    }
    
    public boolean creaCorso(String codice, String nome, int durata) {
        if (cercaCorso(codice) == null) {
            corsi.add(new Corso(codice, nome, durata));
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Corso> visualizzaCorsi() {
        return corsi;
    }

    public void modificaCorso(String codice, String nome, int durata) {
        for (Corso i : corsi) {
            if (i.getCodiceCorso().equals(codice)) {
                i.setDurataAnni(durata);
                i.setNomeCorso(nome);
            }
        }

    }

    public void elimina(String codice) {
        ArrayList<Corso> daRimuovere = new ArrayList<>();
        for (Corso a : corsi) {

            if (a.equals(codice)) {
                daRimuovere.add(a);
            }
        }
        System.out.println(corsi.remove(daRimuovere.get(0)));

    }

    public static Corso cercaCorso(String codice) {
        for (Corso i : corsi) {
            if (i.getCodiceCorso().equals(codice)) {
                return i;
            }
        }
        return null;
    }

    public static Corso cercaCorsoNome(String nome) {
        for (Corso i : corsi) {
            if (i.getNomeCorso().equals(nome)) {
                return i;
            }
        }
        return null;
    }
}
