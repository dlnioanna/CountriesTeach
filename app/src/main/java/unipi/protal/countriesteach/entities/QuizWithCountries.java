package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class QuizWithCountries {
    @Embedded
    public Quiz quiz;
    @Relation(
            parentColumn = "quizId",
            entityColumn = "countryId",
            associateBy = @Junction(CountriesQuizCrossRef.class)
    )
    public List<Country> countries;

    public QuizWithCountries(Quiz quiz, List<Country> countries) {
        this.quiz = quiz;
        this.countries = countries;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
