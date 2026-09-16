public class ArbolBinario<T extends Comparable<T>> {

    private Nodo<T> raiz;
    private int comparaciones;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo<T> insertarRec(Nodo<T> actual, T valor) {
        if (actual == null) {
            return new Nodo<>(valor);
        }
        int cmp = valor.compareTo(actual.valor);
        if (cmp < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else if (cmp > 0) {
            actual.derecho = insertarRec(actual.derecho, valor);
        }
        return actual;
    }

    public boolean buscar(T valor) {
        return buscarNodo(raiz, valor) != null;
    }

    public T buscarValor(T valor) {
        Nodo<T> nodo = buscarNodo(raiz, valor);
        return (nodo == null) ? null : nodo.valor;
    }

    private Nodo<T> buscarNodo(Nodo<T> actual, T valor) {
        comparaciones++;
        if (actual == null) {
            return null;
        }
        int cmp = valor.compareTo(actual.valor);
        if (cmp == 0) {
            return actual;
        } else if (cmp < 0) {
            return buscarNodo(actual.izquierdo, valor);
        } else {
            return buscarNodo(actual.derecho, valor);
        }
    }

    public void reiniciarContador() {
        comparaciones = 0;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void eliminar(T valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo<T> eliminarRec(Nodo<T> actual, T valor) {
        if (actual == null) {
            return null;
        }

        int cmp = valor.compareTo(actual.valor);
        if (cmp < 0) {
            actual.izquierdo = eliminarRec(actual.izquierdo, valor);
        } else if (cmp > 0) {
            actual.derecho = eliminarRec(actual.derecho, valor);
        } else {
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }
            T sucesor = obtenerMinimo(actual.derecho);
            actual.valor = sucesor;
            actual.derecho = eliminarRec(actual.derecho, sucesor);
        }
        return actual;
    }

    private T obtenerMinimo(Nodo<T> nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.valor;
    }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void preordenRec(Nodo<T> nodo, StringBuilder sb) {
        if (nodo == null) return;
        sb.append(nodo.valor).append(" ");
        preordenRec(nodo.izquierdo, sb);
        preordenRec(nodo.derecho, sb);
    }

    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void inordenRec(Nodo<T> nodo, StringBuilder sb) {
        if (nodo == null) return;
        inordenRec(nodo.izquierdo, sb);
        sb.append(nodo.valor).append(" ");
        inordenRec(nodo.derecho, sb);
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void postordenRec(Nodo<T> nodo, StringBuilder sb) {
        if (nodo == null) return;
        postordenRec(nodo.izquierdo, sb);
        postordenRec(nodo.derecho, sb);
        sb.append(nodo.valor).append(" ");
    }

    public boolean estaVacio() {
        return raiz == null;
    }
}
