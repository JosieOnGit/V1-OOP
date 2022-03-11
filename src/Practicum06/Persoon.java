package Practicum06;

import java.util.ArrayList;

public class Persoon {

    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<Game>();

    public Persoon(String nm, double bud){
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game g) {
        if (g.huidigeWaarde() < budget) {
            budget = budget - g.huidigeWaarde();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verkoop(Game g, Persoon koper) {
        if (koper.getBudget() > g.huidigeWaarde()) {
            koper.koop(g);
            budget += g.huidigeWaarde();
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String info = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:";

        for (Game item : mijnGames) {
            info += "\n" + item.toString();
        }
        return info;
    }
}