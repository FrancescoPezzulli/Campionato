package control;

// @author Studente

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Squadra;


public class Controller {
    
    private ArrayList<Squadra> squadre = new ArrayList<>();
    
    public void readTeams(String filename) {
        try {
            Scanner lettore = new Scanner(new File(filename));
            while(lettore.hasNext()){
                String letta = lettore.nextLine();
                Squadra tmp = new Squadra(letta);
                squadre.add(tmp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File " + filename + " non trovato!");;
        }
    }
    
    // deve essere di questo tipo: Roma 3 Napoli 2
    public void inserisciRisultati(String squadra1, String squadra2, int golse1, int golsu1){
        for (int i = 0; i < squadre.size(); i++) {
            if (squadre.get(i).getNome().equals(squadra1)) {
                int possquad1 = i;
                for (int j = 0; j < squadre.size(); j++) {
                    if (squadre.get(j).getNome().equals(squadra2)) {
                        int possquad2 = j;
                        //squadra 1
                        squadre.get(possquad1).gioca(golse1, golsu1);
                        int punt1 = squadre.get(possquad1).calcola();
                        squadre.get(possquad1).setPunteggio(punt1);
                        
                        //squadra 2
                        squadre.get(possquad2).gioca(golsu1, golse1);
                        int punt2 = squadre.get(possquad2).calcola();
                        squadre.get(possquad2).setPunteggio(punt2);
                    }
                }
            }
        }
    }
    
    
    public void sort(){
        int cont = 0;
        while(cont != squadre.size()-1){
            cont = 0;
            for (int i = 0; i < squadre.size()-1; i++) {
                
                //se punteggi diversi
                if (squadre.get(i).getPunteggio() < squadre.get(i+1).getPunteggio()) {
                    Squadra tmppicc = squadre.get(i);
                    Squadra tmpgrande = squadre.get(i+1);
                    squadre.set(i, tmpgrande);
                    squadre.set(i+1, tmppicc);
                } 
                
                //se punteggi uguali
                else if (squadre.get(i).getPunteggio() == squadre.get(i+1).getPunteggio()) {
                    if (squadre.get(i).getGoalSegnati() < squadre.get(i+1).getGoalSegnati()) {
                        Squadra tmppicc = squadre.get(i);
                        Squadra tmpgrande = squadre.get(i+1);
                        squadre.set(i, tmpgrande);
                        squadre.set(i+1, tmppicc);
                    }
                    else if (squadre.get(i).getGoalSegnati() >= squadre.get(i+1).getGoalSegnati()) {
                        cont++;
                    }
                }
                
                //aggiungi al contatore che la coppia è ordinata
                else {
                    cont++;
                }
                
            } 
        }  
    }
    
//    public void printLeaderboard(){
//        for (int i = 0; i < squadre.size(); i++) {
//            System.out.println(i+1 + " squadra: " + squadre.get(i).getNome() + "\tpunti: " + squadre.get(i).getPunteggio() + "\t| goal segnati: " + squadre.get(i).getGoalSegnati() + "\t| goal subiti: " + squadre.get(i).getGoalSubiti());
//        }
//    }
    
    public void prLines () {
        for (Squadra squadre1 : squadre) {
            System.out.printf("\n%-20.20s %15d %15d %15d", squadre1.getNome(), squadre1.getPunteggio(), squadre1.getGoalSegnati(), squadre1.getGoalSubiti());
        }
    }   

    public void prTitles () {
        System.out.printf("\n%-20s %15s %15s %15s", "Squadre", "Punteggio", "Goal segnati", "Goal subiti");
    }
    
    public void prLeaderboard() {
        prTitles();
        prLines();
    }
 
}
