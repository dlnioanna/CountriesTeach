package unipi.protal.countriesteach.repositories;

import android.app.Application;

import java.util.List;

import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.database.QuestionDao;
import unipi.protal.countriesteach.database.QuestionQuizCrossRefDao;
import unipi.protal.countriesteach.entities.Question;
import unipi.protal.countriesteach.entities.QuestionQuizCrossRef;
import unipi.protal.countriesteach.entities.Quiz;

public class QuestionQuizCrossRefRepository {
    private final QuestionQuizCrossRefDao questionQuizCrossRefDao;
    private List<Question> questionList;

    public QuestionQuizCrossRefRepository(Application application) {
        Database db = Database.getDatabase(application);
        questionQuizCrossRefDao = db.questionQuizCrossRefDao();
    }

    public void insertQuizCrossRef(QuestionQuizCrossRef questionQuizCrossRef) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    questionQuizCrossRefDao.insertQuestionQuizRef(questionQuizCrossRef);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
