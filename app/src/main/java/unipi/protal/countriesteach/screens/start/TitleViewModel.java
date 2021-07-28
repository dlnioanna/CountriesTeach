package unipi.protal.countriesteach.screens.start;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;

import static unipi.protal.countriesteach.database.CountryContentValues.AFRICA;
import static unipi.protal.countriesteach.database.CountryContentValues.AMERICA;
import static unipi.protal.countriesteach.database.CountryContentValues.ASIA;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPE;
import static unipi.protal.countriesteach.database.CountryContentValues.OCEANIA;

public class TitleViewModel extends AndroidViewModel {
    public LiveData<Integer> europeanDifficultyLevel, asianDifficultyLevel,americanDifficultyLevel,africanDifficultyLevel,oceanianDifficultyLevel;
    private QuizDao quizDao;
    public TitleViewModel(@NonNull Application application) {
        super(application);
        Database db = Database.getDatabase(application);
        quizDao = db.quizDao();
        europeanDifficultyLevel =quizDao.getQuizLevel(EUROPE);
        asianDifficultyLevel=quizDao.getQuizLevel(ASIA);
        americanDifficultyLevel=quizDao.getQuizLevel(AMERICA);
        africanDifficultyLevel=quizDao.getQuizLevel(AFRICA);
        oceanianDifficultyLevel=quizDao.getQuizLevel(OCEANIA);
    }
}
