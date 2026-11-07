package pe.edu.pucp.iweb.lab8.beans;

/**
 * Ejercicio 2: bean Cancion.
 */
public class Cancion {

    // TODO: atributos idCancion, titulo, artista, duracionSeg, anio
    //          y genero (de tipo Genero)
    private Integer idcancion;
    private String titulo;
    private String artista;
    private Integer duracion_seg;
    private Integer anio;
    private Genero genero;

    // TODO: getters y setters
    public Integer getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(Integer idcancion) {
        this.idcancion = idcancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getDuracion_seg() {
        return duracion_seg;
    }

    public void setDuracion_seg(Integer duracion_seg) {
        this.duracion_seg = duracion_seg;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        return;
    }
    /**
     * TODO: retornar la duración en formato m:ss
     *          (354 segundos -> "5:54", 200 segundos -> "3:20").
     */
    public double getDuracionFormateada() {

        return (double) duracion_seg /60;
    }


}
