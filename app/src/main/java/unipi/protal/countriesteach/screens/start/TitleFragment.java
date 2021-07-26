package unipi.protal.countriesteach.screens.start;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import static androidx.navigation.Navigation.findNavController;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.database.CountryContentValues;
import unipi.protal.countriesteach.databinding.TitleFragmentBinding;
import unipi.protal.countriesteach.screens.start.TitleFragmentDirections;

public class TitleFragment extends Fragment {
    private TitleViewModel titleViewModel;
    private static final int NEXT_LEVEL = 4;
    private Integer europeanDifficultyLevel, asianDifficultyLevel, americanDifficultyLevel, africanDifficultyLevel, oceanianDifficultyLevel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TitleFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.title_fragment, container, false);
        View view = binding.getRoot();
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Resources resources = this.getContext().getResources();
        titleViewModel = new ViewModelProvider(this).get(TitleViewModel.class);
        titleViewModel.europeanDifficultyLevel.observe(getViewLifecycleOwner(), integer -> {
            europeanDifficultyLevel = titleViewModel.europeanDifficultyLevel.getValue();
            if(europeanDifficultyLevel!=null) {
                if (europeanDifficultyLevel == NEXT_LEVEL) {
                    binding.asiaButton.setEnabled(true);
                    binding.asiaButton.setTextColor(resources.getColor(R.color.white));
                } else {
                    binding.asiaButton.setEnabled(false);
                    binding.asiaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                }
            }
        });
        titleViewModel.asianDifficultyLevel.observe(getViewLifecycleOwner(), integer -> {
            asianDifficultyLevel = titleViewModel.asianDifficultyLevel.getValue();
            if(africanDifficultyLevel!=null) {
                if (asianDifficultyLevel == NEXT_LEVEL) {
                    binding.americaButton.setEnabled(true);
                    binding.americaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                } else {
                    binding.americaButton.setEnabled(false);
                    binding.americaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                }
            }
        });
        titleViewModel.americanDifficultyLevel.observe(getViewLifecycleOwner(), integer -> {
            americanDifficultyLevel = titleViewModel.americanDifficultyLevel.getValue();
            if(americanDifficultyLevel!=null) {
                if (americanDifficultyLevel == NEXT_LEVEL) {
                    binding.africaButton.setEnabled(true);
                    binding.africaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                } else {
                    binding.africaButton.setEnabled(false);
                    binding.africaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                }
            }
        });
        titleViewModel.africanDifficultyLevel.observe(getViewLifecycleOwner(), integer -> {
            if(africanDifficultyLevel!=null) {
                africanDifficultyLevel = titleViewModel.africanDifficultyLevel.getValue();
                if (africanDifficultyLevel == NEXT_LEVEL) {
                    binding.oceaniaButton.setEnabled(true);
                    binding.oceaniaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                } else {
                    binding.oceaniaButton.setEnabled(false);
                    binding.oceaniaButton.setTextColor(resources.getColor(R.color.grey_text_color));
                }
            }
        });
        titleViewModel.oceanianDifficultyLevel.observe(getViewLifecycleOwner(), integer -> {
            oceanianDifficultyLevel = titleViewModel.oceanianDifficultyLevel.getValue();
            if(oceanianDifficultyLevel!=null) {
                if (oceanianDifficultyLevel == NEXT_LEVEL) {
                    binding.worldButton.setEnabled(true);
                    binding.worldButton.setTextColor(resources.getColor(R.color.grey_text_color));
                } else {
                    binding.worldButton.setEnabled(false);
                    binding.worldButton.setTextColor(resources.getColor(R.color.grey_text_color));
                }
            }
        });
        // ΕΥΡΩΠΗ
        binding.europeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.EUROPE));
            }
        });
        // ΑΣΙΑ
        binding.asiaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.ASIA));
            }
        });
        // ΑΜΕΡΙΚΗ
        binding.americaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.AMERICA));
            }
        });
        //ΑΦΡΙΚΗ
        binding.africaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.AFRICA));
            }
        });
        //ΩΚΕΑΝΙΑ
        binding.oceaniaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.OCEANIA));
            }
        });
        // ΚΟΣΜΟΣ
        binding.worldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment().setContinentId(CountryContentValues.WORLD));
            }
        });
        return binding.getRoot();
    }
}
