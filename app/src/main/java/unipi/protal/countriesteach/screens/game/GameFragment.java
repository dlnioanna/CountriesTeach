package unipi.protal.countriesteach.screens.game;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;
import java.util.List;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.database.CountryContentValues;
import unipi.protal.countriesteach.databinding.GameFragmentBinding;
import unipi.protal.countriesteach.entities.Country;
import unipi.protal.countriesteach.entities.Question;


import static unipi.protal.countriesteach.database.CountryContentValues.AFRICA;
import static unipi.protal.countriesteach.database.CountryContentValues.AMERICA;
import static unipi.protal.countriesteach.database.CountryContentValues.ASIA;
import static unipi.protal.countriesteach.database.CountryContentValues.EUROPE;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_AFRICAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_ALL_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_AMERICAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_ASIAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_EUROPEAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.NUMBER_OF_OCEANIAN_COUNTRIES;
import static unipi.protal.countriesteach.database.CountryContentValues.OCEANIA;
import static unipi.protal.countriesteach.database.CountryContentValues.WORLD;

public class GameFragment extends Fragment implements View.OnClickListener {
    private GameViewModel gameViewModel;
    private GameViewModelFactory gameViewModelFactory;
    private GameFragmentBinding binding;
    private Country country;
    private int countryIndex, firstAnswerIndex, secondAnswerIndex, thirdAnswerIndex, fourthAnswerIndex, currentLevel, nextLevel;
    private int continentId, numberOfQuestion, quizScore;
    private NavController navController;
    private List<Country> allCountries;
    private List<Question> quizQuestions;
    public static final int NUMBER_OF_QUESTIONS = 10;
    private Long quizId;
    private MediaPlayer mp;
    private int startTime = 0, finalTime = 0, sTime = 0;
    private String correctAnswer = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.game_fragment, container, false);
        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.setLifecycleOwner(this);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Resources resources = this.getContext().getResources();
        continentId = GameFragmentArgs.fromBundle(getArguments()).getContinentId();
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(getContext(), R.drawable.button_next);
        quizScore = 0;
        if (continentId == EUROPE) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_europe);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_europe);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_europe);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_europe);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_europe_dark));
        } else if (continentId == CountryContentValues.AMERICA) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_america);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_america);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_america);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_america);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_america_dark));
        } else if (continentId == CountryContentValues.ASIA) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_asia);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_asia);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_asia);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_asia);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_asia_dark));
        } else if (continentId == CountryContentValues.AFRICA) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_africa);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_africa);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_africa);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_africa);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_africa_dark));
        } else if (continentId == CountryContentValues.OCEANIA) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_oceania);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_oceania);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_oceania);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_oceania);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_oceania_dark));
        } else if (continentId == CountryContentValues.WORLD) {
            binding.firstAnswerRadioButton.setBackgroundResource(R.drawable.button_all_continents);
            binding.secondAnswerRadioButton.setBackgroundResource(R.drawable.button_all_continents);
            binding.thirdAnswerRadioButton.setBackgroundResource(R.drawable.button_all_continents);
            binding.fourthAnswerRadioButton.setBackgroundResource(R.drawable.button_all_continents);
            unwrappedDrawable.setTint(resources.getColor(R.color.color_wolrd_dark));
        }
        binding.skipButton.setBackground(unwrappedDrawable);
        gameViewModelFactory = new GameViewModelFactory(getActivity().getApplication(), continentId);
        gameViewModel = new ViewModelProvider(this, gameViewModelFactory).get(GameViewModel.class);
        gameViewModel.getAllCountries().observe(getViewLifecycleOwner(), countries -> {
            allCountries = new ArrayList<>(gameViewModel.getAllCountries().getValue());
            if (!(allCountries.size() < NUMBER_OF_ALL_COUNTRIES) && (gameViewModel.countryIndex.getValue() != null) && (gameViewModel.currentLevel.getValue() != null)) {
                if (currentLevel == 1) {
                    try {
                        binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.countryIndex.getValue(), "drawable",
                                this.getContext().getPackageName()));
                        binding.flagImage.setVisibility(View.VISIBLE);
                        binding.emblemImage.setVisibility(View.GONE);
                        binding.seekBar.setVisibility(View.GONE);
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (currentLevel == 2) {
                    try {
                        binding.emblemImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.countryIndex.getValue() + "_1", "drawable",
                                this.getContext().getPackageName()));
                        binding.flagImage.setVisibility(View.GONE);
                        binding.emblemImage.setVisibility(View.VISIBLE);
                        binding.seekBar.setVisibility(View.GONE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (currentLevel == 3) {
                    binding.flagImage.setVisibility(View.GONE);
                    binding.emblemImage.setVisibility(View.GONE);
                    binding.seekBar.setVisibility(View.VISIBLE);
                    binding.seekBar.setClickable(false);
                    String url = "anthem_" + gameViewModel.countryIndex.getValue();
                    Integer resIdSound = resources.getIdentifier(url, "raw", this.getContext().getPackageName());
                    mp = MediaPlayer.create(this.getContext(), resIdSound);
                    finalTime = mp.getDuration() / 1000;
                    sTime = mp.getCurrentPosition() / 1000;
                    binding.seekBar.setMax(finalTime);
                    binding.seekBar.setProgress(sTime, true);
                    binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {
                        }

                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                            if (mp != null && fromUser) {
                                mp.seekTo(progress * 1000);
                                Log.e("progress", String.valueOf(progress));
                            }
                        }
                    });
                    try {
                        if (mp.isPlaying()) {
                            mp.stop();
                            mp.release();
                            mp = MediaPlayer.create(this.getContext(), resIdSound);
                        }
                        mp.start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Log.e("country is ", gameViewModel.countryIndex.getValue().toString());
                Log.e("country is ", gameViewModel.getAllCountries().getValue().get(countryIndex - 1).getCountryName());
                correctAnswer = gameViewModel.getAllCountries().getValue().get(countryIndex - 1).getCountryName();
                binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(gameViewModel.firstAnswerIndex.getValue() - 1).getCountryName());
                binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(gameViewModel.secondAnswerIndex.getValue() - 1).getCountryName());
                binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(gameViewModel.thirdAnswerIndex.getValue() - 1).getCountryName());
                binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(gameViewModel.fourthAnswerIndex.getValue() - 1).getCountryName());
                binding.firstAnswerRadioButton.setOnClickListener(this);
                binding.secondAnswerRadioButton.setOnClickListener(this);
                binding.thirdAnswerRadioButton.setOnClickListener(this);
                binding.fourthAnswerRadioButton.setOnClickListener(this);
            }
        });
        gameViewModel.getQuizQuestions().observe(getViewLifecycleOwner(), questions -> {
            quizQuestions = new ArrayList(gameViewModel.getQuizQuestions().getValue());
            binding.questionText.setText(gameViewModel.numberOfQuestion.getValue() + getString(R.string.number_of_question));
        });
        gameViewModel.numberOfQuestion.observe(getViewLifecycleOwner(), integer -> {
            numberOfQuestion = gameViewModel.numberOfQuestion.getValue();
            if (numberOfQuestion > NUMBER_OF_QUESTIONS) {
                gameViewModel.endQuiz(quizScore, continentId, currentLevel);
                navController.navigate(GameFragmentDirections.actionGameFragmentToGameEnd().setQuizId(gameViewModel.getQuizId().getValue()));
            }
        });
        gameViewModel._quizId.observe(getViewLifecycleOwner(), lng -> {
            quizId = gameViewModel._quizId.getValue();
        });
        gameViewModel.countryIndex.observe(getViewLifecycleOwner(), integer -> {
            countryIndex = gameViewModel.countryIndex.getValue();
        });
        gameViewModel.currentLevel.observe(getViewLifecycleOwner(), integer -> {
            currentLevel = gameViewModel.currentLevel.getValue();
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

        binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), false, 0);
                try {
                    mp.stop();
                    mp.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nextQuestion();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (v == binding.firstAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Σωστό!", Toast.LENGTH_SHORT).show();
                quizScore++;
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), true, gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryId());
            } else {
                Toast.makeText(getContext(), "Λάθος. Η σωστή απάντηση είναι " + correctAnswer, Toast.LENGTH_SHORT).show();
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), false, gameViewModel.getAllCountries().getValue().get(firstAnswerIndex).getCountryId());
            }
        } else if (v == binding.secondAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Σωστό!", Toast.LENGTH_SHORT).show();
                quizScore++;
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), true, gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryId());
            } else {
                Toast.makeText(getContext(), "Λάθος. Η σωστή απάντηση είναι " + correctAnswer, Toast.LENGTH_SHORT).show();
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), false, gameViewModel.getAllCountries().getValue().get(secondAnswerIndex).getCountryId());
            }
        } else if (v == binding.thirdAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Σωστό!", Toast.LENGTH_SHORT).show();
                quizScore++;
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), true, gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryId());
            } else {
                Toast.makeText(getContext(), "Λάθος. Η σωστή απάντηση είναι " + correctAnswer, Toast.LENGTH_SHORT).show();
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), false, gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex).getCountryId());
            }
        } else if (v == binding.fourthAnswerRadioButton) {
            if (gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryId() == gameViewModel.getAllCountries().getValue().get(countryIndex).getCountryId()) {
                Toast.makeText(getContext(), "Σωστό!", Toast.LENGTH_SHORT).show();
                quizScore++;
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), true, gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryId());
            } else {
                Toast.makeText(getContext(), "Λάθος. Η σωστή απάντηση είναι " + correctAnswer, Toast.LENGTH_SHORT).show();
                gameViewModel.saveAnswer(gameViewModel.countryIndex.getValue(), false, gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex).getCountryId());
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(this::nextQuestion, 1500);
    }

    private void nextQuestion() {
        gameViewModel.numberOfQuestion.setValue(numberOfQuestion + 1);
        Resources resources = this.getContext().getResources();
        gameViewModel.nextCountryIndex();
        correctAnswer = gameViewModel.getAllCountries().getValue().get(countryIndex - 1).getCountryName();
        if (gameViewModel.numberOfQuestion.getValue() <= NUMBER_OF_QUESTIONS) {
            binding.questionText.setText(gameViewModel.numberOfQuestion.getValue() + getString(R.string.number_of_question));

            if (currentLevel == 1) {
                try {
                    binding.flagImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.countryIndex.getValue(), "drawable",
                            this.getContext().getPackageName()));
                    binding.flagImage.setVisibility(View.VISIBLE);
                    binding.emblemImage.setVisibility(View.GONE);
                    try {
                        if (mp.isPlaying()) {
                            mp.stop();
                            mp.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (currentLevel == 2) {
                try {
                    binding.emblemImage.setImageResource(resources.getIdentifier("ic_" + gameViewModel.countryIndex.getValue() + "_1", "drawable",
                            this.getContext().getPackageName()));
                    binding.flagImage.setVisibility(View.GONE);
                    binding.emblemImage.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (currentLevel == 3) {
                String url = "anthem_" + gameViewModel.countryIndex.getValue();
                Integer resIdSound = resources.getIdentifier(url, "raw", this.getContext().getPackageName());
                mp = MediaPlayer.create(this.getContext(), resIdSound);
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(this.getContext(), resIdSound);
                    }
                    mp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Log.e("country is ", gameViewModel.countryIndex.getValue().toString());
            Log.e("country is ", gameViewModel.getAllCountries().getValue().get(countryIndex - 1).getCountryName());
            binding.firstAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(firstAnswerIndex - 1).getCountryName());
            binding.secondAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(secondAnswerIndex - 1).getCountryName());
            binding.thirdAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(thirdAnswerIndex - 1).getCountryName());
            binding.fourthAnswerRadioButton.setText(gameViewModel.getAllCountries().getValue().get(fourthAnswerIndex - 1).getCountryName());
        }
    }

    private int getnumberOfCountires(int id) {
        int num = 0;
        if (id == EUROPE) {
            num = NUMBER_OF_EUROPEAN_COUNTRIES;
        } else if (id == AMERICA) {
            num = NUMBER_OF_AMERICAN_COUNTRIES;
        } else if (id == AFRICA) {
            num = NUMBER_OF_AFRICAN_COUNTRIES;
        } else if (id == ASIA) {
            num = NUMBER_OF_ASIAN_COUNTRIES;
        } else if (id == OCEANIA) {
            num = NUMBER_OF_OCEANIAN_COUNTRIES;
        } else if (id == WORLD) {
            num = NUMBER_OF_ALL_COUNTRIES;
        }
        return num;
    }

    @Override
    public void onStop() {
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onStop();
    }

}
