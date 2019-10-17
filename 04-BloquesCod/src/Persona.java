public class Persona {
    private final int idPersona;
    private static int contadorPersonas;

    static {
        System.out.println("inicializador statico");
        contadorPersonas = 20;
    }

    {
        System.out.println("Ejecuta bloque inicializador");
        contadorPersonas = 3;
        this.idPersona = ++contadorPersonas;
    }

    Persona(){
        System.out.println("Ejecuta constructor");
    }

    public void getIdPersona(){
        System.out.println("Ipersona:" + this.idPersona);
    }
}
