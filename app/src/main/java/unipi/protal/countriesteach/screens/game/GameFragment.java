package unipi.protal.countriesteach.screens.game;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class GameFragment extends Fragment implements View.OnClickListener {
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
        });
        gameViewModel.firstAnswerIndex.observe(getViewLifecycleOwner(), integer -> {
            firstAnswerIndex = gameViewModel.firstAnswerIndex.getValue();
        });
        gameViewModel.secondAnswerIndex.observe(getViewLifecycleOwner(), integer -> {
            secondAnswerIndex = gameViewModel.secondAnswerIndex.getValue();
        });
        gameViewModel.thirdAnswerIndex.observe(getViewLifecycleOwner(), integer -> {
            thirdAnswerIndex = gameViewModel.thirdAnswerIndex.getValue();
        });
        gameViewModel.fourthAnswerIndex.observe(getViewLifecycleOwner(), integer -> {
            fourthAnswerIndex = gameViewModel.fourthAnswerIndex.getValue();
        });
        gameViewModel.getAllCountries().observe(getViewLifecycleOwner(), countries -> {
            binding.questionText.setText(gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryName());
            binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId(), "drawable",
                    this.getContext().getPackageName()));
            binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryName());
            binding.firstAnswerRadioButton.setOnClickListener(this::onClick);
            binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryName());
            binding.secondAnswerRadioButton.setOnClickListener(this::onClick);
            binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryName());
            binding.thirdAnswerRadioButton.setOnClickListener(this::onClick);
            binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryName());
            binding.fourthAnswerRadioButton.setOnClickListener(this::onClick);
        });

        // todo τα 4 κουμπιά παίρνουν το σωστό όνομα και τα τυχαίες χώρες
        binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        if (v == binding.firstAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Correct answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
            }
        } else if (v == binding.secondAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Correct answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
            }
        } else if (v == binding.thirdAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Correct answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
            }
        } else if (v == binding.fourthAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Correct answer", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Wrong answer", Toast.LENGTH_SHORT).show();
            }
        }
        nextQuestion();
    }

    private void nextQuestion() {
        Resources resources = this.getContext().getResources();
        gameViewModel.nextCountryIndex();
        binding.questionText.setText(gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryName());
        binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId(), "drawable",
                getContext().getPackageName()));
        binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryName());
        binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryName());
        binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryName());
        binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryName());
    }
}
