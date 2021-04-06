package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Country {
    @PrimaryKey(autoGenerate = true)
    Integer countryId = 0;
    @ColumnInfo
    String countryName;
    @ColumnInfo
    Integer flagId;
    @ColumnInfo
    Integer coatOfArmsId;
    @ColumnInfo
    Integer continentId;
}
