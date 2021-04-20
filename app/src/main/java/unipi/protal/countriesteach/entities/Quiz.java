package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "quiz")
public class Quiz {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private long quizId;
    @ColumnInfo
    private Long startDateMillis;
    @ColumnInfo
    private Long endDateMillis;
    @ColumnInfo
    private Integer score;

    public Quiz() { }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public Long getStartDateMillis() {
        return startDateMillis;
    }

    public void setStartDateMillis(Long startDateMillis) {
        this.startDateMillis = startDateMillis;
    }

    public Long getEndDateMillis() {
        return endDateMillis;
    }

    public void setEndDateMillis(Long endDateMillis) {
        this.endDateMillis = endDateMillis;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
