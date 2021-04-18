package unipi.protal.countriesteach.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Quiz;
import unipi.protal.countriesteach.entities.QuizWithCountries;

@Dao
public interface QuizWithCountriesDao {

    @Transaction
    @Query("SELECT * FROM quiz")
    public List<Quiz> getQuizWithCountries();
}
