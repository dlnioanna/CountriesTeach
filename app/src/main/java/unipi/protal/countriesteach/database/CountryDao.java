package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    long insertCountry(Country country);

    @Delete
    void deleteCountry(Country coutry);

    @Update
    void updatecountry(Country country);

    @Query("SELECT * FROM country WHERE countryId=:id")
    LiveData<Country> findCountryById(long id);

    @Query("SELECT * FROM country WHERE countryId=:id")
    Country findCountryWithId(long id);

    @Query("SELECT * FROM country ORDER BY countryName ASC")
    LiveData<List<Country>> getAlphabetizedCountries();

    @Query("DELETE FROM country")
    void deleteAll();

    @Insert
    List<Long> insertAll(List<Country> countries);
}
