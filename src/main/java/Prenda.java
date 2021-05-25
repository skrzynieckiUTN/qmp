import static java.util.Objects.requireNonNull;

public class Prenda {
  private Tipo tipo;
  private Material material;
  private ColorRgb colorPrimario;
  private ColorRgb colorSecundario;
  private Trama trama;


  public Prenda(Tipo tipo, Material material, ColorRgb colorPrimario,
                ColorRgb colorSecundario, Trama trama) {
    this.tipo = requireNonNull(tipo, "El tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "El tipo de material es obligatorio");
    this.colorPrimario = requireNonNull(colorPrimario, "El color primario de prenda es obligatorio");
    this.colorSecundario = colorSecundario;
    this.trama = trama;
  }

  public Categoria getCategoria() {
    return tipo.getCategoria();
  }

  /*
  public Tipo getTipo() {
    return tipo;
  }

  public Material getMaterial() {
    return material;
  }

  public ColorRgb getColorPrimario() {
    return colorPrimario;
  }

  public ColorRgb getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }
  */
}

