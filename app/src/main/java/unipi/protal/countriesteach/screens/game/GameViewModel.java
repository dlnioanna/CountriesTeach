package unipi.protal.countriesteach.screens.game;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.repositories.CountryRepository;

public class GameViewModel extends AndroidViewModel {
    private CountryRepository countryRepository;
    private LiveData<Country> country;
    private LiveData<List<Country>> allCountries;
    public MutableLiveData<Integer> countryIndex=new MutableLiveData<>(1);

    public GameViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        allCountries = countryRepository.getAlphabetizedCountries();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<List<Country>> getAllCountries() {
        return allCountries;
    }

    public void nextCountryIndex(){
        int min = 1;
        int max = 49;
        Random r = new Random();
        countryIndex.setValue(r.nextInt(max - min + 1));
        Log.e("country index is ",String.valueOf(countryIndex.getValue()));
    }
}



