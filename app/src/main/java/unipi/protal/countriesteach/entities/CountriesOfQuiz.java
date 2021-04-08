package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CountriesOfQuiz {
    @Embedded
    private Quiz quiz;
    @Relation(
            parentColumn = "quizId",
            entityColumn = "countryId"
    )
    private List<Country> countries;

    private boolean answered;
}
