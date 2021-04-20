package unipi.protal.countriesteach.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity(tableName = "question_quiz_cross_ref", primaryKeys = {"quizId", "questionId"})
public class QuestionQuizCrossRef {
    @NonNull
    @ColumnInfo
    private long quizId;

    @NonNull
    @ColumnInfo
    private long questionId;

    public QuestionQuizCrossRef(long quizId, long questionId) {
        this.quizId = quizId;
        this.questionId = questionId;
    }

    @NonNull
    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(@NonNull long quizId) {
        this.quizId = quizId;
    }

    @NonNull
    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(@NonNull long questionId) {
        this.questionId = questionId;
    }

}
