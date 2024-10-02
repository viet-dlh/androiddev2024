package vn.edu.usth.weather;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weather";
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 1;
    private ViewPager2 viewpager2;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        viewpager2 = findViewById(R.id.vp1);
        tabLayout = findViewById(R.id.tabLayout);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Paris");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Tokyo");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"London");
        viewpager2.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewpager2, (tab, position) -> {
            tab.setText(viewPagerAdapter.getTitle(position));
        }).attach();
        Log.i(TAG, "ON_CREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "ON_START");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "ON_RESUME");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "ON_PAUSE");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "ON_STOP");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ON_DESTROY");
    }
    private void extractAndPlayMusic() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = getResources().openRawResource(R.raw.m);
            File musicFile = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), "m.mp3");
            
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            outputStream.flush();

            // Play the music file
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(musicFile.getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this, "Music is playing", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Log.e(TAG, "Error playing music: " + e.getMessage());
            Toast.makeText(this, "Error playing music", Toast.LENGTH_SHORT).show();
        } finally {
            // Close streams safely
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                Log.e(TAG, "Error closing streams: " + e.getMessage());
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_WRITE_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                extractAndPlayMusic();
            } else {
                Toast.makeText(this, "Permission denied to write to external storage", Toast.LENGTH_SHORT).show();
            }
        }
}}
