package campionatoapp;

// @author Studente
import control.Controller;
import java.util.Scanner;

public class CampionatoApp {

    public static void main(String[] args) throws InterruptedException {

        Scanner lettore = new Scanner(System.in);
        Controller c = new Controller();
        
        c.readTeams("data/campionato.txt");
        
        System.out.println("L'App ufficiale del campionato di Serie A");
        System.out.println("Premi 'i' per inserire i risultati delle partite, 'c' per mostrare la classifica, 'z' per uscire");

        while (true) {
            System.out.print("inserisci: ");
            String s = lettore.nextLine();
            switch (s) {
                case "i":
                    System.out.println("Ora inserisci i risulati: ");
                    String result = lettore.nextLine();
                    String[] sp = result.split(" ");
                    String sq1= sp[0].substring(0,1).toUpperCase() + sp[0].substring(1, sp[0].length()).toLowerCase();
                    String sq2= sp[2].substring(0,1).toUpperCase() + sp[2].substring(1, sp[2].length()).toLowerCase();
                    c.inserisciRisultati(sq1, sq2, Integer.valueOf(sp[1]), Integer.valueOf(sp[3]));
                    break;
                case "c": 
                    System.out.println("CLASSIFICA");
                    c.sort();
                    c.prLeaderboard();
                    System.out.println("");
                    System.out.println("");
                    break;
                case "z":
                    System.exit(1);
            }
        }

    }

}
