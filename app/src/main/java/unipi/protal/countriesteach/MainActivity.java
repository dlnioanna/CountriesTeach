package unipi.protal.countriesteach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import unipi.protal.countriesteach.genetic.exceptions.GeneticAlgorithmException;
import unipi.protal.countriesteach.genetic.service.GeneticAlgorithmService;
import unipi.protal.countriesteach.utils.NumberUtils;

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return super.onSupportNavigateUp();
    }

}