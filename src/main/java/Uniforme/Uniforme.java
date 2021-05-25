package Uniforme;
import Prenda.*;
import Utilidades.*;

import java.util.Arrays;
import java.util.List;

public class Uniforme {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = validarCategoria(parteSuperior, Categoria.PARTE_SUPERIOR);
    this.parteInferior = validarCategoria(parteInferior, Categoria.PARTE_INFERIOR);
    this.calzado = validarCategoria(calzado, Categoria.CALZADO);
  }

  private Prenda validarCategoria(Prenda prenda, Categoria categoria) {
    if (prenda.getCategoria() != categoria) {
      throw new ExcepcionCategoriaErrorEnUniforme("Categoria invalida para " + categoria.toString());
    }
    return prenda;
  }

  /*public List<Prenda> getPrendasUniforme() {
    return Arrays.asList(parteSuperior, parteInferior, calzado);
  }*/

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
