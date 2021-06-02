package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertQuiz(Quiz quiz);

    @Delete
    void deleteQuiz(Quiz quiz);

    @Update
    void updateQuiz(Quiz quiz);

    @Query("UPDATE quiz SET endDateMillis=:endDate WHERE quizId = :id")
    void updateQuizEndDate(long id, Long endDate);

    @Query("UPDATE quiz SET endDateMillis=:endDate, score=:score WHERE quizId = :id")
    void updateQuizEndDateAndScore(long id, Long endDate, int score);

    @Query("SELECT score FROM quiz WHERE quizId=:quizId")
    LiveData<Integer> getQuizScore(long quizId);
}
