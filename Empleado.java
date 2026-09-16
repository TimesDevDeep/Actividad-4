public class Empleado implements Comparable<Empleado> {

    private int id;
    private String nombre;
    private String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public int compareTo(Empleado otro) {
        return Integer.compare(this.id, otro.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Empleado)) return false;
        return this.id == ((Empleado) obj).id;
    }

    @Override
    public String toString() {
        return "ID:" + id + " (" + nombre + " - " + puesto + ")";
    }
}
