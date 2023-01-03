package com.pusattugasakhir;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pusattugasakhir.adapters.PesertaAdapter;
import com.pusattugasakhir.models.Peserta;

import java.util.ArrayList;

public class ListPesertaSemhasActivity extends AppCompatActivity {

    private RecyclerView rvPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_peserta_semhas);

        rvPeserta = findViewById(R.id.rv_peserta_semhas);

        PesertaAdapter adapter = new PesertaAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvPeserta.setLayoutManager(layoutManager);
        rvPeserta.setAdapter(adapter);

    }

    public ArrayList<Peserta> getPeserta(){
        ArrayList<Peserta> listPeserta = new ArrayList<>();
        listPeserta.add(new Peserta(
                null,
                "M Hafiz Aulia R",
                "2011522028",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Faiz Abdullah",
                "2011522005",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Dwiki Rahmat Fadhila",
                "2011529001",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "M Hafiz Aulia R",
                "2011522028",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Faiz Abdullah",
                "2011522005",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Dwiki Rahmat Fadhila",
                "2011529001",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "M Hafiz Aulia R",
                "2011522028",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Faiz Abdullah",
                "2011522005",
                1
        ));
        listPeserta.add(new Peserta(
                null,
                "Dwiki Rahmat Fadhila",
                "2011529001",
                1
        ));
                return listPeserta;
    }


}
