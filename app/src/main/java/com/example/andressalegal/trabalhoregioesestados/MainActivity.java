package com.example.andressalegal.trabalhoregioesestados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvRegioes;
    private TextView tvEstados;
    private LinearLayout layout;
    private String regiaoEstados [][];
    private int contRegiao = 0, contEstados = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regiaoEstados = new String[9][5];
        layout = (LinearLayout) findViewById(R.id.layout);
        tvRegioes = (TextView) findViewById(R.id.tvRegioes);
        tvEstados = (TextView) findViewById(R.id.tvEstados);

        final String regiaoEstados[][] = {
                {"Nordeste", "Maranhão", "Piauí", "Ceará ", "Rio Grande do Norte", "Pernambuco ", "Paraíba", "Sergipe ", "Alagoas ", "Bahia"},
                {"Sudeste", "São Paulo ", "Rio de Janeiro", "Espírito Santo", "Minas Gerais"},
                {"Região Norte", "Amazonas", "Roraima", "Amapá", "Pará ", "Tocantins ", "Rondônia ", "Acre "},
                {"Centro-Oeste", "Mato Grosso", "Mato Grosso do Sul", "Goiás"},
                {"Sul", "Paraná", "Rio Grande do Sul", "Santa Catarina"}};


        layout.setOnTouchListener(new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if (contEstados >= 2) {
                    contEstados--;
                    tvRegioes.setText(regiaoEstados[contRegiao][0]);
                    tvEstados.setText(regiaoEstados[contRegiao][contEstados]);
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (contEstados < regiaoEstados[contRegiao].length) {
                    contEstados++;
                    tvRegioes.setText(regiaoEstados[contRegiao][0]);
                    tvEstados.setText(regiaoEstados[contRegiao][contEstados]);
                }
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                if (contRegiao >= 2) {
                    contRegiao--;
                    contEstados = 1;
                    tvRegioes.setText(regiaoEstados[contRegiao][0]);
                    tvEstados.setText(regiaoEstados[contRegiao][contEstados]);
                }
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                if (contRegiao <=3){
                    contRegiao++;
                    contEstados = 1;
                    tvRegioes.setText(regiaoEstados[contRegiao][0]);
                    tvEstados.setText(regiaoEstados[contRegiao][contEstados]);
                }
            }
        });
    }
}
