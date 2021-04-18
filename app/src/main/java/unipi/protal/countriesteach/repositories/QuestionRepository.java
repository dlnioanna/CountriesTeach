package unipi.protal.countriesteach.repositories;

import android.app.Application;

import java.util.List;

import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.entities.Question;

public class QuestionRepository {
    private final QuestionDao questionDao;
    private List<Question> questionList;

    public QuestionRepository(Application application) {
        Database db = Database.getDatabase(application);
        questionDao = db.questionDao();
    }

    public void insertQuestion(Question question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    questionDao.insertQuestion(question);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void insertAllQuestions(List<Question> questions) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    questionDao.insertAllQuestions(questions);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
