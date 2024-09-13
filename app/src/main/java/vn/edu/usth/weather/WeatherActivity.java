package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = "Weather";
    private ViewPager2 viewpager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        viewpager2 = findViewById(R.id.vp1);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Paris");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"Tokyo");
        viewPagerAdapter.addFragment(new WeatherAndForecastFragment(),"London");
        viewpager2.setAdapter(viewPagerAdapter);

        Log.i(TAG, "ON_CREATE");
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
}