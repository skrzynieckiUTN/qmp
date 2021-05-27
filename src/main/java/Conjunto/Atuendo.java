package Conjunto;

import Prenda.*;

public class Atuendo extends Uniforme {
  private Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
    super(parteSuperior, parteInferior, calzado);
    this.accesorio = validarCategoria(accesorio, Categoria.ACCESORIOS);
  }

  public Prenda getAccesorio() {
    return accesorio;
  }
}
