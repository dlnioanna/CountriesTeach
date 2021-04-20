package unipi.protal.countriesteach.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;
@Entity
public class QuizWithQuestions {
    @Embedded
    public Quiz quiz;
    @Relation(
            parentColumn = "quizId",
            entityColumn = "questionId",
            associateBy = @Junction(QuestionQuizCrossRef.class)
    )
    public List<Question> questions;

}
