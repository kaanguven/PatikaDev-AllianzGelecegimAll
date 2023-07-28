package model;

public enum WeatherEnum {
    SUNNY, RAINY, WINDY, SNOWY, FIRESTORM, SANDSTORM, THUNDERSTORM;

    public ElementEnum getBuffedElement() {
        if (this == WeatherEnum.SUNNY || this == WeatherEnum.FIRESTORM) {
            return ElementEnum.FIRE;
        } else if (this == WeatherEnum.RAINY) {
            return ElementEnum.WATER;
        } else if (this == WeatherEnum.WINDY || this == WeatherEnum.THUNDERSTORM) {
            return ElementEnum.ELECTRICITY;
        } else if (this == WeatherEnum.SNOWY) {
            return ElementEnum.ICE;
        } else if (this == WeatherEnum.SANDSTORM) {
            return ElementEnum.EARTH;
        } else {
            return null;
        }
    }

    public ElementEnum getDebuffedElement() {
        if (this == WeatherEnum.SUNNY || this == WeatherEnum.FIRESTORM) {
            return ElementEnum.WATER;
        } else if (this == WeatherEnum.RAINY || this == WeatherEnum.SNOWY) {
            return ElementEnum.FIRE;
        } else if (this == WeatherEnum.WINDY || this == WeatherEnum.THUNDERSTORM) {
            return ElementEnum.EARTH;
        } else if (this == WeatherEnum.SANDSTORM) {
            return ElementEnum.AIR;
        } else {
            return null;
        }
    }
}
