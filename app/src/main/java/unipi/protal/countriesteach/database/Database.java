package unipi.protal.countriesteach.database;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import unipi.protal.countriesteach.entities.*;

@androidx.room.Database(entities = {Country.class, Quiz.class}, version = 1)
public abstract  class Database extends RoomDatabase {
    private static volatile Database DB_INSTANCE;

    public abstract CountryDao countryDao();

    public abstract QuizDao quizDao();

    public static Database getDatabase(Context context) {
        if (DB_INSTANCE == null) {
            DB_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "protal_database")
                    .build();
        }
        return DB_INSTANCE;
    }
}
