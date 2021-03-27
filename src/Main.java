import java.lang.*;
//Victor Manuel Osorio Garcia
//Anderson Valencia Bermudez
//El codigo fue sacado de esta pagina y lo modificamos para que en vez de enteros recibiera valores double y tambien que mostrara los nodos desde uno
//https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/
public class Main {

    static class Graph_Shortest_Path {

        static final int num_Vertices = 28;  //max number of vertices in graph

        // find a vertex with minimum distance
        double minDistance(double path_array[], Boolean sptSet[]) {
            // Initialize min value
            double min = Double.MAX_VALUE, min_index = Double.valueOf(-1);
            for (int v = 0; v < num_Vertices; v++)
                if (sptSet[v] == false && path_array[v] <= min) {
                    min = path_array[v];
                    min_index = Double.valueOf(v);
                }

            return min_index;
        }

        // print the array of distances (path_array)
        void printMinpath(double path_array[]) {
            System.out.println("Vertex# \t Minimum Distance from Source");
            for (int i = 0; i < num_Vertices; i++)
                System.out.println((i + 1) + " \t\t\t " + path_array[i]);
        }

        // Implementation of Dijkstra's algorithm for graph (adjacency matrix)
        void algo_dijkstra(double graph[][], Double src_node) {
            double path_array[] = new double[num_Vertices]; // The output array. dist[i] will hold
            // the shortest distance from src to i

            // spt (shortest path set) contains vertices that have shortest path
            Boolean sptSet[] = new Boolean[num_Vertices];

            // Initially all the distances are INFINITE and stpSet[] is set to false
            for (int i = 0; i < num_Vertices; i++) {
                path_array[i] = Double.MAX_VALUE;
                sptSet[i] = false;
            }

            // Path between vertex and itself is always 0
            path_array[src_node.intValue()] = Double.valueOf(0);
            // now find shortest path for all vertices
            for (int count = 0; count < num_Vertices - 1; count++) {
                // call minDistance method to find the vertex with min distance
                double u = minDistance(path_array, sptSet);
                // the current vertex u is processed
                sptSet[(int) u] = true;
                // process adjacent nodes of the current vertex
                for (int v = 0; v < num_Vertices; v++)

                    // if vertex v not in sptset then update it
                    if (!sptSet[v] && graph[(int) u][v] != 0 && path_array[(int) u] != Double.MAX_VALUE && path_array[(int) u] + graph[(int) u][v] < path_array[v])
                        path_array[v] = path_array[(int) u] + graph[(int) u][v];
            }

            // print the path array
            printMinpath(path_array);
        }
    }

    static class Main2 {
        public static void main(String[] args) {
            //example graph is given below
            double graph[][] = new double[][]{
                    {0, 6, 1.4, 2.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {6, 0, 2, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1.4, 2, 0, 0, 0, 9.9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {2.5, 0, 0, 0, 0, 8.2, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 0, 0, 0, 7, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 9.9, 8.2, 7, 0, 0, 0, 14, 16.9, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 20, 0, 0, 0, 14, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 14, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8.5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 14, 18, 16, 0, 9, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 16.9, 0, 0, 9, 0, 16, 0, 0, 0, 0, 6.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 16, 18, 0, 0, 0, 16, 0, 20, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 8, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4.3, 0, 0, 0, 0, 0, 0, 0, 0, 3.5, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 6.5, 0, 0, 5, 0, 4.3, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 11, 0, 12, 0, 0, 0, 0, 2, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 10.8, 0, 0, 0, 0, 0, 0, 11, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 8.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 4.3, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 4.3, 0, 7, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 1.7, 0, 0, 15.2, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.7, 0, 1.5, 15.3, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.5, 0, 0, 0, 0, 3, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15.3, 0, 0, 0, 2.8, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3.5, 0, 2, 0, 0, 0, 15.2, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2.8, 1, 0, 0, 2},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 0, 0, 4},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0}};
            System.out.println("VICTOR MANUEL OSORIO GARCIA - ANDERSON VALENCIA BERMUDEZ");
            System.out.println("De aca hacia abajo el codigo que encontramos muestra todos los caminos más cortos a cada nodo desde el nodo inicial que es A");
            Graph_Shortest_Path g = new Graph_Shortest_Path();
            g.algo_dijkstra(graph, Double.valueOf(0));
            System.out.println("Despues de analizar bien y teniendo en cuanta como construimos la matriz (que fue en excel) sabemos que el nodo W es el 23");
            System.out.println("Ahora el camino que realiza este algoritmo hasta llegar a ese punto es: ");
            System.out.println("1-> 4-> 6-> 10-> 16-> 15-> 25-> 26-> 28-> 27-> 23");
            System.out.println("Este camino con el nombre de los nodos es: ");
            System.out.println("A-> D-> F-> J-> P-> O-> Y-> Z-> AB-> AA-> W");
            System.out.println("Nuevamente la referencia y saber que el codigo fue sacado de esta pagina y lo modificamos para que en vez de enteros recibiera valores double y tambien que mostrara los nodos desde uno");
            System.out.println("https://www.softwaretestinghelp.com/dijkstras-algorithm-in-java/");
        }
    }

    //Organizando la matriz de excel añadiendole las comas y cambiando comas por puntos
    /*
    public static void main(String[] args) {
        double[][] matrizAdyacencia = {{0, 6, 1.4, 2.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {6, 0, 2, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 4, 2, 0, 0, 0, 9.9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {2.5, 0, 0, 0, 0, 8.2, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 7, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9.9, 8.2, 7, 0, 0, 0, 14, 16, 9, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 20, 0, 0, 0, 14, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 14, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8.5, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 14, 18, 16, 0, 9, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 16.9, 0, 0, 9, 0, 16, 0, 0, 0, 0, 6.5, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 16, 18, 0, 0, 0, 16, 0, 20, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 8, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4.3, 0, 0, 0, 0, 0, 0, 0, 0, 3.5, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 6.5, 0, 0, 5, 0, 4.3, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 11, 0, 12, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 10.8, 0, 0, 0, 0, 0, 0, 11, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 8.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 4.3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 4.3, 0, 7, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 1.7, 0, 0, 15.2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.7, 0, 1.5, 15.3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.5, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15.3, 0, 0, 0, 2.8, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3.5, 0, 2, 0, 0, 0, 15.2, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2.8, 1, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 0}};
    }
     */

}
