package unipi.protal.countriesteach.callables;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.genetic.exceptions.GeneticAlgorithmException;
import unipi.protal.countriesteach.genetic.service.GeneticAlgorithmService;

public class SolutionCallable implements Callable<List<Integer>> {
    private int continentId;
    private int startIndex;
    private int endIndex;
    private QuestionDao questionDao;

    public SolutionCallable(int continentId, int startIndex, int endIndex, QuestionDao questionDao) {
        this.continentId = continentId;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.questionDao = questionDao;
    }


    @Override
    public List<Integer> call() throws Exception {
        List<Integer[]> rows = new ArrayList<>();
        int totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions();
        for (int i = startIndex; i <= endIndex; i++) {
            Integer numberOfInstances = 0, numberOfErrors = 0;
            numberOfInstances = questionDao.countInstancesOfCountry(i);
            numberOfErrors = questionDao.countErrorsOfCountry(i);
            Double num = new Double(totalNumberOfQuestions);
            int numberOfInstancesPercentage = (int) ((numberOfInstances / num) * 100);
            int numberOfErrorsPercentage = (int) ((numberOfErrors / num) * 100);
            Log.i("gameview model number of errors for country", i + " " + numberOfInstancesPercentage + " numberOfInstances " + numberOfErrorsPercentage
                    + " totalNumberOfQuestions " + totalNumberOfQuestions);
            // id xoras, pososto emfanishs , pososto lathon , pososto hints
            Integer[] row = {i, numberOfInstancesPercentage, numberOfErrorsPercentage, 0};
            rows.add(row);
            Log.i("row and rows ", "row is " + row[0] + " rows are " + rows.size());
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
        Log.e("questions indexes ", "Generation " + solution + ", Fitness: " + fitness);
        return solution;
    }
}
