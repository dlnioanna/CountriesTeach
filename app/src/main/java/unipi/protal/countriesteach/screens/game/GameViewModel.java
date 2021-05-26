package unipi.protal.countriesteach.screens.game;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import unipi.protal.countriesteach.database.CountryContentValues;
import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.database.QuestionQuizCrossRefDao;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Question;
import unipi.protal.countriesteach.entities.QuestionQuizCrossRef;
import unipi.protal.countriesteach.entities.Quiz;
import unipi.protal.countriesteach.genetic.exceptions.GeneticAlgorithmException;
import unipi.protal.countriesteach.genetic.service.GeneticAlgorithmService;
import unipi.protal.countriesteach.utils.NumberUtils;

import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_AFRICAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_ALL_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_AMERICAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_ASIAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_EUROPEAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_OCEANIAN_COUNTRIES;

public class GameViewModel extends AndroidViewModel {
    private LiveData<List<Country>> europeanCountries, asianCountries, americanCountries, oceanianCountries, africanCountries, antarticaCountries, allCountries;
    public MutableLiveData<List<Question>> quizQuestions;
    public MutableLiveData<Integer> numberOfQuestion = new MutableLiveData<>();
    public MutableLiveData<Integer> countryIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> firstAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> secondAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> thirdAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> fourthAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<List<Country>> quizCountries = new MutableLiveData<>();
    private static final int NUMBER_OF_QUESTIONS = 10;
    private int numberOfCountries;
    private Random random = new Random();
    private CountryDao countryDao;
    private QuizDao quizDao;
    private QuestionDao questionDao;
    private QuestionQuizCrossRefDao questionQuizCrossRefDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Quiz quiz;
    private Long quizId;

    public GameViewModel(@NonNull Application application, int continentId) {
        super(application);
        numberOfQuestion.setValue(1);
        Database db = Database.getDatabase(application);
        countryDao = db.countryDao();
        quizDao = db.quizDao();
        questionDao = db.questionDao();
        questionQuizCrossRefDao = db.questionQuizCrossRefDao();
        europeanCountries = countryDao.getEuropeanCountries();
        africanCountries = countryDao.getAfricanCountries();
        americanCountries = countryDao.getAmericanCountries();
        asianCountries = countryDao.getAsianCountries();
        oceanianCountries = countryDao.getOceanianCountries();
        antarticaCountries = countryDao.getAntarcticaCountries();
        allCountries = countryDao.getAllCountries();
        if (continentId == CountryContentValues.EUROPE) {
            numberOfCountries = CountryContentValues.NUMBER_OF_EUROPEAN_COUNTRIES;
        } else if (continentId == CountryContentValues.AMERICA) {
            numberOfCountries = CountryContentValues.NUMBER_OF_AMERICAN_COUNTRIES;
        } else if (continentId == CountryContentValues.ASIA) {
            numberOfCountries = CountryContentValues.NUMBER_OF_ASIAN_COUNTRIES;
        } else if (continentId == CountryContentValues.AFRICA) {
            numberOfCountries = CountryContentValues.NUMBER_OF_AFRICAN_COUNTRIES;
        } else if (continentId == CountryContentValues.OCEANIA) {
            numberOfCountries = CountryContentValues.NUMBER_OF_OCEANIAN_COUNTRIES;
        } else if (continentId == CountryContentValues.WORLD) {
            numberOfCountries = CountryContentValues.NUMBER_OF_ALL_COUNTRIES;
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                quiz = new Quiz();
                quiz.setStartDateMillis(Calendar.getInstance().getTimeInMillis());
                quizId = quizDao.insertQuiz(quiz);
/* todo εδώ καλώ τον αλγόριθμο που διαλεγει χωρες και κανω το for για τις 10 χωρες που θα εχω βρει
                 και με το i θα διατρεχω τη λίστα αυτή

 */
                List<Question> questions = new ArrayList<>();
                for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
                    Question question = new Question(i + 1);
                    Long questionId = questionDao.insertQuestion(question);
                    QuestionQuizCrossRef questionQuizCrossRef = new QuestionQuizCrossRef(quizId, questionId);
                    questionQuizCrossRefDao.insertQuestionQuizRef(questionQuizCrossRef);
                    questions.add(question);
                }
                quizQuestions.setValue(questions);
            }
        });


        nextCountryIndex(numberOfCountries);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Country>> getQuizCountries(int id) {
        if (id == CountryContentValues.EUROPE) {
            if (europeanCountries != null)
                return europeanCountries;
        } else if (id == CountryContentValues.AMERICA) {
            if (americanCountries != null)
                return americanCountries;
        } else if (id == CountryContentValues.ASIA) {
            return asianCountries;
        } else if (id == CountryContentValues.AFRICA) {
            return africanCountries;
        } else if (id == CountryContentValues.OCEANIA) {
            return oceanianCountries;
        } else if (id == CountryContentValues.WORLD) {
            return allCountries;
        }
        return allCountries;
    }

    public LiveData<List<Question>> getQuizQuestions() {
        return quizQuestions;
    }

    public void nextCountryIndex(int size) {
        countryIndex.setValue(random.ints(1, size)
                .findFirst()
                .getAsInt());
        getRandomAnswersIndex(size);
    }

    public int getNumberOfQuestions() {
        return NUMBER_OF_QUESTIONS;
    }

    public void getRandomAnswersIndex(int size) {
        List<Integer> possibleAnswers = new ArrayList<>();
        possibleAnswers.add(countryIndex.getValue());
        while (possibleAnswers.size() < 4) {
            Integer randomAnswer = random.ints(1, size)
                    .findFirst()
                    .getAsInt();
            Predicate<Integer> answers = i -> (possibleAnswers.contains(i));
            while (answers.test(randomAnswer)) {
                randomAnswer = random.ints(1, size)
                        .findFirst()
                        .getAsInt();
            }
            possibleAnswers.add(randomAnswer);
        }
        Collections.shuffle(possibleAnswers);
        firstAnswerIndex.setValue(possibleAnswers.get(0));
        secondAnswerIndex.setValue(possibleAnswers.get(1));
        thirdAnswerIndex.setValue(possibleAnswers.get(2));
        fourthAnswerIndex.setValue(possibleAnswers.get(3));
    }

    public void selectQuestions(int id) {
        // Genetic algorithm example with dummy random data.
        List<Integer[]> rows = new ArrayList<>();
        for (int i = 0; i < numberOfCountries; i++) {
            // id xoras, pososto emfanishs , pososto lathon , pososto hints
            Integer[] row = {i + 1, NumberUtils.getRandom(0, 100), NumberUtils.getRandom(0, 100), NumberUtils.getRandom(0, 100)};
            rows.add(row);
        }

        List<Integer> solution = null;
        int fitness = 0;
        GeneticAlgorithmService service = new GeneticAlgorithmService();
        try {
            // service.populateTest();
            service.populate(rows);

            for (int i = 1; i <= NUMBER_OF_QUESTIONS; i++) {
                service.run();
                solution = service.getBestSolution();
                fitness = service.getBestSolutionFitness();

                System.out.println("Generation " + i + ": " + solution + ", Fitness: " + fitness);
            }
        } catch (GeneticAlgorithmException e) {
            System.err.println(e.getMessage());
        }

        // filtro na fero to mikrotero pososto emfanishs kai megalytero pososto lathon


    }

    public void saveAnswer() {

    }
}



