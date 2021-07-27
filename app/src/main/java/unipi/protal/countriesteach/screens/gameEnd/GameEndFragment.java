package unipi.protal.countriesteach.screens.gameEnd;

import android.media.MediaPlayer;
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

import java.util.ArrayList;

import unipi.protal.countriesteach.databinding.*;
import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.screens.game.GameViewModel;
import unipi.protal.countriesteach.screens.game.GameViewModelFactory;


public class GameEndFragment extends Fragment {
    private NavController navController;
    private GameEndFragmentBinding binding;
    private GameEndViewModelFactory gameEndViewModelFactory;
    private GameEndViewModel gameEndViewModel;
    private Long quizId, startTime, endTime;
    private Integer quizScore;
    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.game_end_fragment, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        binding.setLifecycleOwner(this);
        quizId = GameEndFragmentArgs.fromBundle(getArguments()).getQuizId();
        gameEndViewModelFactory = new GameEndViewModelFactory(getActivity().getApplication(), quizId);
        gameEndViewModel = new ViewModelProvider(this, gameEndViewModelFactory).get(GameEndViewModel.class);

        gameEndViewModel.getQuizScore().observe(getViewLifecycleOwner(), score -> {
            quizScore = gameEndViewModel.getQuizScore().getValue();
            binding.gameScore.setText(getString(R.string.user_score)+" "+quizScore);
        });
        gameEndViewModel.getQuizStartTime().observe(getViewLifecycleOwner(), score -> {
            startTime = gameEndViewModel.getQuizStartTime().getValue();
            if(startTime!=null && endTime!=null){
                binding.gameDuration.setText(getString(R.string.quiz_time)+" "+getDuration(startTime,endTime));
            }
        });
        gameEndViewModel.getQuizEndTime().observe(getViewLifecycleOwner(), score -> {
            endTime = gameEndViewModel.getQuizEndTime().getValue();
            if(startTime!=null && endTime!=null){
                binding.gameDuration.setText(getString(R.string.quiz_time)+" "+getDuration(startTime,endTime));
            }
        });
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


    private String getDuration(Long start, Long end){
        String result="";
        Long diff = (end-start)/1000;
        if(diff>=60){
            result = String.valueOf(diff/60)+" min ";
        }else {
            result = String.valueOf(diff)+" sec ";
        }
        return result;
    }

}