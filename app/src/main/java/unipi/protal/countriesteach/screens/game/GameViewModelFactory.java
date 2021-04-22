package unipi.protal.countriesteach.screens.game;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class GameViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private int continentId;

    public GameViewModelFactory(Application app,int id){
        application=app;
        continentId=id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GameViewModel(application, continentId);
    }
}
