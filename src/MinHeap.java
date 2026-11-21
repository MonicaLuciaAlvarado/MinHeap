import java.util.ArrayList;

public class MinHeap {

    //Atributos
    private ArrayList<Integer> monticulo;
    //Métodos
    //Constructor
    public MinHeap(){
        monticulo = new ArrayList<>();
    }

    //Operaciones
    private boolean estaVacio(){
        return monticulo.isEmpty();
    }

    private int getIzq(int i){
        return (2*i)+1;
    }

    private int getDer(int i){
        return (2*i) + 2;
    }

    private int getPadre(int i){
        return (i-1) / 2;
    }

    public void insertar(int nodo){
        monticulo.add(nodo);
        // Invocar upHeapify() en el índice del nodo recién insertado
        upHeapify(monticulo.size() - 1);
    }

    private void upHeapify(int i){
        //Sustituir el nodo de la casilla i por su padre de manera exhaustiva siempre que sea menor que él
        while(i > 0){
            int padre = getPadre(i);

            if(monticulo.get(i) < monticulo.get(padre)){
                int temp = monticulo.get(i);
                monticulo.set(i, monticulo.get(padre));
                monticulo.set(padre, temp);

                i = padre;
            }else{
                break;
            }
        }
    }

    public int pop(){
        if(estaVacio()){
            System.out.println("El montículo está vacío.\n");
            return -1;
        }

        int temp = monticulo.getFirst();
        int ultimo = monticulo.removeLast();

        if(!estaVacio()){
            monticulo.set(0, ultimo);
            downHeapify(0);
        }

        return temp;
    }

    private void downHeapify(int i){
        while(getIzq(i) < monticulo.size()){
            int izq = getIzq(i);
            int der = getDer(i);
            int menor = izq;

            if(der < monticulo.size() &&
                    monticulo.get(der) < monticulo.get(izq)){
                menor = der;
            }

            if(monticulo.get(i) > monticulo.get(menor)){
                int temp = monticulo.get(i);
                monticulo.set(i, monticulo.get(menor));
                monticulo.set(menor, temp);

                i = menor;
            }else{
                break;
            }
        }
    }

    public int peek(){
        if(estaVacio()){
            System.out.println("El montículo está vacío.\n");
            return -1;
        }
        return monticulo.getFirst();
    }

    public void heapify(int[] arreglo){
        monticulo.clear();

        for(int i = 0; i < arreglo.length; i++){
            monticulo.add(arreglo[i]);
        }

        for(int i = (monticulo.size() / 2) - 1; i >= 0; i--){
            downHeapify(i);
        }
    }

    public void mostrar(){
        System.out.println(monticulo);
    }

}
