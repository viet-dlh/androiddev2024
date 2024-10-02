package vn.edu.usth.weather;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.os.Handler;
import android.os.Looper;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new Handler(Looper.getMainLooper());
        getSupportActionBar().setTitle("Weather App");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            simulateNetworkRequest();
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
    }

    private void simulateNetworkRequest() {
        Toast.makeText(this,"Refreshing...",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Handler handler = null;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"Refresh complete!!!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
    }

    private void simulateNetworkRequest() {
        Toast.makeText(this,"Refreshing...",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"Refresh complete!!!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
    }
