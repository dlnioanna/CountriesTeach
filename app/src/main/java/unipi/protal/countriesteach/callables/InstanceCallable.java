package unipi.protal.countriesteach.callables;

import android.content.Intent;
import android.util.Log;

import java.util.concurrent.Callable;

import unipi.protal.countriesteach.database.QuestionDao;

public class InstanceCallable implements Callable<Integer> {
    private long countryId;
    private QuestionDao questionDao;

    public InstanceCallable(long countryId, QuestionDao questionDao){
        this.countryId = countryId;
        this.questionDao = questionDao;
    }

    @Override
    public Integer call() throws Exception {
        Integer result = questionDao.countInstancesOfCountry(countryId);
        Log.e("number of instances for country ",countryId+" "+ result);
        return result;
    }
}
