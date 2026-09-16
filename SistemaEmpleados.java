public class SistemaEmpleados {

    public static void main(String[] args) {

        Empleado[] listaEmpleados = {
            new Empleado(105, "Ana Torres", "Desarrolladora"),
            new Empleado(203, "Luis Perez", "Analista de datos"),
            new Empleado(150, "Marta Diaz", "Gerente de proyecto"),
            new Empleado(120, "Carlos Ruiz", "Soporte tecnico"),
            new Empleado(310, "Sofia Vega", "Disenadora UX"),
            new Empleado(180, "Jorge Nava", "Desarrollador"),
            new Empleado(250, "Paula Leon", "Recursos humanos"),
            new Empleado(90,  "Diego Cruz", "Administrador de BD"),
            new Empleado(400, "Elena Rios", "Scrum master"),
            new Empleado(130, "Hugo Mena", "QA tester")
        };

        ArbolBinario<Empleado> arbolEmpleados = new ArbolBinario<>();
        System.out.println("=== INSERCION DE EMPLEADOS EN EL ARBOL (por ID) ===");
        for (Empleado e : listaEmpleados) {
            arbolEmpleados.insertar(e);
            System.out.println("Insertado: " + e);
        }

        System.out.println("\n=== EMPLEADOS ORDENADOS POR ID (recorrido inorden) ===");
        System.out.println(arbolEmpleados.inorden());

        System.out.println("\n=== BUSQUEDA DE EMPLEADOS POR ID ===");
        int[] idsBuscar = {150, 310, 999};
        for (int id : idsBuscar) {
            Empleado clave = new Empleado(id, "", "");
            Empleado encontrado = arbolEmpleados.buscarValor(clave);
            if (encontrado != null) {
                System.out.println("ID " + id + " -> " + encontrado);
            } else {
                System.out.println("ID " + id + " -> NO ENCONTRADO");
            }
        }

        System.out.println("\n=== COMPARACION: ARBOL BINARIO vs BUSQUEDA SECUENCIAL ===");

        int idObjetivo = 310;

        int comparacionesSecuencial = 0;
        long inicioSec = System.nanoTime();
        Empleado resultadoSecuencial = null;
        for (Empleado e : listaEmpleados) {
            comparacionesSecuencial++;
            if (e.getId() == idObjetivo) {
                resultadoSecuencial = e;
                break;
            }
        }
        long finSec = System.nanoTime();

        arbolEmpleados.reiniciarContador();
        long inicioArbol = System.nanoTime();
        Empleado resultadoArbol = arbolEmpleados.buscarValor(new Empleado(idObjetivo, "", ""));
        long finArbol = System.nanoTime();
        int comparacionesArbol = arbolEmpleados.getComparaciones();

        System.out.println("Buscando empleado con ID " + idObjetivo + ":");
        System.out.println(" - Busqueda secuencial: " + comparacionesSecuencial
                + " comparaciones, " + (finSec - inicioSec) + " ns, resultado: " + resultadoSecuencial);
        System.out.println(" - Busqueda en arbol  : " + comparacionesArbol
                + " comparaciones, " + (finArbol - inicioArbol) + " ns, resultado: " + resultadoArbol);
        System.out.println("\nCon " + listaEmpleados.length + " empleados la diferencia es pequena,");
        System.out.println("pero la busqueda secuencial crece en O(n) mientras que el arbol");
        System.out.println("balanceado crece en O(log n); con miles de empleados la diferencia");
        System.out.println("de comparaciones necesarias se vuelve muy grande.");
    }
}
