package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CountriesOfQuiz {
    @Embedded
    public Quiz quiz;
    @Relation(
            parentColumn = "quizId",
            entityColumn = "countryId"
    )
    public List<Country> countries;

}
