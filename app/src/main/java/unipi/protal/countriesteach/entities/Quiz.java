package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "quiz")
public class Quiz {
    @PrimaryKey(autoGenerate = true)
    Integer quizId = 0;
    @ColumnInfo
    Long startDateMillis;
    @ColumnInfo
    Long endDateMillis;
    @ColumnInfo
    Integer score;
    @ColumnInfo
    List<Questions> questionsList;
}
