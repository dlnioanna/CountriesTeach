package unipi.protal.countriesteach.screens.game;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.databinding.GameFragmentBinding;
import unipi.protal.countriesteach.entities.Country;

public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    GameFragmentBinding binding;
    Country country;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.game_fragment, container, false);
        View view = binding.getRoot();
        int cointinentId = GameFragmentArgs.fromBundle(getArguments()).getContinentId();
        Resources resources = this.getContext().getResources();
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        gameViewModel.getRandomCountry().observe(getViewLifecycleOwner(), country->{binding.questionText.setText(country.getCountryName());
        binding.flagImage.setImageResource(resources.getIdentifier("ic_"+country.getCountryName()+"_flag", "drawable",
                this.getContext().getPackageName()));});
        gameViewModel.getRandomCountry().observe(getViewLifecycleOwner(), country->{binding.questionText.setText(country.getCountryName());});
//        gameViewModel.getAllCountries().observe(getViewLifecycleOwner(), country->{binding.questionText.setText(country.get(0).getCountryName());});
        //String s = String.valueOf(cointinentId);
        String s = String.valueOf(cointinentId);
       // binding.questionText.setText(s);



        return binding.getRoot();
    }
}
