package Utilidades;

public class ExcepcionPrendaIncompleta extends RuntimeException {
  public ExcepcionPrendaIncompleta(String mensaje) {
    super(mensaje);
  }
}
