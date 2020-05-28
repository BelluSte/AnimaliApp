package belluste.animali;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AnimalScreen extends AppCompatActivity {

    SoundPool verso;
    int versoID;
    int soundID;
    int fotoID;
    ImageView foto;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_screen);

        AudioAttributes attributi = new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).setUsage(AudioAttributes.USAGE_GAME).build();
        verso = new SoundPool.Builder().setAudioAttributes(attributi).setMaxStreams(1).build();

        versoID = getIntent().getExtras().getInt("verso");

        soundID = verso.load(getApplicationContext(), versoID, 1);

        foto = findViewById(R.id.ivFoto);
        fotoID = getIntent().getExtras().getInt("img");
        Drawable f = getDrawable(fotoID);
        foto.setImageDrawable(f);
    }

    public void playVerso(View view) {
        verso.play(soundID, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
