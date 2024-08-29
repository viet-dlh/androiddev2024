package vn.edu.usth.weather;

import android.os.Bundle;
import android.graphics.Color;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;

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
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        linearLayout.setBackgroundColor(Color.parseColor("#20FF0000"));
        TextView textView = new TextView(getContext());
        textView.setText("Thursday");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(24);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        textParams.gravity = Gravity.CENTER;

        linearLayout.addView(textView, textParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.cloudy);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        imageParams.gravity = Gravity.CENTER;

        linearLayout.addView(imageView, imageParams);
        return linearLayout;
    }
}