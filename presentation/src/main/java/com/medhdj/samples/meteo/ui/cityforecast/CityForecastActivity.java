package com.medhdj.samples.meteo.ui.cityforecast;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.medhdj.samples.meteo.R;
import com.medhdj.samples.meteo.model.ForecastVM;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityForecastActivity extends AppCompatActivity implements CityForecastView {

    @BindView(R.id.forecast_container)
    RelativeLayout forecastContainer;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.error)
    TextView errorTv;

    @BindView(R.id.city_name)
    TextView cityName;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.temperature_icon)
    ImageView tempIcon;
    @BindView(R.id.temperature)
    TextView temperature;
    @BindView(R.id.label)
    TextView label;

    CityForecastPresenter cityForecastPresenter = new CityForecastPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_forecast);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        cityForecastPresenter.setView(this);
        cityForecastPresenter.create();
    }


    @Override
    protected void onDestroy() {
        cityForecastPresenter.destroy();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        forecastContainer.setVisibility(View.GONE);
        errorTv.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        errorTv.setText(message);

        progress.setVisibility(View.GONE);
        forecastContainer.setVisibility(View.GONE);
        errorTv.setVisibility(View.VISIBLE);

    }

    @Override
    public Context context() {
        return this.getApplicationContext();
    }

    @Override
    public void renderForecast(ForecastVM forecastVM) {
        cityName.setText(forecastVM.getCityName());
        date.setText(forecastVM.getForecastDate());
        Picasso.with(context())
                .load(forecastVM.getWeatherIcon())
                .into(tempIcon);
        temperature.setText(forecastVM.getTemperature());
        label.setText(forecastVM.getWeatherLabel());

        forecastContainer.setVisibility(View.VISIBLE);
    }
}
