package com.msaggik.secondlessonsportsscoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // поля
    private TextView score; // табло бля вывода счёта игры
    private Button lionsTeam, panthersTeam; // кнопки команд
    private int countLions = 0, countPanthers = 0; // счётчики счёта команд
    final String LOG_TAG = "myLogs";
    // создание активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Создание активности", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            countLions = savedInstanceState.getInt("countLions");
            countPanthers = savedInstanceState.getInt("countPanthers");
        }
        // привязка разметки к полям
        score = findViewById(R.id.score);
        lionsTeam = findViewById(R.id.lionsTeam);
        panthersTeam = findViewById(R.id.panthersTeam);

        // обработка нажатия кнопок
        lionsTeam.setOnClickListener(listener);
        panthersTeam.setOnClickListener(listener);
        score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));

    }



    // запуск активности
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Запуск активности", Toast.LENGTH_SHORT).show();

    }

    // открытие взаимодействия с активностью
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Открытие взаимодействия с активностью", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("countLions", countLions);
        savedInstanceState.putInt("countPanthers", countPanthers);
    }


    // отзыв взаимодействия с активностью
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Отзыв взаимодействия с активностью", Toast.LENGTH_SHORT).show();

    }


    // скрытие активности
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Скрытие активности", Toast.LENGTH_SHORT).show();

    }

    // уничтожение активности
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Уничтожение активности", Toast.LENGTH_SHORT).show();

    }



    // определение слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // обработка счётчиков
            switch (view.getId()) {
                case R.id.lionsTeam:
                    countLions++;
                    break;
                case R.id.panthersTeam:
                    countPanthers++;
                    break;
            }
            // вывод данных на экран смартфона
            score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
        }
    };
}