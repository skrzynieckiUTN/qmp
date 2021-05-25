package Prenda;

public enum Tipo {
  GAFAS(Categoria.ACCESORIOS),
  REMERA(Categoria.PARTE_SUPERIOR),
  PANTALON(Categoria.PARTE_INFERIOR),
  ZAPATILLAS(Categoria.CALZADO),
  PANIUELO(Categoria.ACCESORIOS),
  ZAPATOS(Categoria.CALZADO),
  MUSCULOSA(Categoria.PARTE_SUPERIOR),
  POLERA(Categoria.PARTE_SUPERIOR),
  BOTAS(Categoria.CALZADO),
  CHOMBA(Categoria.PARTE_SUPERIOR),
  CAMISA(Categoria.PARTE_SUPERIOR);

  Tipo(Categoria categoria) {
    this.categoria = categoria;
  }

  private Categoria categoria;

  public Categoria getCategoria() {
    return this.categoria;
  }
}
