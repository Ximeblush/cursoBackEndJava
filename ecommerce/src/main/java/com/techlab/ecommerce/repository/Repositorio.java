package com.techlab.ecommerce.repository;

import java.util.ArrayList;
import java.util.List;
import com.techlab.ecommerce.interfaces.Identificable;

public class Repositorio <T extends Identificable> {

    private ArrayList<T> lista = new ArrayList<>();

    public void agregar(T objeto) {
        lista.add(objeto);
    }

    public List<T> listar() {
        return new ArrayList<>(lista);
    }

    public T buscarPorId(int id) {
        for (T objeto : lista) {
            if (objeto.getId() == id) {
                return objeto;
            }
        }
        return null; // Retorna null si no se encuentra el elemento con el id especificado
    }

    public void eliminar(T objeto) {
        lista.remove(objeto);
    }

    public boolean estaVacio() {
        return lista.isEmpty(); 
    }    

}