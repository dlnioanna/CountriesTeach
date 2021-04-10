package unipi.protal.countriesteach.screens.game;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.repositories.CountryRepository;

public class GameViewModel extends AndroidViewModel {
    private CountryRepository countryRepository;
    private MutableLiveData<Country> mutableCountry;
    private LiveData<Country> country;
    private String countryFlag;
    private MutableLiveData<String> countryName;
    private LiveData<List<Country>> allCountries;

    public GameViewModel(@NonNull Application application) {
        super(application);
        Log.e("GameViewModel","created");
        countryRepository = new CountryRepository(application);
       //allCountries = countryRepository.getAlphabetizedCountries();
        country = countryRepository.getRandomCountry();

    //   Log.e("GameViewModel","countries are "+country.getCountryName());


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("GameViewModel","cleared");
    }

    public LiveData<Country> getRandomCountry(){
        return country;
    }

    LiveData<List<Country>> getAllCountries() {
        return allCountries;
    }


}



