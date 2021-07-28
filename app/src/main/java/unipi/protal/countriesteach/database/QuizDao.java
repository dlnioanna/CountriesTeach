package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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

    @Query("UPDATE quiz SET endDateMillis=:endDate, score=:score, difficultyLevel=:difficultyLevel WHERE quizId = :id")
    void updateQuizEndDateAndScoreAndDifficultyLevel(long id, Long endDate, int score, int difficultyLevel);

    @Query("SELECT score FROM quiz WHERE quizId=:quizId")
    LiveData<Integer> getQuizScore(long quizId);

    @Query("SELECT startDateMillis FROM quiz WHERE quizId=:quizId")
    LiveData<Long> getQuizStartTime(long quizId);

    @Query("SELECT endDateMillis FROM quiz WHERE quizId=:quizId")
    LiveData<Long> getQuizEndTime(long quizId);

    @Query("SELECT COUNT(quizId) FROM quiz WHERE continentId=:continentId AND score=10")
    LiveData<Integer> getNubmerOfCorrectQuizes(int continentId);

    @Query("SELECT difficultyLevel FROM quiz WHERE continentId=:continentId ORDER BY difficultyLevel DESC LIMIT 1")
    LiveData<Integer> getQuizLevel(int continentId);

    @Query("SELECT quizId FROM quiz WHERE continentId=:continentId AND difficultyLevel=:difficultyLevel")
    List<Long> getQuizWithDifficulty(int continentId, int difficultyLevel);
}
