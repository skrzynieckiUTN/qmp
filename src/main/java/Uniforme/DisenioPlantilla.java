package Uniforme;
import Prenda.*;

public abstract  class DisenioPlantilla {
  public Uniforme getUniforme() {
    return new Uniforme(crearPrendaSuperior(), crearPrendaInferior(), crearCalzado());
  }

  public abstract Prenda crearPrendaSuperior();

  public abstract Prenda crearPrendaInferior();

  public abstract Prenda crearCalzado();
}
