package unipi.protal.countriesteach.screens.game;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import unipi.protal.countriesteach.entities.CountriesQuizCrossRef;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Quiz;
import unipi.protal.countriesteach.repositories.CountryRepository;
import unipi.protal.countriesteach.repositories.QuizRepository;

public class GameViewModel extends AndroidViewModel {
    private CountryRepository countryRepository;
    private QuizRepository quizRepository;
    private LiveData<Country> country;
    private LiveData<List<Country>> allCountries;
    public MutableLiveData<Integer> countryIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> firstAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> secondAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> thirdAnswerIndex = new MutableLiveData<>();
    public MutableLiveData<Integer> fourthAnswerIndex = new MutableLiveData<>();
    private Random random = new Random();

    public GameViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        quizRepository = new QuizRepository(application);
        allCountries = countryRepository.getAlphabetizedCountries();
        Quiz quiz = new Quiz();
        quiz.setStartDateMillis(Calendar.getInstance().getTimeInMillis());
        quizRepository.insertQuiz(quiz);
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



