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
public class GestioneStudenti {// possibilita di iscriversi solo a un corso non implementato=========

    private static ArrayList<Studente> studenti = new ArrayList<>();

    public GestioneStudenti(ArrayList<String> dati) {
        String separatore = ";";
        for (String i : dati) {
            Studente tmp;
            String[] d = i.split(separatore);
            Corso dis = GestioneCorsi.cercaCorso(d[3]);
            if (dis == null) break;
            else {
                tmp = new Studente(d[0], d[1], d[2], dis);
            }
            studenti.add(tmp);
        }
    }

    public boolean registraStudente(String matricola, String nome, String cognome, Corso corso) {
        if (cercaStudente(matricola) == null) {
            studenti.add(new Studente(matricola, nome, cognome, corso));
            return true;
        } else {
            return false;
        }
    }

    public void elimina(String codice) {
        ArrayList<Studente> daRimuovere = new ArrayList<>();
        for (Studente d : studenti) {

            if (d.equals(codice)) {
                daRimuovere.add(d);
            }
        }
        System.out.println(studenti.remove(daRimuovere.get(0)));

    }

    public void cambiaCognome(String code, String cognome) {
        for (Studente i : studenti) {
            if (i.getMatricolaStudente().equals(code)) {
                i.cognome = cognome;
            }
        }
    }

    public void cambiaNome(String code, String nome) {
        for (Studente i : studenti) {
            if (i.getMatricolaStudente().equals(code)) {
                i.nome = nome;
            }
        }
    }

    public Studente cercaStudente(String matricolona) {
        for (Studente i : studenti) {
            if (i.equals(matricolona)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Studente> visualizzaStudenti() {
        return studenti;
    }

}
