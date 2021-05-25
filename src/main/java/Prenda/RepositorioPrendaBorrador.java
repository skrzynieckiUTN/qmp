package Prenda;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPrendaBorrador {
  private List<PrendaBorrador> borradores = new ArrayList<>();

  public void agregarBorrador(PrendaBorrador borrador) {
    borradores.add(borrador);
  }

  public List<PrendaBorrador> getBorradoresIncompletos() {
    return borradores;
  }
}
