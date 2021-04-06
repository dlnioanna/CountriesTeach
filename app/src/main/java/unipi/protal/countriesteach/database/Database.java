package unipi.protal.countriesteach.database;
import androidx.room.RoomDatabase;

import unipi.protal.countriesteach.entities.*;

@androidx.room.Database(entities = {Country.class, Quiz.class}, version = 1)
public abstract  class Database extends RoomDatabase {
    public abstract CountryDao countryDao();
    public abstract QuizDao quizDao();

}
