package service;

import model.WeatherEnum;
import model.Pokemon;

import java.util.Random;

public class WeatherService {

    public WeatherEnum getWeather() {
        int random = (int) (Math.random() * 6);
        WeatherEnum weatherEnum;

        if (random == 1) {
            weatherEnum = WeatherEnum.RAINY;
        } else if (random == 2) {
            weatherEnum = WeatherEnum.WINDY;
        } else if (random == 3) {
            weatherEnum = WeatherEnum.SNOWY;
        } else if (random == 4) {
            weatherEnum = WeatherEnum.FIRESTORM;
        } else if (random == 5) {
            weatherEnum = WeatherEnum.THUNDERSTORM;
        } else {
            weatherEnum = WeatherEnum.SUNNY;
        }

        return weatherEnum;
    }

    public int checkWeatherBuffOrDebuff(WeatherEnum weatherEnum, Pokemon pokemon) {
        int buff = 0;
        int debuff = 0;

        if (pokemon.getElement() == weatherEnum.getBuffedElement()) {
            buff = new Random().nextInt(5) + 1;
            System.out.println(pokemon.getName() + " gets " + buff + " extra damage. Weather affects it !");
            return buff;
        } else if (pokemon.getElement() == weatherEnum.getDebuffedElement()) {
            debuff = new Random().nextInt(5) + 1;
            System.out.println(pokemon.getName() + " gets " + debuff + " damage less.  Weather affects it !");
            return -debuff;
        }
        return 0;
    }
}