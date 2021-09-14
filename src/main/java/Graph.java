public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel,String secondLabel, String... others);

    int getSize();

    void display();

    void  dfs(String startLabel);

    void bfs(String startLabel);
}
