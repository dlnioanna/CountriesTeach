package unipi.protal.countriesteach.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "country")
public class Country {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    private Integer countryId = 0;
    @ColumnInfo
    private String countryName;
    @ColumnInfo
    private String flagId;
    @ColumnInfo
    private String coatOfArmsId;
    @ColumnInfo
    private Integer continentId;

    public Country(String countryName, String flagId, String coatOfArmsId, Integer continentId) {
        this.countryName = countryName;
        this.flagId = flagId;
        this.coatOfArmsId = coatOfArmsId;
        this.continentId = continentId;
    }

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

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }

    public String getCoatOfArmsId() {
        return coatOfArmsId;
    }

    public void setCoatOfArmsId(String coatOfArmsId) {
        this.coatOfArmsId = coatOfArmsId;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
