package PrimAlgorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrimGraphDataGenerator {
    private static final Random random = new Random();

    public static void main(String[] args) {
        generateGraphFile("prim_graph_data.txt", 57); // один граф
    }

    public static void generateGraphFile(String filename, int testCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int testNum = 1; testNum <= testCount; testNum++) {
                int vertices = 100 + random.nextInt(9901);;
                int extraEdges = vertices / 2;
                int totalEdges = (vertices - 1 + extraEdges) * 2;

                writer.write(vertices + " " + totalEdges + "\n");

                for (int i = 1; i < vertices; i++) {
                    int to = i;
                    int from = random.nextInt(i);
                    int weight = 1 + random.nextInt(1000);
                    writer.write(from + " " + to + " " + weight + "\n");
                    writer.write(to + " " + from + " " + weight + "\n");
                }

                for (int i = 0; i < extraEdges; i++) {
                    int from = random.nextInt(vertices);
                    int to = random.nextInt(vertices);
                    while (from == to) to = random.nextInt(vertices);
                    int weight = 1 + random.nextInt(1000);
                    writer.write(from + " " + to + " " + weight + "\n");
                    writer.write(to + " " + from + " " + weight + "\n");
                }

                writer.write("\n");
            }
            System.out.println("Файл " + filename + " успешно создан.");
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
