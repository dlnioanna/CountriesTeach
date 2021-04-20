package unipi.protal.countriesteach.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuizDao;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Quiz;

public class QuizRepository {
    private final QuizDao quizDao;
    private LiveData<List<Quiz>> quizList;
    private LiveData<Quiz> quiz;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    public QuizRepository(Application application) {
        Database db = Database.getDatabase(application);
        quizDao = db.quizDao();
    }

        public void insertQuiz(Quiz quiz) {
//        long[] quizId = new long[1];
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        quizId[0] = quizDao.insertQuiz(quiz);
//                        Log.e("quiz repozitory ", "quiz id "+quizId[0]);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//            return  quizId[0];

            final Long[] quizId = new Long[1];
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    quizId[0] = quizDao.insertQuiz(quiz);
                }
            });
            handler.post(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }



