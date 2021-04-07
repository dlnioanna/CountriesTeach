package unipi.protal.countriesteach.database;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import unipi.protal.countriesteach.entities.CountriesOfQuiz;

@Dao
public interface CountriesOfQuizDao {
    @Transaction
    @Query("SELECT * FROM quiz")
    public List<CountriesOfQuiz> getCountriesOfQuiz();

}
