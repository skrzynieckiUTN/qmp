import Prenda.*;
import Utilidades.ExcepcionPrendaIncompleta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaBorradorTest {

@Test
//Se crea un borrador con solo el tipo, cuando se quiere crear la prenda a partir de tal borrador
//Se lanza una excepcion desde PrendaBorrador
void seCreaBorradorSoloConTipoPeroNoSePuedeCrear() {
  PrendaBorrador pantalon = new PrendaBorrador(Tipo.PANTALON);
  ExcepcionPrendaIncompleta excepcion = assertThrows(
      ExcepcionPrendaIncompleta.class,
      () -> pantalon.crearPrenda()
   );

  Assertions.assertEquals("Prenda invalida", excepcion.getMessage());

}

@Test
//Prenda sin trama especificada defaultea a Lisa
void tramaSinEspecificarEnConstruccionEsLISA() {
  Assertions.assertEquals(borradorPrendaValidaSinTramaSeteadaEnConstruccion()
      .crearPrenda().getTrama(), Trama.LISA);
}

@Test
//Si una prenda que tiene una trama se le asigna la trama null
//Al ser invalida, la trama pasa a ser Lisa (por defecto)
//Tambien probamos crear dos prendas de el mismo borrador
void siNulleoLaTramaDevuelveTramaAlDefault() {
  PrendaBorrador borradorConTrama = borradorCompleto();
  Prenda zapatoRayado = borradorConTrama.crearPrenda();
  Assertions.assertEquals(zapatoRayado.getTrama(), Trama.RAYADA);

  borradorConTrama.agregarTrama(null);
  Prenda zapatoLiso = borradorConTrama.crearPrenda();
  Assertions.assertEquals(zapatoLiso.getTrama(), Trama.LISA);
}

@Test
//@DisplayName("Si el borrador no tiene seteado el colorPrimario no puedo crear una prenda")
void borradorSinColorPrimarioNoCreaPrenda() {

  Assertions.assertThrows(ExcepcionPrendaIncompleta.class, () -> borradorSinColorPrimario().crearPrenda());
}

@Test
//@DisplayName("Si el borrador no tiene seteado el prenda.Material no puedo crear una prenda")
void borradorSinMaterialNoCreaPrenda() {

  Assertions.assertThrows(ExcepcionPrendaIncompleta.class, () -> borradorSinMaterial().crearPrenda());
}

//@DisplayName("Puedo guardar un borradorPrenda y verificar que existe en el repo para recuperarlo")
@Test
void agregarBorradorARepositorioBorradoresYValidarQueSeGuardaOK(){
  PrendaBorrador borradorAGuardar = borradorPrendaValidaSinTramaSeteadaEnConstruccion();
  borradorAGuardar.agregarBorradorAlRepo(repositorioBorradores);

  Assertions.assertTrue(repositorioBorradores.getBorradoresIncompletos().contains(borradorAGuardar));
}


private PrendaBorrador borradorPrendaValidaSinTramaSeteadaEnConstruccion() {
  PrendaBorrador prendaCreableConTramaDefault= new PrendaBorrador(Tipo.CAMISA);
  prendaCreableConTramaDefault.agregarMaterial(Material.ACETATO);
  prendaCreableConTramaDefault.agregarColorPrimario(new ColorRgb(50,80,65));
  prendaCreableConTramaDefault.agregarColorSecundario(new ColorRgb(56,180,215));

  return prendaCreableConTramaDefault;
}

private PrendaBorrador borradorSinColorPrimario() {
  PrendaBorrador borradorsinColorPrimario = new PrendaBorrador(Tipo.REMERA);
  borradorsinColorPrimario.agregarMaterial(Material.ACETATO);
  borradorsinColorPrimario.agregarTrama(Trama.CUADROS);


  return borradorsinColorPrimario;
}

private PrendaBorrador borradorSinMaterial() {
  PrendaBorrador BorradorsinMaterial = new PrendaBorrador(Tipo.GAFAS);
  BorradorsinMaterial.agregarColorPrimario(new ColorRgb(0,10,20));
  BorradorsinMaterial.agregarColorSecundario(new ColorRgb(20,30,50));

  return BorradorsinMaterial;
}

private PrendaBorrador borradorCompleto() {
  PrendaBorrador borradorCompleto = new PrendaBorrador(Tipo.ZAPATOS);
  borradorCompleto.agregarMaterial(Material.ACETATO);
  borradorCompleto.agregarTrama(Trama.RAYADA);
  borradorCompleto.agregarColorPrimario(new ColorRgb(255,80,6));
  borradorCompleto.agregarColorSecundario(new ColorRgb(0,180,215));

  return borradorCompleto;
}

private final RepositorioPrendaBorrador repositorioBorradores = new RepositorioPrendaBorrador();

}
