import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

@Test
void laCategoriaDeUnaBOTAesCALZADO() {
  assertEquals(prendaDeTelaYColorPrimario(Tipo.BOTAS).getCategoria(), Categoria.CALZADO);
}
@Test
void laCategoriaDeUnPANTALONesPARTE_INFERIOR() {
  assertEquals(prendaDeTelaYColorPrimario(Tipo.PANTALON).getCategoria(), Categoria.PARTE_INFERIOR);
}
@Test
void laCategoriaDeUnaMUSCULOSAesPARTE_SUPERIOR() {
  assertEquals(prendaDeTelaYColorPrimario(Tipo.MUSCULOSA).getCategoria(), Categoria.PARTE_SUPERIOR);
}
@Test
void laCategoriaDeUnPANIUELOAesACCESTORIOS() {
  assertEquals(prendaDeTelaYColorPrimario(Tipo.PANIUELO).getCategoria(), Categoria.ACCESORIOS);
}

private Prenda prendaDeTelaYColorPrimario(Tipo tipo) {
  return new Prenda(tipo, Material.CUERO,new ColorRgb(15,325,9), null, null);
}

@Test
void prendaSinMaterialNoSePuedeCrear() { //se lanza la null pointer exception
  assertThrows(NullPointerException.class,
      ()->{
        new Prenda(null, Material.CUERO,new ColorRgb(15,325,9), null, null);
      });
}

}
