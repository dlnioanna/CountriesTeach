package unipi.protal.countriesteach.genetic.comparators;

import java.util.Comparator;

import unipi.protal.countriesteach.genetic.model.Chromosome;

public class ChromosomeComparator implements Comparator<Chromosome> {
    @Override
    public int compare(Chromosome c1, Chromosome c2) {
        return c1.calculateFitness() - c2.calculateFitness();
    }
}
