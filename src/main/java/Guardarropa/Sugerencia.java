package Guardarropa;

import Prenda.Prenda;

public class Sugerencia {
  Guardarropa guardarropa;
  private Prenda prenda;
  private EstadoSugerencia estado = EstadoSugerencia.TENTATIVA; //En pricnipio, simpre es tentativa o pendiente
  private TipoSugerencia tipoSugerencia;

  public Sugerencia(Prenda prenda,Guardarropa guardarropa, TipoSugerencia tipoSugerencia) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
    this.tipoSugerencia = tipoSugerencia;
  }

  public EstadoSugerencia getEstado() {
    return estado;
  }

  public Guardarropa getGuardarropa() {
    return  guardarropa;
  }

  public TipoSugerencia getTipoSugerencia() {
    return tipoSugerencia;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public void aceptarSugerencia() {
    this.estado = EstadoSugerencia.ACEPTADA;
  }

  public void rechazarSugerencia() {
    this.estado = EstadoSugerencia.RECHAZADA;
  }

  public void deshacerEstadoSugerencia() {
    this.estado = EstadoSugerencia.TENTATIVA;
  }

}
