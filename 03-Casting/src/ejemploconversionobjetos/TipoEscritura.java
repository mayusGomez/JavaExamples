package ejemploconversionobjetos;

public enum TipoEscritura {
    CLASICO("Escritura a Mano"),
    MODENO("Escrituta digital");

    private final String descripcion;

    private TipoEscritura(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
