package model;

// @author Studente

public class Squadra {
    
    private String nome;
    private int partitePareggiate, partiteVinte, partitePerse, goalSegnati, goalSubiti, punteggio;

    public Squadra(String nome) {
        this.nome = nome;
    }
    
    public void gioca(int gse, int gsu) {
        if (gse > gsu) {
            partiteVinte++;
            goalSegnati = goalSegnati + gse;
            goalSubiti = goalSubiti + gsu;
        } else if (gse < gsu) {
            partitePerse++;
            goalSegnati = goalSegnati + gse;
            goalSubiti = goalSubiti + gsu;    
        } else if (gse == gsu) {
            partitePareggiate++;
            goalSegnati = goalSegnati + gse;
            goalSubiti = goalSubiti + gsu;
        }
        
    }
    
    public int calcola(){
        int vinte = partiteVinte * 3;
        int pareg = partitePareggiate;
        punteggio = vinte + pareg;
        return punteggio;
    }

    public int getPartitePareggiate() {
        return partitePareggiate;
    }

    public void setPartitePareggiate(int partitePareggiate) {
        this.partitePareggiate = partitePareggiate;
    }

    public int getPartiteVinte() {
        return partiteVinte;
    }

    public void setPartiteVinte(int partiteVinte) {
        this.partiteVinte = partiteVinte;
    }

    public int getPartitePerse() {
        return partitePerse;
    }

    public void setPartitePerse(int partitePerse) {
        this.partitePerse = partitePerse;
    }

    public int getGoalSegnati() {
        return goalSegnati;
    }

    public void setGoalSegnati(int goalSegnati) {
        this.goalSegnati = goalSegnati;
    }

    public int getGoalSubiti() {
        return goalSubiti;
    }

    public void setGoalSubiti(int goalSubiti) {
        this.goalSubiti = goalSubiti;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public String getNome() {
        return nome;
    }
    
}
