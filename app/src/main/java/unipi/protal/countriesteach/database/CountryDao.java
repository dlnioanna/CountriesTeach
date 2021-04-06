package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    void insertCountry(Country country);

    @Delete
    void deleteCountry(Country coutry);

    @Update
    void updatecountry(Country country);

    @Query("SELECT * FROM country WHERE countryId=:id")
    Country findCountryById(Integer id);

    @Query("SELECT * FROM country ORDER BY countryName ASC")
    LiveData<List<Country>> getAlphabetizedCountries();
}
