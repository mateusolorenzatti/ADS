/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

/**
 *
 * @author Xavier
 */
import java.util.LinkedList;
import java.util.List;

public class Fila<T> {

    protected List<T> objetos = new LinkedList<T>();

    public void insere(T t) {
        this.objetos.add(t);
    }

    public T remove() {
        return this.objetos.remove(0);
    }

    public boolean vazia() {
        return this.objetos.size() == 0;
    }

    public int getTamanho() {
        return this.objetos.size();
    }

    public String toString() {
        return "Fila{" + this.objetos + '}';
    }

}
