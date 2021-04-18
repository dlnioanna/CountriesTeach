package unipi.protal.countriesteach.entities;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity(primaryKeys = {"quizId", "countryId"})
public class CountriesQuizCrossRef {

    @NonNull
    private Integer quizId;

    @NonNull
    private Integer countryId;

    public CountriesQuizCrossRef(Integer quizId, Integer countryId) {
        this.quizId = quizId;
        this.countryId = countryId;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
