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
public class GestioneAppelli {
    private static ArrayList<Appello>appelli=new ArrayList<>();
    
    public GestioneAppelli(ArrayList<String>dati) {
        String separatore=";";
        for(String i: dati){
            Appello tmp;
            String[] d=i.split(separatore);
            Disciplina dis=GestioneDiscipline.cercaDisciplina(d[2]);
            if(dis==null)break;
            else tmp = new Appello(d[0],d[1],dis);
            appelli.add(tmp);
        }
    }
    
     public void cambiaData(String code, String data) {
        for (Appello i : appelli) {
            if (i.getIdAppello().equals(code)) {
                i.data=data;
            }
        }
    }
     
     public void cambiaDisciplina(String code, Disciplina disciplina) {
        for (Appello i : appelli) {
            if (i.getIdAppello().equals(code)) {
                i.disciplinaAssegnata=disciplina;
            }
        }
    }
    
    public boolean creaAppello(String idAppello, String data, Disciplina disc){
        if (cercaAppello(idAppello)==null) {
            appelli.add(new Appello(idAppello, data, disc));
            return true;
        } else return false;
        
    }
    public void iscrizioneAppello(Studente s,Appello a){
       s.getAppelliIscritti().add(a);
       a.getStudeniIscritti().add(s);
    }
    public Appello cercaAppello(String idAppello){
        for(Appello i:appelli){
            if(i.equals(idAppello))return i ;
        }
        return null;
    }
    
    public void ordinaId(){
        appelli.sort((a,b)->{
            return a.getIdAppello().compareTo(b.getIdAppello());
        });
    }
    public void ordinaData(){
        appelli.sort((a,b)->{
            return a.getData().compareTo(b.getData());
        });
    }
   /* public void ordinaDisciplina(){
         appelli.sort((a,b)->{
            return a.getDisciplinaAssegnata().getCodiceDisciplina().compareTo(b.getDisciplinaAssegnata().getCodiceDisciplina());
        });
    }*/

    public void elimina(String codice) {
        ArrayList<Appello> daRimuovere = new ArrayList<>();
        for (Appello a : appelli) {

            if (a.equals(codice)) {
                daRimuovere.add(a);
            }
        }
        System.out.println(appelli.remove(daRimuovere.get(0)));

    }

    

    public ArrayList<Appello> visualizzaAppelli(){
        return appelli;
    }
}
