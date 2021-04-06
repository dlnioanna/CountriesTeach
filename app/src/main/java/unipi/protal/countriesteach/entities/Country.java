package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Country {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private Integer countryId = 0;
    @ColumnInfo
    private String countryName;
    @ColumnInfo
    private Integer flagId;
    @ColumnInfo
    private Integer coatOfArmsId;
    @ColumnInfo
    private Integer continentId;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    public Integer getCoatOfArmsId() {
        return coatOfArmsId;
    }

    public void setCoatOfArmsId(Integer coatOfArmsId) {
        this.coatOfArmsId = coatOfArmsId;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
