package unipi.protal.countriesteach.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
import unipi.protal.countriesteach.entities.Question;

@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertQuestion(Question question);

    @Insert
    List<Long> insertAllQuestions(List<Question> questions);

    @Query("SELECT * FROM question WHERE questionId=:id")
    LiveData<Question> findQuestionById(long id);

    @Query("UPDATE question SET answered=:answer WHERE questionId = :id")
    void updateQuizEndDate(long id, boolean answer);

    @Query("UPDATE question SET answered=:answer WHERE questionId IN (:listOfQuestions) AND countryId=:countryId")
    void updateQuizAnswer(List<Long> listOfQuestions, long countryId, boolean answer);

    @Query("SELECT COUNT(*) FROM question WHERE countryId=:countryId")
    Integer countInstancesOfCountry(long countryId);

    @Query("SELECT COUNT(*) FROM question WHERE countryId=:countryId AND answered=0 OR answered=NULL")
    Integer countErrorsOfCountry(long countryId);

    @Query("SELECT COUNT(*) FROM question")
    Integer countTotalNumberOfQuestions();
}
