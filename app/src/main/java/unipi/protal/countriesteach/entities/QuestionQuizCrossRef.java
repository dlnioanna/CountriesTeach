package unipi.protal.countriesteach.entities;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity(primaryKeys = {"quizId", "questionId"})
public class QuestionQuizCrossRef {

    @NonNull
    private Integer quizId;

    @NonNull
    private Integer questionId;

    public QuestionQuizCrossRef(@NonNull Integer quizId, @NonNull Integer questionId) {
        this.quizId = quizId;
        this.questionId = questionId;
    }

    @NonNull
    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(@NonNull Integer quizId) {
        this.quizId = quizId;
    }

    @NonNull
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(@NonNull Integer questionId) {
        this.questionId = questionId;
    }
}
