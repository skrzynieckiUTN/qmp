package Guardarropa;

import Prenda.Prenda;

import java.util.HashSet;
import java.util.Set;

public class Guardarropa {
  public String nombre;
  private Set<Prenda> prendas = new HashSet<Prenda>();

  public String getNombre() {
    return this.nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Set<Prenda> getPrendas() {
    return prendas;
  }


  public void borrarPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void cargarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }
}
