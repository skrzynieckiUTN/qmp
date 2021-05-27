package Utilidades;

public class ExcepcionProveedorDeClima extends RuntimeException {
  public ExcepcionProveedorDeClima(String variableMeteorologica,ServicioDeClima proveedor) {
    super("No es posible obtener " + variableMeteorologica + " del proveedor " + proveedor.toString());
  }
}
