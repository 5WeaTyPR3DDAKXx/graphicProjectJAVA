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
public class GestioneDiscipline {

    public static ArrayList<Disciplina> discipline = new ArrayList<>();

    public GestioneDiscipline(ArrayList<String> dati) {
        //  System.out.println("siamo qua");
        String separatore = ";";
        for (String i : dati) {
            Disciplina tmp;
            String[] d = i.split(separatore);
            Corso dis = GestioneCorsi.cercaCorso(d[3]);
            if(dis==null)break;
            tmp = new Disciplina(d[0], d[1], Integer.parseInt(d[2]), dis);
            discipline.add(tmp);
            System.out.println(tmp);
        }

    }

    public void cambiaNome(String code, String nome) {
        for (Disciplina i : discipline) {
            if (i.getCodiceDisciplina().equals(code)) {
                i.nomeDisciplina = nome;
            }
        }
    }

    public void cambiaCfu(String code, int cfu) {
        for (Disciplina i : discipline) {
            if (i.getCodiceDisciplina().equals(code)) {
                i.cfu = cfu;
            }
        }
    }

    public void cambiaCorso(String code, Corso corso) {
        for (Disciplina i : discipline) {
            if (i.getCodiceDisciplina().equals(code)) {
                i.corsoDisciplina = corso;
            }
        }
    }

    public void elimina(String codice) {
        ArrayList<Disciplina> daRimuovere = new ArrayList<>();
        for (Disciplina d : discipline) {

            if (d.equals(codice)) {
                daRimuovere.add(d);
            }
        }
        System.out.println(discipline.remove(daRimuovere.get(0)));

    }

    public void assegnaCorso(Disciplina d, Corso c) {
        d.setCorsoDisciplina(c);
        c.aggiungiDiscipline(d);
    }

    public boolean creaDisciplina(String codiceDisciplina, String nomeDisciplina, int cfu, Corso corsoDisciplina) {
        if (cfu >= 1 && cercaDisciplina(codiceDisciplina) == null && corsoDisciplina != null) {
            discipline.add(new Disciplina(codiceDisciplina, nomeDisciplina, cfu, corsoDisciplina));
            return true;
        }
        return false;
    }

    public static Disciplina cercaDisciplina(String codice) {
        for (Disciplina i : discipline) {
            if (i.getCodiceDisciplina().equals(codice)) {
                return i;
            }
        }
        return null;
    }

    public Disciplina cercaDisciplinaNome(String nome) {
        for (Disciplina i : discipline) {
            if (i.getNomeDisciplina().equals(nome)) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Disciplina> visualizzaDiscipline() {
        return discipline;
    }

}
