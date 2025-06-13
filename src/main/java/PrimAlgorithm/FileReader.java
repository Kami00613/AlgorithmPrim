package PrimAlgorithm;

import java.io.*;
import java.util.*;

public class FileReader {
    public static int getVertexCount(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
        return 0;
    }

    public static List<PrimAlgorithm.Edge> readEdges(String filename) throws IOException {
        List<PrimAlgorithm.Edge> edges = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));

        reader.readLine(); // пропускаем первую строку

        String line;
        while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
            String[] parts = line.split(" ");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);
            edges.add(new PrimAlgorithm.Edge(from, to, weight));
        }

        reader.close();
        return edges;
    }
}
