import java.util.*;

public class GraphImpl implements Graph{

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    private int way1;
    private int way2;
    private int way3;

    public GraphImpl(int maxVerCount) {
        this.vertexList = new ArrayList<>(maxVerCount);
        this.adjMatrix = new int[maxVerCount][maxVerCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

 //   @Override
 //   public boolean addEdge(String startLabel, String secondLabel, String... others) {
 //       boolean result = addEdge(startLabel,secondLabel);
 //
 //        for (String other : others) {
 //           result &= addEdge(startLabel,other);
 //       }
 //       return result;
 //
 //   }

    public boolean addEdge(String startLabel, String endLabel,int mass) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if(startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = mass;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if(vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return 0;
    }


    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if(adjMatrix[i][j] > 0){
                    System.out.println(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        
        if(startIndex == -1) {
            System.out.println("ER");
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack,vertex);
        while (!stack.isEmpty()){
            vertex = getNear(stack.peek());
            if(vertex != null){
                visitVertex(stack,vertex);
            } else  {
                stack.pop();
            }
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNear(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++){
            if ((adjMatrix[currentIndex][i] > 0) && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if(startIndex == -1) {
            System.out.println("ER");
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack,vertex);

        while (!stack.isEmpty()){
            vertex = getNear(stack.peek());
            if(vertex != null){
                visitVertex(stack,vertex);
            } else  {
                stack.remove();
            }
        }
    }
}