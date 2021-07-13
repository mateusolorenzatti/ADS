package Estruturas.Pilha;

import java.util.LinkedList;

public class Pilha<T> {

  private LinkedList<T> objetos = new LinkedList<T>();

  public void insere(T t) {
    this.objetos.add(t);
  }

  public T remove() {
    return this.objetos.remove(this.objetos.size() - 1);
  }

  public boolean vazia() {
    return this.objetos.size() == 0;
  }
}