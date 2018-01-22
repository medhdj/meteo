package com.medhdj.samples.meteo.ui.cityforecast;

import com.medhdj.samples.meteo.contract.LoadingView;
import com.medhdj.samples.meteo.model.ForecastVM;

/**
 * Created by medhdj on 22/01/2018.
 */

public interface CityForecastView extends LoadingView {

    void renderForecast(ForecastVM forecastVM);
}
