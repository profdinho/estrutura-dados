package br.com.profdinho.pilhas;

public class PilhaEstatica {
    private Integer [] elementos;
    Integer topo;
    final static Integer max = 20;

    public PilhaEstatica(){
        elementos = new Integer[max];
        topo = -1;
    }

    public void push(Integer e)  {
        elementos[++topo] = e;
    }

    public Integer pop() {
        return elementos[topo--];
    }

    public Integer peek() {
        return elementos[topo];
    }

    public boolean empty(){
        return topo == -1;
    }

    public Integer size(){
        return topo + 1;
    }
}
