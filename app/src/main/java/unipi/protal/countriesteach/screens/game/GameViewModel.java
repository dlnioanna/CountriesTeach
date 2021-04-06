package unipi.protal.countriesteach.screens.game;

import android.app.Application;

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
    private final LiveData<List<Country>> allCountries;

    public GameViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        allCountries = countryRepository.getAllCountries();
    }

    LiveData<List<Country>> getAllCountries() {
        return allCountries;
    }

    public void insert(Country country) {
        countryRepository.insert(country);
    }
}



