package Prenda;
import Utilidades.ExcepcionPrendaIncompleta;

import static java.util.Objects.requireNonNull;

public class PrendaBorrador {
  private Tipo tipo;
  private Material material;
  private ColorRgb colorPrimario;
  private ColorRgb colorSecundario;
  private Trama tramaPorDefecto = Trama.LISA;
  private Trama trama = tramaPorDefecto;
  private Integer temperaturaAdecuadaMaxima;


  private boolean prendaInvalida() {
    return this.tipo == null || this.material == null || this.colorPrimario == null;
  }

  //Primero la creo por el tipo, despues sigo agregando
  public PrendaBorrador(Tipo tipo) {
    this.tipo = tipo;
  }

  public void agregarMaterial(Material material) {
    this.material = material;
  }

  public void agregarColorPrimario(ColorRgb colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void agregarColorSecundario(ColorRgb colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void agregarTrama(Trama trama) {
    if (trama == null) {
      this.trama = tramaPorDefecto;
    } else {
      this.trama = trama;
    }
  }

  public void definirtemperaturaAdecuadaMaxima(Integer temperaturaAdecuadaMaxima){
    this.temperaturaAdecuadaMaxima = temperaturaAdecuadaMaxima;
  }

  private void validarReglasDeCreacion() {
    if (prendaInvalida()) {
      throw new ExcepcionPrendaIncompleta("Prenda invalida");
    }
  }

  public Prenda crearPrenda() {
    validarReglasDeCreacion();
    return new Prenda(tipo, material, colorPrimario, colorSecundario, trama, temperaturaAdecuadaMaxima);
  }

  public void agregarBorradorAlRepo(RepositorioPrendaBorrador repositorioBorradores) {
    repositorioBorradores.agregarBorrador(this);
  }
}
