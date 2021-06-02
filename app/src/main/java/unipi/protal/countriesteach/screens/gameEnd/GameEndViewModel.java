package unipi.protal.countriesteach.screens.gameEnd;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Question;

public class GameEndViewModel extends AndroidViewModel {
    private QuizDao quizDao;
    private LiveData<Integer> quizScore;
    public GameEndViewModel(@NonNull Application application, Long quizId) {
        super(application);
        Database db = Database.getDatabase(application);
        quizDao = db.quizDao();
        quizScore=quizDao.getQuizScore(quizId);
    }

    public LiveData<Integer> getQuizScore() {
        return quizScore;
    }
}
