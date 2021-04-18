package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class CountryOfQuiz {
    @Embedded
    public Country country;
    @Relation(
            parentColumn = "countryId",
            entityColumn = "quizId",
            associateBy = @Junction(CountriesQuizCrossRef.class)
    )
    public List<Quiz> quizList;
}
