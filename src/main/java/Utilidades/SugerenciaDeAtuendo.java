package Utilidades;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Conjunto.Atuendo;
import Prenda.Prenda;
import Prenda.Categoria;


public class SugerenciaDeAtuendo {
  private ProveedorDeClima proveedorServicioDeClima;
  private Integer temperaturaActual;
  private Integer probabilidadPrecipitaciones;

  public void actualizarTemperaturaActual() {
    this.temperaturaActual = proveedorServicioDeClima.getTemperatura();
  }

  public void actualizarProbabilidadDePrecipitaciones() {
    this.probabilidadPrecipitaciones = proveedorServicioDeClima.getProbabilidadDePrecipitaciones();
  } //Los dos actualizar son para no consultar constantemente los datos, debido al costo de la consulta

  public SugerenciaDeAtuendo(ProveedorDeClima proveedorDeClima) {
    this.proveedorServicioDeClima = proveedorDeClima;
  }

  public Atuendo getAtuendoSugeridoParaTemperaturaActual(List<Prenda> prendasDisponibles) {
    Prenda parteSuperior = getPrendaAdecuadaParaLaTemperaturaActual(prendasDisponibles,
        Categoria.PARTE_SUPERIOR);
    Prenda parteInferior = getPrendaAdecuadaParaLaTemperaturaActual(prendasDisponibles,
        Categoria.PARTE_INFERIOR);
    Prenda calzado = getPrendaAdecuadaParaLaTemperaturaActual(prendasDisponibles,
        Categoria.CALZADO);
    Prenda accesorio = getPrendaAdecuadaParaLaTemperaturaActual(prendasDisponibles,
        Categoria.ACCESORIOS);
    return new Atuendo(parteSuperior, parteInferior, calzado, accesorio);
  }


  public Atuendo getSugerenciaAtuendo(List<Prenda> prendasDisponibles) {
    List<Prenda> partesSuperiores = getPrendaCategoriaCorrecta(prendasDisponibles,
        Categoria.PARTE_SUPERIOR);
    List<Prenda> partesInferiores = getPrendaCategoriaCorrecta(prendasDisponibles,
        Categoria.PARTE_INFERIOR);
    List<Prenda> calzados = getPrendaCategoriaCorrecta(prendasDisponibles,
        Categoria.CALZADO);
    List<Prenda> accesorios = getPrendaCategoriaCorrecta(prendasDisponibles,
        Categoria.ACCESORIOS);
    Prenda randomParteSup = partesSuperiores.get(new Random().nextInt(partesSuperiores.size()));
    Prenda randomParteInf = partesInferiores.get(new Random().nextInt(partesInferiores.size()));
    Prenda randomParteCalzado = calzados.get(new Random().nextInt(calzados.size()));
    Prenda randomParteAccesorio = accesorios.get(new Random().nextInt(accesorios.size()));
    return new Atuendo(randomParteSup, randomParteInf, randomParteCalzado, randomParteAccesorio);
  }

  private Prenda getPrendaAdecuadaParaLaTemperaturaActual(List<Prenda> prendas, Categoria categoria) {
    List<Prenda> prendasTemperaturaValida = getPrendaCategoriaCorrecta(prendas, categoria)
        .stream().filter(prenda -> prenda.getTemperaturaAdecuadaMaxima() <= SugerenciaDeAtuendo.this.temperaturaActual)
        .collect(Collectors.toList());
    return prendasTemperaturaValida.get(new Random().nextInt(prendasTemperaturaValida.size()));
  }

  private List<Prenda> getPrendaCategoriaCorrecta(List<Prenda> prendas, Categoria categoria) {
    return  prendas.stream().filter(prenda -> prenda.getCategoria().equals(categoria))
        .collect(Collectors.toList());
  }

}
