package com.emse.spring.faircorp;

import com.emse.spring.faircorp.autoControlThread.AutoLightThread;
import com.emse.spring.faircorp.autoControlThread.AutoThermostatThread;
import com.emse.spring.faircorp.autoControlThread.SunriseSunsetAutoRefresh;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@SpringBootApplication
public class FaircorpApplication {
	public static void main(String[] args) {
		SpringApplication.run(FaircorpApplication.class, args);

		/* Auto light controller thread */
		AutoLightThread autoLightThread = new AutoLightThread();
		autoLightThread.start();

		/* Auto thermostat controller thread */
		AutoThermostatThread autoThermostatThread = new AutoThermostatThread();
		autoThermostatThread.start();

		/* Auto sunrise and sunset times refresher */
		SunriseSunsetAutoRefresh sunriseSunsetAutoRefresh = new SunriseSunsetAutoRefresh();
		sunriseSunsetAutoRefresh.start();
	}
}
