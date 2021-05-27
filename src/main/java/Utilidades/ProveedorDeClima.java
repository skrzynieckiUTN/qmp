package Utilidades;

import static java.util.Objects.requireNonNull;

public class ProveedorDeClima {

  private ServicioDeClima proveedor;

  public void setProveedorDeClima(ServicioDeClima nuevoProveedor) {
    this.proveedor = requireNonNull(nuevoProveedor, "Indique un proveedor de clima");
  }

  public Integer getProbabilidadDePrecipitaciones() {
    try {
      return proveedor.getProbabilidadDePrecipitaciones();
    } catch (Exception e) {
      throw new ExcepcionProveedorDeClima("probabilidad de precipitaciones", proveedor);
    }
  }

  public Integer getTemperatura() {
    try {
      return proveedor.getTemperaturaEnCelsius();
    } catch (Exception e) {
      throw new ExcepcionProveedorDeClima("temperatura", proveedor);
    }
  }

}
