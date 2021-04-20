package unipi.protal.countriesteach.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "country")
public class Country {
    @PrimaryKey
    @ColumnInfo
    private long countryId;
    @ColumnInfo
    private String countryName;
    @ColumnInfo
    private Integer continentId;

    public Country(long countryId, String countryName, Integer continentId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continentId = continentId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }
}
