package unipi.protal.countriesteach.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import unipi.protal.countriesteach.entities.*;

/**
 * The database class for Room must be abstract and extend RoomDatabase
 * You annotate the class to be a Room database with @Database and use
 * the annotation parameters to declare the entities that belong in the database
 * and set the version number. Each entity corresponds to a table that will be created
 * in the database. Database migrations are beyond the scope of this codelab, so we
 * set exportSchema to false here to avoid a build warning. In a real app, you should
 * consider setting a directory for Room to use to export the schema so you can
 * check the current schema into your version control system.
 * The database exposes DAOs through an abstract "getter" method for each @Dao.
 * We've defined a singleton, WordRoomDatabase, to prevent having multiple instances
 * of the database opened at the same time.
 * getDatabase returns the singleton. It'll create the database the first time it's accessed,
 * using Room's database builder to create a RoomDatabase object in the application context
 * from the WordRoomDatabase class and names it "word_database".
 * We've created an ExecutorService with a fixed thread pool that you
 * will use to run database operations asynchronously on a background thread.
 * <p>
 * https://developer.android.com/codelabs/android-room-with-a-view#0
 */
@androidx.room.Database(entities = {Country.class, Quiz.class, Question.class, QuestionQuizCrossRef.class}, version = 4, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public abstract CountryDao countryDao();

    public abstract QuizDao quizDao();

    public abstract QuestionDao questionDao();

    public abstract QuestionQuizCrossRefDao questionQuizCrossRefDao();

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "protal_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                CountryDao dao = INSTANCE.countryDao();
                dao.deleteAll();
                List<Country> europeanCountries = CountryContentValues.initializeEuropeanCountries();
                dao.insertAll(europeanCountries);
                List<Country> oceanianCountries = CountryContentValues.initializeOceanianCountries();
                dao.insertAll(oceanianCountries);
                List<Country> asianCountries = CountryContentValues.initializeAsianCountries();
                dao.insertAll(asianCountries);
                List<Country> americanCountries = CountryContentValues.initializeAmericanCountries();
                dao.insertAll(americanCountries);
                List<Country> africanCountries = CountryContentValues.initializeAmfricanCountries();
                dao.insertAll(africanCountries);
            });
        }
    };
}

