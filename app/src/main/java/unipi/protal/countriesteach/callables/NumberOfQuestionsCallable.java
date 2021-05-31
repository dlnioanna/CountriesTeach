package unipi.protal.countriesteach.callables;

import android.util.Log;

import java.util.concurrent.Callable;

import unipi.protal.countriesteach.database.QuestionDao;

public class NumberOfQuestionsCallable implements Callable<Integer> {
    private QuestionDao questionDao;

    public NumberOfQuestionsCallable(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @Override
    public Integer call() throws Exception {
        Integer result = questionDao.countTotalNumberOfQuestions();
        return result;
    }
}
