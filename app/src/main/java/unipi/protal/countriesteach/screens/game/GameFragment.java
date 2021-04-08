package unipi.protal.countriesteach.screens.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.databinding.GameFragmentBinding;

public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        GameFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.game_fragment, container, false);
        View view = binding.getRoot();
        int cointinentId=GameFragmentArgs.fromBundle(getArguments()).getContinentId();

        gameViewModel = new GameViewModel(getActivity().getApplication());

        String s = String.valueOf(cointinentId);
       binding.questionText.setText(s);
       binding.flagImage.setImageResource(R.drawable.ic_andorra_flag);
        return binding.getRoot();
    }
}
