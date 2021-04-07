package unipi.protal.countriesteach.database;

import android.content.ContentValues;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import unipi.protal.countriesteach.entities.Country;
//   https://androtak.wordpress.com/2016/03/01/how-to-convert-any-object-to-contentvalues-in-for-android-sqlite-insertion/

public class CountryContentValues {
//    HashMap<String, Object> map = new HashMap<>();
//    for ( Field field : Country.getClass().getDeclaredFields()) {
//        try {
//            map.put(field.getName(), field.get(t));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//    ContentValues contentValues = new ContentValues();
//    for (Map.Entry<String> entry : map.entrySet()) {
//        System.out.println("Key+ entry.getKey() + ", Value = " + entry.getValue());
//        if (entry.getValue() instanceof Integer) {
//            contentValues1.put(entry.getKey(), (Integer) entry.getValue());
//        } else {
//            contentValues1.put(entry.getKey(), (((String) entry.getValue() == null) ? "" : (String) entry.getValue()));
//        }
//    }
//    getReadableDatabase().insert(t.getClass().getSimpleName(), null, contentValues1);
}
