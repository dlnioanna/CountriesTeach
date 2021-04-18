package unipi.protal.countriesteach.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Quiz;

public class QuizRepository {
    private final QuizDao quizDao;
    private LiveData<List<Quiz>> quizList;
    private LiveData<Quiz> quiz;

    public QuizRepository(Application application) {
        Database db = Database.getDatabase(application);
        quizDao = db.quizDao();
    }

        public void insertQuiz(Quiz quiz) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    quizDao.insertQuiz(quiz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
