package unipi.protal.countriesteach.database;
import unipi.protal.countriesteach.entities.*;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
}
