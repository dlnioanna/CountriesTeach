package unipi.protal.countriesteach.screens.gameEnd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import unipi.protal.countriesteach.databinding.*;
import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.screens.game.GameViewModel;
import unipi.protal.countriesteach.screens.game.GameViewModelFactory;


public class GameEndFragment extends Fragment {
    private NavController navController;
    private GameEndFragmentBinding binding;
    private GameEndViewModelFactory gameEndViewModelFactory;
    private GameEndViewModel gameEndViewModel;
    private Long quizId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.game_end_fragment, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        binding.setLifecycleOwner(this);
        quizId = GameEndFragmentArgs.fromBundle(getArguments()).getQuizId();
        Toast.makeText(this.getContext(), "quiz id " + quizId, Toast.LENGTH_SHORT).show();
        gameEndViewModelFactory = new GameEndViewModelFactory(getActivity().getApplication(), quizId);
        gameEndViewModel = new ViewModelProvider(this, gameEndViewModelFactory).get(GameEndViewModel.class);


        binding.startNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(GameEndFragmentDirections.actionGameEndToTitleFragment());

            }
        });
        binding.exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return binding.getRoot();
    }

}