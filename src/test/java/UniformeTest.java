import Conjunto.Uniforme;
import Utilidades.ExcepcionCategoriaErrorEnUniforme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Conjunto.*;
import Prenda.*;

public class UniformeTest {

@Test
//Caracteristicas de la prenda superior del uniforme de Johnson se obtiene de forma correcta
void laParteSuperiorDeJohnsonEsUnaCamisaBlanca() {
  Uniforme institutoJohnson = new DisenioJohnson().getUniforme();
  Assertions.assertEquals(institutoJohnson.getParteSuperior().getTipo(), Tipo.CAMISA);
  Assertions.assertEquals(institutoJohnson.getParteSuperior().getMaterial(), Material.TELA);
  Assertions.assertEquals(institutoJohnson.getParteSuperior().getColorPrimario().getRojo(),255);
  Assertions.assertEquals(institutoJohnson.getParteSuperior().getColorPrimario().getVerde(),255);
  Assertions.assertEquals(institutoJohnson.getParteSuperior().getColorPrimario().getAzul(),255);

}

@Test
//@DisplayName("prenda.Prenda superior del uniforme de San Juan se obtiene de manera correcta")
void laParteinferiorDeSanJuanEsUnaPantalonGrisDeAcetato() {
  Uniforme institutoSanJuan = new DisenioPlantillaSanJuan().getUniforme();
  Assertions.assertEquals(institutoSanJuan.getParteInferior().getTipo(),Tipo.PANTALON);
  Assertions.assertEquals(institutoSanJuan.getParteInferior().getMaterial(),Material.ACETATO);
  Assertions.assertEquals(institutoSanJuan.getParteInferior().getColorPrimario().getRojo(),96);
  Assertions.assertEquals(institutoSanJuan.getParteInferior().getColorPrimario().getVerde(),96);
  Assertions.assertEquals(institutoSanJuan.getParteInferior().getColorPrimario().getAzul(),96);
  Assertions.assertEquals(institutoSanJuan.getCalzado().getTipo(),Tipo.ZAPATILLAS);
}

@Test
//@DisplayName("Un uniforme siempre tiene una prenda.Prenda Superior, Inferior y Calzado")
void UniformeConPrendaNullArrojaNullPointerException() {
  Assertions.assertThrows(NullPointerException.class,
      () -> new Uniforme(null, prendaInferior(), prendaCalzado()));
  Assertions.assertThrows(NullPointerException.class,
      () -> new Uniforme(prendaSuperior(), null, prendaCalzado()));
  Assertions.assertThrows(NullPointerException.class,
      () -> new Uniforme(prendaSuperior(), prendaInferior(), null));
}

@Test
//@DisplayName("No puedo construir Uniformes con prendas de categorias incorrectas")
void siConstruyoUnUniformeConPrendasDeCategoriaErroneaArrojaExcepcion() {
  Assertions.assertThrows(ExcepcionCategoriaErrorEnUniforme.class,
      () -> new Uniforme(prendaInferior(), prendaInferior(), prendaCalzado()));
  Assertions.assertThrows(ExcepcionCategoriaErrorEnUniforme.class,
      () -> new Uniforme(prendaSuperior(), prendaCalzado(), prendaCalzado()));
  Assertions.assertThrows(ExcepcionCategoriaErrorEnUniforme.class,
      () -> new Uniforme(prendaSuperior(), prendaInferior(), prendaInferior()));

}

private Prenda prendaSuperior() {
  return new Prenda(Tipo.CAMISA, Material.ALGODON, new ColorRgb(10,10,10),
      null, Trama.ESTAMPA, 30);
}

private Prenda prendaInferior() {
  return new Prenda(Tipo.PANTALON, Material.ALGODON, new ColorRgb(55,55,55),
      null, Trama.ESTAMPA, 25);
}

private Prenda prendaCalzado() {
  return new Prenda(Tipo.ZAPATOS, Material.CUERO, new ColorRgb(55,55,55),
      null, Trama.LISA, 20);
}

}
