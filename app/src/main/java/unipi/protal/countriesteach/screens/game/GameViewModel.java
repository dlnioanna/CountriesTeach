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
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.database.QuestionQuizCrossRefDao;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Question;
import unipi.protal.countriesteach.entities.QuestionQuizCrossRef;
import unipi.protal.countriesteach.entities.Quiz;

public class GameViewModel extends AndroidViewModel {
    private LiveData<Country> country;
    private LiveData<List<Country>> allCountries;
    public MutableLiveData<Integer> countryIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> firstAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> secondAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> thirdAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> fourthAnswerIndex = new MutableLiveData<>();
    private Random random = new Random();
    private CountryDao countryDao;
    private QuizDao quizDao;
    private QuestionDao questionDao;
    private QuestionQuizCrossRefDao questionQuizCrossRefDao;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public GameViewModel(@NonNull Application application) {
        super(application);
        Database db = Database.getDatabase(application);
        countryDao = db.countryDao();
        quizDao = db.quizDao();
        questionDao = db.questionDao();
        questionQuizCrossRefDao = db.questionQuizCrossRefDao();
        allCountries = countryDao.getAlphabetizedCountries();
        Quiz quiz = new Quiz();
        quiz.setStartDateMillis(Calendar.getInstance().getTimeInMillis());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Long quizId = quizDao.insertQuiz(quiz);
                for (int i = 1; i < 11; i++) {
                    Question question = new Question(i);
                    Long questionId = questionDao.insertQuestion(question);
                    QuestionQuizCrossRef questionQuizCrossRef = new QuestionQuizCrossRef(quizId, questionId);
                    questionQuizCrossRefDao.insertQuestionQuizRef(questionQuizCrossRef);
                }
            }
        });

        nextCountryIndex();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Country>> getAllCountries() {
        return allCountries;
    }

    public void nextCountryIndex() {
        countryIndex.setValue(random.ints(1, 49)
                .findFirst()
                .getAsInt());
        getRandomAnswersIndex();
    }

    public void getRandomAnswersIndex() {
        List<Integer> possibleAnswers = new ArrayList<>();
        possibleAnswers.add(countryIndex.getValue());
        while (possibleAnswers.size() < 4) {
            Integer randomAnswer = random.ints(1, 49)
                    .findFirst()
                    .getAsInt();
            Predicate<Integer> answers = i -> (possibleAnswers.contains(i));
            while (answers.test(randomAnswer)) {
                randomAnswer = random.ints(1, 49)
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
}



