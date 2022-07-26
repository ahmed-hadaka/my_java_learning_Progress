package Demonstrates_Minimum_Spanning_Tree;

public class PriorityQ {
    private Edge[] queArray;
    private int nElements;

    public PriorityQ(int size) {
        queArray = new Edge[size];
        nElements = 0;
    }

    public void insert(Edge item) {
        if (nElements == 0) {
            queArray[nElements++] = item;
            return;
        }
        for (int i = nElements - 1; i >= 0; i--) {
            if (item.getDistance() >= queArray[i].getDistance()) {
                queArray[i + 1] = queArray[i];
                if (i == 0) { // special case
                    queArray[i] = item;
                    break;
                }
            } else {
                queArray[i + 1] = item;
                break;
            }
        }
        nElements++;
    }

    public Edge removeMin() {
        return queArray[--nElements];
    }

    public void removeN(int index) {
        for (int i = index; i < nElements; i++)
            queArray[i] = queArray[i + 1];
        nElements--;
    }

    public Edge peekN(int n) {
        return queArray[n];
    }

    public int findDesInd(int desVertex) {
        for (int i = 0; i < nElements; i++)  // find item with specified destVert value
            if (queArray[i].getDesVertex() == desVertex)
                return i;
        return -1;
    }

    public int getSize() {
        return nElements;
    }
}
