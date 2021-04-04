package unipi.protal.countriesteach.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import static androidx.navigation.Navigation.findNavController;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.databinding.TitleFragmentBinding;

public class TitleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TitleFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.title_fragment, container, false);
        View view = binding.getRoot();
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        //here data must be an instance of the class
        binding.playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             navController.navigate(R.id.action_titleFragment_to_gameFragment);
            }
        });
        return binding.getRoot();
    }
}
