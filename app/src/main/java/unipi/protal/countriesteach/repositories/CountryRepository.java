package unipi.protal.countriesteach.repositories;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.Random;

import unipi.protal.countriesteach.database.CountryDao;
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.entities.Country;

/**
 * The DAO is passed into the repository constructor as opposed to the whole database.
 * This is because you only need access to the DAO, since it contains all the read/write methods for the database.
 * There's no need to expose the entire database to the repository.
 * The getAllCountries method returns the LiveData list of countries from Room;
 * Room executes all queries on a separate thread. Then observed LiveData will notify the observer
 * on the main thread when the data has changed.
 * We need to not run the insert on the main thread, so we use the ExecutorService
 * we created in the Database to perform the insert on a background thread.
 */
public class CountryRepository {
    private final CountryDao countryDao;
    private LiveData<List<Country>> countries;
    private LiveData<Country> country;

    // Note that in order to unit test the CountryRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public CountryRepository(Application application) {
        Database db = Database.getDatabase(application);
        countryDao = db.countryDao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Country>> getAlphabetizedCountries() {
        countries = countryDao.getAllCountries();
        return countries;
    }

    public LiveData<Country> getRandomCoutry() {
        country = countryDao.findCountryById(getRandomCountryId());
        return country;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Country country) {
        Database.databaseWriteExecutor.execute(() -> {
            countryDao.insertCountry(country);
        });
    }

    public LiveData<Country> findCountryById(Integer num) {
        country = countryDao.findCountryById(num);
        return country;
    }

    private Integer getRandomCountryId() {
//        Random random = new Random();
//        return random.ints(1, 4)
//                .findFirst()
//                .getAsInt();
        int min = 1;
        int max = 10;

        Random r = new Random();
        int randomNum = r.nextInt(max - min + 1) + min;
        return randomNum;
    }

}
