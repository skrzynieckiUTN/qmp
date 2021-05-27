package Conjunto;

import Prenda.PrendaBorrador;
import Prenda.*;

public class DisenioPlantillaSanJuan extends DisenioPlantilla {
  public Prenda crearPrendaSuperior() {
    PrendaBorrador borradorPrendaSuperior = new PrendaBorrador(Tipo.CHOMBA);
    borradorPrendaSuperior.agregarMaterial(Material.PIQUE);
    borradorPrendaSuperior.agregarColorPrimario(new ColorRgb(153, 0, 73));
    return borradorPrendaSuperior.crearPrenda();
  }

  public Prenda crearPrendaInferior() {

    PrendaBorrador borradorInferior = new PrendaBorrador(Tipo.PANTALON);
    borradorInferior.agregarMaterial(Material.ACETATO);
    borradorInferior.agregarColorPrimario(new ColorRgb(96, 96, 96));
    return borradorInferior.crearPrenda();
  }

  public Prenda crearCalzado() {
    PrendaBorrador borradorInferior = new PrendaBorrador(Tipo.ZAPATILLAS);
    borradorInferior.agregarMaterial(Material.ALGODON);
    borradorInferior.agregarColorPrimario(new ColorRgb(255, 255, 255));
    return borradorInferior.crearPrenda();
  }
}
