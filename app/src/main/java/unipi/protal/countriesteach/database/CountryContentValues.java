package unipi.protal.countriesteach.database;

import android.content.ContentValues;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.entities.Country;
//   https://androtak.wordpress.com/2016/03/01/how-to-convert-any-object-to-contentvalues-in-for-android-sqlite-insertion/

public class CountryContentValues {

    ContentValues contentValues = new ContentValues();
    List<Country> countries = new ArrayList<>();
    Country c1 = new Country(1,"albania", 1);
    Country c2 = new Country(2,"andorra",1);
    Country c3 = new Country(3,"armenia",1);
    Country c4 = new Country(4,"austria",1);


    public ContentValues getCountryContentValues(){
        countries.add(c1);
        countries.add(c2);
        countries.add(c3);
        countries.add(c4);

        for (Country country : countries) {
            contentValues.put("countryId", country.getCountryId());
            contentValues.put("countryName", country.getCountryName());
            contentValues.put("continentId", country.getContinentId());
        }
        return contentValues;
    }



}
