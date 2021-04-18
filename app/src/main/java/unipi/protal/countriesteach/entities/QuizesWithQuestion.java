package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class QuizesWithQuestion {
    @Embedded
    public Question question;
    @Relation(
            parentColumn = "questionId",
            entityColumn = "quizId",
            associateBy = @Junction(QuestionQuizCrossRef.class)
    )
    public List<Quiz> quizList;
}
