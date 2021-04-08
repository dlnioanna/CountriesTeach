package unipi.protal.countriesteach.screens.game;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import unipi.protal.countriesteach.database.*;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.repositories.CountryRepository;

public class GameViewModel extends AndroidViewModel {
    private CountryRepository countryRepository;
    private LiveData<List<Country>> allCountries;

    public GameViewModel(@NonNull Application application) {
        super(application);
        Log.e("GameViewModel","created");
        countryRepository = new CountryRepository(application);
        allCountries = countryRepository.getAlphabetizedCountries();
      //  LiveData<Country> c = countryRepository.getRandomCountry();
//        Log.e("GameViewModel","countries are "+c.getValue().getCountryName());

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("GameViewModel","cleared");
    }

    LiveData<List<Country>> getAllCountries() {
        return allCountries;
    }

    public void insert(Country country) {
        countryRepository.insert(country);
    }
}



