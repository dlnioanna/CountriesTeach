package unipi.protal.countriesteach.screens.gameEnd;

import android.app.Application;
import android.util.Log;

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
    private LiveData<Long> startTime, endTime;
    public GameEndViewModel(@NonNull Application application, Long quizId) {
        super(application);
        Database db = Database.getDatabase(application);
        quizDao = db.quizDao();
        quizScore=quizDao.getQuizScore(quizId);
        startTime=quizDao.getQuizStartTime(quizId);
        endTime=quizDao.getQuizEndTime(quizId);
    }

    public LiveData<Integer> getQuizScore() {
        return quizScore;
    }
    public LiveData<Long> getQuizStartTime() {
        return startTime;
    }
    public LiveData<Long> getQuizEndTime() {
        return endTime;
    }
}
