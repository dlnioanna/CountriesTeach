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

    @Query("SELECT * FROM country")
    LiveData<List<Country>> getAllCountries();

    @Query("SELECT * FROM country WHERE continentId=1 OR continentId=7")
    LiveData<List<Country>> getEuropeanCountries();

    @Query("SELECT * FROM country WHERE continentId=2")
    LiveData<List<Country>> getAmericanCountries();

    @Query("SELECT * FROM country WHERE continentId=3 OR continentId=7")
    LiveData<List<Country>> getAsianCountries();

    @Query("SELECT * FROM country WHERE continentId=4")
    LiveData<List<Country>> getAfricanCountries();

    @Query("SELECT * FROM country WHERE continentId=5")
    LiveData<List<Country>> getOceanianCountries();

    @Query("SELECT * FROM country WHERE continentId=6")
    LiveData<List<Country>> getAntarcticaCountries();

    @Query("DELETE FROM country")
    void deleteAll();

    @Insert
    List<Long> insertAll(List<Country> countries);
}
