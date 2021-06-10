package unipi.protal.countriesteach.callables;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import unipi.protal.countriesteach.database.CountryContentValues;
import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.genetic.exceptions.GeneticAlgorithmException;
import unipi.protal.countriesteach.genetic.service.GeneticAlgorithmService;
import unipi.protal.countriesteach.repositories.CountryRepository;
import unipi.protal.countriesteach.utils.NumberUtils;

import static unipi.protal.countriesteach.database.CountryContentValues.AFRICAN_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.AFRICA_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.AFRICA_START_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.AMERICAN_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.AMERICA_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.AMERICA_START_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.ASIAN_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.ASIA_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.ASIA_START_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPE;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPEAN_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPE_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPE_START_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.OCEANIAN_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.OCEANIA_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.OCEANIA_START_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.WORLD_COUNTRY_IDS;
import static unipi.protal.countriesteach.database.CountryContentValues.WORLD_END_INDEX;
import static unipi.protal.countriesteach.database.CountryContentValues.WORLD_START_INDEX;

public class SolutionCallable implements Callable<List<Integer>> {
    private int continentId;
    private int startIndex;
    private int endIndex;
    private QuestionDao questionDao;
    private CountryDao countryDao;

    public SolutionCallable(int continentId, int startIndex, int endIndex, QuestionDao questionDao, CountryDao countryDao) {

        this.continentId = continentId;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.questionDao = questionDao;
        this.countryDao = countryDao;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer[]> rows = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        List<Long> countriesId = new ArrayList<>();
        int totalNumberOfQuestions = 0;
        if (continentId == EUROPE) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(EUROPEAN_COUNTRY_IDS);
        } else if (continentId == CountryContentValues.AMERICA) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(AMERICAN_COUNTRY_IDS);
        } else if (continentId == CountryContentValues.ASIA) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(ASIAN_COUNTRY_IDS);
        } else if (continentId == CountryContentValues.AFRICA) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(AFRICAN_COUNTRY_IDS);
        } else if (continentId == CountryContentValues.OCEANIA) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(OCEANIAN_COUNTRY_IDS);
        } else if (continentId == CountryContentValues.WORLD) {
            totalNumberOfQuestions = questionDao.countTotalNumberOfQuestions(WORLD_COUNTRY_IDS);
        }

        Double num = Double.valueOf(totalNumberOfQuestions);
        if (num == 0) {
            num = new Double(1);
        }

        for (int i = startIndex; i <= endIndex; i++) {
            Integer numberOfInstances = 0, numberOfErrors = 0;
            numberOfInstances = questionDao.countInstancesOfCountry(i);
            numberOfErrors = questionDao.countErrorsOfCountry(i);
            int numberOfInstancesPercentage = (int) ((numberOfInstances / num) * 100);
            int numberOfErrorsPercentage = (int) ((numberOfErrors / num) * 100);
            // id xoras, pososto emfanishs , pososto lathon , pososto hints

            Integer[] row = null;
            if (totalNumberOfQuestions != 0) {
                row = new Integer[]{i, numberOfInstancesPercentage, numberOfErrorsPercentage, 0};
            } else {
                row = new Integer[]{i, NumberUtils.getRandom(0, 100), NumberUtils.getRandom(0, 100), 0};
            }
            rows.add(row);
            // Log.i("row and rows ", "row is " + row[0] + " rows are " + rows.size());
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
                // System.out.println("Generation " + i + ": " + solution + ", Fitness: " + fitness);
            }
        } catch (GeneticAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        Log.e("questions indexes ", "Generation " + solution + ", Fitness: " + fitness);
        return solution;
    }
}
