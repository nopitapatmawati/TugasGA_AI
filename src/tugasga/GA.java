/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasga;

/**
 *
 * @author ASUS
 */
public class GA {

    private static final double BatasMutasi = 0.015;
    private static final int pjgTournament = 5;
    private static final boolean elitism = true;

    public static Populasi evolusiPopulasi(Populasi pop) {
        Populasi newpop = new Populasi(pop.popSize(), false);
        int elitismOffset = 0;
        if (elitism) {
            newpop.setKrom(0, pop.getFittest());
            elitismOffset = 1;
        }

        for (int i = elitismOffset; i < newpop.popSize(); i++) {
            Kromosom ortu1 = pilihTournament(pop);
            Kromosom ortu2 = pilihTournament(pop);
            Kromosom anak = crossover(ortu1, ortu2);
            newpop.setKrom(i, anak);
        }
        for (int i = elitismOffset; i < newpop.popSize(); i++) {
            mutasi(newpop.getKrom(i));
        }

        return newpop;
    }

    public static Kromosom crossover(Kromosom ortu1, Kromosom ortu2) {
        Kromosom anak = new Kromosom();
        int titik1 = (int) (Math.random() * ortu1.KromosomSize());
        int titik2 = (int) (Math.random() * ortu1.KromosomSize());
        for (int i = 0; i < anak.KromosomSize(); i++) {
            if (titik1 < titik2 && i > titik1 && i < titik2) {
                anak.setNode(i, ortu1.getNode(i));
            }
            else if (titik1 > titik2) {
                if (!(i < titik1 && i > titik2)) {
                    anak.setNode(i, ortu1.getNode(i));
                }
            }
        }
        for (int i = 0; i < ortu2.KromosomSize(); i++) {
            if (!anak.containsKromosom(ortu2.getNode(i))) {
                for (int j = 0; j < anak.KromosomSize(); j++) {
                    if (anak.getNode(j) == null) {
                        anak.setNode(j, ortu2.getNode(i));
                        break;
                    }
                }
            }
        }
        return anak;
    }

    private static void mutasi(Kromosom krom) {
        for(int iKrom=0; iKrom < krom.KromosomSize(); iKrom++){
            if(Math.random() < BatasMutasi){
                int iKrom2 = (int) (krom.KromosomSize() * Math.random());
                Node node1 = krom.getNode(iKrom);
                Node node2 = krom.getNode(iKrom2);
                krom.setNode(iKrom2, node1);
                krom.setNode(iKrom, node2);
            }
        }
    }
    
    private static Kromosom pilihTournament(Populasi pop) {
        Populasi tournament = new Populasi(pjgTournament, false);
        for (int i = 0; i < pjgTournament; i++) {
            int randomId = (int) (Math.random() * pop.popSize());
            tournament.setKrom(i, pop.getKrom(randomId));
        }
        Kromosom fittest = tournament.getFittest();
        return fittest;
    }
}
