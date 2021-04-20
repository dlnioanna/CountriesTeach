package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

@Dao
public interface QuizDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertQuiz(Quiz quiz);

    @Delete
    void deleteQuiz(Quiz quiz);

    @Update
    void updateQuiz(Quiz quiz);

}
