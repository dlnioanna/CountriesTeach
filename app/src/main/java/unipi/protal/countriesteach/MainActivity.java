package unipi.protal.countriesteach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import unipi.protal.countriesteach.genetic.exceptions.GeneticAlgorithmException;
import unipi.protal.countriesteach.genetic.service.GeneticAlgorithmService;
import unipi.protal.countriesteach.utils.NumberUtils;

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Genetic algorithm example with dummy random data.

        List<Integer[]> rows = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Integer[] row = {i + 1, NumberUtils.getRandom(0, 100), NumberUtils.getRandom(0, 100), NumberUtils.getRandom(0, 100)};
            rows.add(row);
        }

        List<Integer> solution = null;
        int fitness = 0;
        GeneticAlgorithmService service = new GeneticAlgorithmService();
        try {
            // service.populateTest();
            service.populate(rows);

            for (int i = 1; i <= 100; i++) {
                service.run();
                solution = service.getBestSolution();
                fitness = service.getBestSolutionFitness();

                System.out.println("Generation " + i + ": " + solution + ", Fitness: " + fitness);
            }
        } catch (GeneticAlgorithmException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return super.onSupportNavigateUp();
    }

}