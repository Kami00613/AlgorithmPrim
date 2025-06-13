package PrimAlgorithm;

import java.io.IOException;
import java.util.List;

public class TestPrim {
    public static void main(String[] args) {
        PrimGraphDataGenerator.main(args);
        String filename = "prim_graph_data.txt";

        try {
            int vertexCount = FileReader.getVertexCount(filename);
            List<PrimAlgorithm.Edge> edges = FileReader.readEdges(filename);

            System.out.println("Тестируем граф: " + vertexCount + " вершин и " + edges.size() + " ребер");

            long startTime = System.nanoTime();
            List<PrimAlgorithm.Edge> mst = PrimAlgorithm.primMST(edges, vertexCount);
            long duration = System.nanoTime() - startTime;

            int totalWeight = mst.stream().mapToInt(e -> e.weight).sum();

            System.out.println("Результат:");
            System.out.println("- Ребер в MST: " + mst.size());
            System.out.println("- Сумма весов MST: " + totalWeight);
            System.out.println("- Время работы: " + duration + " нс");
            System.out.println("- Количество итераций: " + PrimAlgorithm.iterationCounter);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
