/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author singhg
 */
public class GestioneLettura {
    
  
    
    public ArrayList<String> readFile(String fileName){
        ArrayList<String>dati=new ArrayList<>();
        String line;
        
          try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
                line = br.readLine();
                while((line=br.readLine())!=null){
                //  String input=line.split(separatore);
                dati.add(line);
              }
          }
          catch(Exception  e){
              System.out.println(e);
          }
          
          return dati;
        
    }

    public void writeFile(String fileName,ArrayList<String>dati) {
        String etichetta="";
        try(BufferedReader br= new BufferedReader(new FileReader(fileName))){
           etichetta=br.readLine();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
    try ( BufferedWriter wr=new BufferedWriter(new FileWriter(fileName))) {
        wr.write(etichetta);
        wr.newLine();
        for(String i : dati){
            wr.write(i);
            wr.newLine();
        }
    }   
    catch(IOException e){
        System.out.println(e);
    }
    }
    
    
    
    
}
