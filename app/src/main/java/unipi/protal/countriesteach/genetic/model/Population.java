package unipi.protal.countriesteach.genetic.model;

import java.util.ArrayList;
import java.util.List;

public class Population {
    private final List<Chromosome> chromosomes = new ArrayList<>();

    public void addChromosome(Chromosome chromosome) {
        if (!chromosomes.contains(chromosome))
            chromosomes.add(chromosome);
    }

    public int getFitness() {
        int fitness = 0;

        for (Chromosome chromosome : chromosomes)
            fitness += chromosome.calculateFitness();

        return fitness;
    }

    // Getters and Setters
    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }
}
