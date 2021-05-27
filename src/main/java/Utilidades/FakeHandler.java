package Utilidades;

public class FakeHandler implements ServicioDeClima {
  private Integer probPrecipitaciones = 0;
  private Integer temperatura =19;

  public FakeHandler(Integer temperatura, Integer probPrecipitaciones) {
    this.temperatura = temperatura;
    this.probPrecipitaciones = probPrecipitaciones;
  }

  public Integer getProbabilidadDePrecipitaciones() {
    return probPrecipitaciones;
  }

  public Integer getTemperaturaEnCelsius() {
    return temperatura;
  }
}
