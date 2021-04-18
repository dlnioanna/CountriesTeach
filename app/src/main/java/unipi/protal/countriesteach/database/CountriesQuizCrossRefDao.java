package unipi.protal.countriesteach.database;

import androidx.room.Dao;
import androidx.room.Insert;

import unipi.protal.countriesteach.entities.CountriesQuizCrossRef;
import unipi.protal.countriesteach.entities.Country;

@Dao
public interface CountriesQuizCrossRefDao {
    @Insert
    void insertCountriesQuizCrossRef(CountriesQuizCrossRef countriesQuizCrossRef);
}
