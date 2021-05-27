package Utilidades;

import java.util.List;
import java.util.Map;

import static java.lang.Math.round;

public class AccuWeatherHandler implements ServicioDeClima {
  private static final String Ciudad = "Buenos Aires, Argentina";

  private AccuWeatherAPI apiPronosticoClima = new AccuWeatherAPI();
  private List<Map<String, Object>> condicionesClimaticas;

  private void actualizarDatosApiClima() {
    this.condicionesClimaticas =  apiPronosticoClima.getWeather(Ciudad);
  }

  public Integer getProbabilidadDePrecipitaciones() {
    actualizarDatosApiClima();
    return (Integer) condicionesClimaticas.get(0).get("PrecipitationProbability");
    //Devuelve un número del 0 al 1;
  }

  public Integer getTemperaturaEnCelsius() {
    actualizarDatosApiClima();
    Map<String, Object> temp = (Map<String, Object>) condicionesClimaticas.get(0).get("Temperature");
    return fahrenheitACelsius((Integer) temp.get("Value"));
  }

  private Integer fahrenheitACelsius(Integer temperaturaEnFarenheit) {
    return (int) round((temperaturaEnFarenheit - 32) * (5.0 / 9.0));
  }
}
