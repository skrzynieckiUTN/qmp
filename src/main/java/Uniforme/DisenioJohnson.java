package Uniforme;

import Prenda.PrendaBorrador;
import Prenda.*;

public class DisenioJohnson extends DisenioPlantilla {
  public Prenda crearPrendaSuperior() {
    PrendaBorrador borradorPrendaSuperior = new PrendaBorrador(Tipo.CAMISA);
    borradorPrendaSuperior.agregarMaterial(Material.TELA);
    borradorPrendaSuperior.agregarColorPrimario(new ColorRgb(255, 255, 255));
    return borradorPrendaSuperior.crearPrenda();
  }

  public Prenda crearPrendaInferior() {
    PrendaBorrador borradorInferior = new PrendaBorrador(Tipo.PANTALON);
    borradorInferior.agregarMaterial(Material.ACETATO);
    borradorInferior.agregarColorPrimario(new ColorRgb(0, 0, 0));
    return borradorInferior.crearPrenda();
  }

  public Prenda crearCalzado() {
    PrendaBorrador borradorInferior = new PrendaBorrador(Tipo.ZAPATOS);
    borradorInferior.agregarMaterial(Material.PLASTICO);
    borradorInferior.agregarColorPrimario(new ColorRgb(0, 0, 0));
    return borradorInferior.crearPrenda();
  }
}
