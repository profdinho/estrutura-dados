package br.com.profdinho.pilhas;

public class PilhaEstaticaRedimensionavel {
    private Integer [] elementos;
    Integer topo;

    public PilhaEstaticaRedimensionavel(){
        elementos = new Integer[2];
        topo = -1;
    }

    public void push(Integer e)  {
        if (topo == elementos.length - 1 )
            resize(2 * elementos.length);
        elementos[++topo] = e;
    }

    public Integer pop() {
        Integer i = elementos[topo--];
        if (topo > 0 && topo == elementos.length/4)
            resize(elementos.length/2);
        return i;
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

    private void resize(int max) {
        Integer[] temp;
        temp = new Integer[max];
        for (int i = 0; i <= topo; i++)
            temp[i] = elementos[i];
        elementos = temp;
    }

}
