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
public class Populasi {

    Kromosom[] kroms;

    public Populasi(int popSize, boolean status) {
        kroms = new Kromosom[popSize];
        if (status) {
            for (int i = 0; i < popSize(); i++) {
                Kromosom newKrom = new Kromosom();
                newKrom.membuatKromosom();
                setKrom(i, newKrom);
            }
        }
    }
    
    public void setKrom(int index, Kromosom krom) {
        kroms[index] = krom;
    }
    
    public Kromosom getKrom(int index) {
        return kroms[index];
    }

    public Kromosom getFittest() {
        Kromosom fittest = kroms[0];
        for (int i = 1; i < popSize(); i++) {
            if (fittest.getFitness() <= getKrom(i).getFitness()) {
                fittest = getKrom(i);
            }
        }
        return fittest;
    }

    public int popSize() {
        return kroms.length;
    }
}
