package unipi.protal.countriesteach.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import unipi.protal.countriesteach.entities.Question;
import unipi.protal.countriesteach.entities.QuestionQuizCrossRef;
import unipi.protal.countriesteach.entities.Quiz;

@Dao
public interface QuestionQuizCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertQuestionQuizRef(QuestionQuizCrossRef questionQuizCrossRef);

    @Transaction
    @Query("SELECT * FROM question")
    List<Question> getQuizWithQuestions();

    @Transaction
    @Query("SELECT * FROM quiz")
    List<Quiz> getQuizesWithQuestion();

    @Query("SELECT questionId FROM question_quiz_cross_ref WHERE quizId=:quizId")
    List<Long> selectQQ(long quizId);

    @Query("SELECT COUNT(*) FROM question_quiz_cross_ref,question,quiz WHERE question.countryId=:countryId AND quiz.difficultyLevel=:difficultyLevel AND answered=0 OR answered=NULL")
    Integer selectWrongAnsweredQuestionsOfCountry(long countryId, int difficultyLevel);

    @Query("SELECT COUNT(*) FROM question_quiz_cross_ref,question,quiz WHERE question.countryId=:countryId AND quiz.difficultyLevel=:difficultyLevel")
    Integer selectCountryInstances(long countryId, int difficultyLevel);

}
