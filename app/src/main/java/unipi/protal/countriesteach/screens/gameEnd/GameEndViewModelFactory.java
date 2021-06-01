package unipi.protal.countriesteach.screens.gameEnd;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import unipi.protal.countriesteach.screens.game.GameViewModel;

public class GameEndViewModelFactory implements ViewModelProvider.Factory{
    private Application application;
    private long quizId;

    public GameEndViewModelFactory(Application app,long id){
        application=app;
        quizId=id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return  (T) new GameEndViewModel(application, quizId);
    }
}
