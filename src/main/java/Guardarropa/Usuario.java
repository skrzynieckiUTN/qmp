package Guardarropa;

import Prenda.Prenda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
  private String nombre;
  private Set<Guardarropa> guardarropas = new HashSet<>();
  private List<Sugerencia> sugerencias = new ArrayList<>();

  public Usuario(String nombre) {
    this.nombre = nombre;
  }

  public List<Sugerencia> getSugerencias() {
    return sugerencias;
  }

  public Set<Guardarropa> getGuardarropas() {
    return guardarropas;
  }

  public void agregarGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public void cargarPrendaAGuardarropa(Guardarropa guardarropa, Prenda prenda) {
    //TODO excecpcion nulls
    guardarropa.cargarPrenda(prenda);
  }

  public void quitarPrendaAGuardarropa(Guardarropa guardarropa, Prenda prenda) {
    //TODO excecpcion nulls
    guardarropa.borrarPrenda(prenda);
  }

  public void agregarSugerencia(Sugerencia sugerencia) {
    sugerencias.add(sugerencia);
  }

  public void compartirGuardarropa(Guardarropa guardarropa, Usuario usuario) {
    //TODO validar que no es self, null, que el guardarropa ya este compartido
    usuario.guardarropas.add(guardarropa);
  }

  public void sugerirAgregarPrendaGuardarropa(Prenda prenda, Guardarropa guardarropa, Usuario usuario) {
    usuario.agregarSugerencia(new Sugerencia(prenda, guardarropa, TipoSugerencia.AGREGAR));
  }

  public void sugerirQuitarPrendaGuardarropa(Prenda prenda,Guardarropa guardarropa, Usuario usuario) {
    usuario.agregarSugerencia(new Sugerencia(prenda, guardarropa, TipoSugerencia.QUITAR));
  }

  public void aceptarSugerencia(Sugerencia sugerencia) {
    if(sugerencia.getTipoSugerencia() == TipoSugerencia.AGREGAR) {
      sugerencia.aceptarSugerencia();
      this.cargarPrendaAGuardarropa(sugerencia.getGuardarropa() , sugerencia.getPrenda());
    }
    if(sugerencia.getTipoSugerencia() == TipoSugerencia.QUITAR) {
      sugerencia.rechazarSugerencia();
      this.quitarPrendaAGuardarropa(sugerencia.getGuardarropa() , sugerencia.getPrenda());
    }
  }

  public void deshacerSugerenciaAceptada(Sugerencia sugerencia) {
    if(sugerencia.getEstado() == EstadoSugerencia.ACEPTADA) {
      this.quitarPrendaAGuardarropa(sugerencia.getGuardarropa(), sugerencia.getPrenda());
    }
    if(sugerencia.getTipoSugerencia() == TipoSugerencia.QUITAR) {
      this.cargarPrendaAGuardarropa(sugerencia.getGuardarropa(), sugerencia.getPrenda());
    }
    sugerencia.deshacerEstadoSugerencia();
  }
}
