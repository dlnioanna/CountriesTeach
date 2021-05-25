package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "question")
public class Question {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private long questionId;
    @ColumnInfo
    private long countryId;
    @ColumnInfo
    private Integer position;
    @ColumnInfo
    private Boolean answered;
    @ColumnInfo
    private Boolean hint;

    public Question(long countryId) {
        this.countryId = countryId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }

    public Boolean getHint() {
        return hint;
    }

    public void setHint(Boolean hint) {
        this.hint = hint;
    }
}
