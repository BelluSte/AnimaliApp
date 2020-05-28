package belluste.animali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Animale> elenco;
    private ListView elencoAnimali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elenco = new ArrayList<>();
        elenco.add(new Animale("Asino", R.drawable.asino, R.raw.asino));
        elenco.add(new Animale("Cane", R.drawable.cane, R.raw.cane));
        elenco.add(new Animale("Cavallo", R.drawable.cavallo, R.raw.cavallo));
        elenco.add(new Animale("Elefante", R.drawable.elefante, R.raw.elefante));
        elenco.add(new Animale("Gallo", R.drawable.gallo, R.raw.gallo));
        elenco.add(new Animale("Leone", R.drawable.leone, R.raw.leone));
        elenco.add(new Animale("Maiale", R.drawable.maiale, R.raw.maiale));

        elencoAnimali = findViewById(R.id.elenco);

        Adapter adapter = new Adapter(getApplicationContext(), elenco);
        elencoAnimali.setAdapter(adapter);

        elencoAnimali.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent item = new Intent(MainActivity.this, AnimalScreen.class);
                item.putExtra("img", elenco.get(position).getImmagine());
                item.putExtra("verso", elenco.get(position).getVerso());
                startActivity(item);
            }
        });
    }
}
