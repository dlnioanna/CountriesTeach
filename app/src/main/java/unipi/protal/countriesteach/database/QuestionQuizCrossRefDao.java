package unipi.protal.countriesteach.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import unipi.protal.countriesteach.entities.Question;
import unipi.protal.countriesteach.entities.QuestionQuizCrossRef;
import unipi.protal.countriesteach.entities.Quiz;

@Dao
public interface QuestionQuizCrossRefDao {
    @Insert
    void insertQuestionQuizRef(QuestionQuizCrossRef questionQuizCrossRef);

    @Transaction
    @Query("SELECT * FROM question")
    public List<Question> getQuizWithQuestions();

    @Transaction
    @Query("SELECT * FROM quiz")
    public List<Quiz> getQuizesWithQuestion();
}
