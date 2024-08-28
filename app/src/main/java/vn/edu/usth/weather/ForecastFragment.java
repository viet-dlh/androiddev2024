package vn.edu.usth.weather;

import android.os.Bundle;
import android.graphics.Color;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        view.setBackgroundColor(Color.parseColor("#20FF0000"));
        return view;
    }
}