public class Main {
    public static void main(String[] args) {
       // testGraph();
       //  testDfs();
       testBfs();
    }

    private static void testGraph() {

   /*   Graph graph = new GraphImpl(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A","B","C");
        graph.addEdge("B","C","D");
        graph.addEdge("C","A","B","D");
        graph.addEdge("D","B","C");

        System.out.println("Size " + graph.getSize());
        graph.display(); */
    }

    private static void testDfs(){
   /*   Graph graph = new GraphImpl(7);
        graph.addVertex("");

        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A","B","C","D");
        graph.addEdge("B","E");
        graph.addEdge("D","F");
        graph.addEdge("F","G");

        graph.dfs("A"); */
    }

    private static void testBfs(){
        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");

        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орёл");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула",100);
        graph.addEdge("Москва","Рязань",100);
        graph.addEdge("Москва","Калуга",220);

        graph.addEdge("Тула","Липецк",100);
        graph.addEdge("Липецк","Воронеж",200);

        graph.addEdge("Рязань","Тамбов",150);
        graph.addEdge("Тамбов","Саратов",10);
        graph.addEdge("Саратов","Воронеж",30);

        graph.addEdge("Калуга","Орёл",30);
        graph.addEdge("Орёл","Курск",20);
        graph.addEdge("Курск","Воронеж",500);

        graph.bfs("Москва");
    }
}

