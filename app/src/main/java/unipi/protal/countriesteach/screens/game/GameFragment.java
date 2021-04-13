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
import unipi.protal.countriesteach.database.Database;
import unipi.protal.countriesteach.databinding.GameFragmentBinding;
import unipi.protal.countriesteach.entities.Country;

public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    private GameFragmentBinding binding;
    private Country country;
    private int countryIndex, firstAnswerIndex, secondAnswerIndex, thirdAnswerIndex, fourthAnswerIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.game_fragment, container, false);
        View view = binding.getRoot();
        int cointinentId = GameFragmentArgs.fromBundle(getArguments()).getContinentId();

        Resources resources = this.getContext().getResources();

        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);

        gameViewModel.countryIndex.observe(getViewLifecycleOwner(), integer -> {
            countryIndex = gameViewModel.countryIndex.getValue();
            firstAnswerIndex = gameViewModel.firstAnswerIndex.getValue();
            secondAnswerIndex = gameViewModel.secondAnswerIndex.getValue();
            thirdAnswerIndex = gameViewModel.thirdAnswerIndex.getValue();
            fourthAnswerIndex = gameViewModel.fourthAnswerIndex.getValue();
        });
        gameViewModel.getAllCountries().observe(getViewLifecycleOwner(), countries -> {
            binding.questionText.setText(gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryName());
            binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId(), "drawable",
                    this.getContext().getPackageName()));
            binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryName());
            binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryName());
            binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryName());
            binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryName());
        });

        // todo τα 4 κουμπιά παίρνουν το σωστό όνομα και τα τυχαίες χώρες
        binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameViewModel.nextCountryIndex();
                binding.questionText.setText(gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryName());
                binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId(), "drawable",
                        getContext().getPackageName()));
                binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryName());
                binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryName());
                binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryName());
                binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryName());
            }
        });
        return binding.getRoot();
    }
}
