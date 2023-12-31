package TSP.file;

import TSP.data.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//public class FromFileReader {
//    public Matrix loadFromFile() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj nazwę pliku z danymi:");
//        String fileName = scanner.nextLine();
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(fileName));
//            System.out.println("Plik otwarto pomyslnie!");
//            String line;
//            int numCities = 0;
//            int[][] distanceMatrix = null;
//
//            int currentRow = 0;
//            int currentCol = 0;
//
//            while ((line = br.readLine()) != null) {
//                if (line.startsWith("DIMENSION")) {
//                    numCities = Integer.parseInt(line.split(":")[1].trim());
//                    distanceMatrix = new int[numCities][numCities];
//                } else if (line.startsWith("EDGE_WEIGHT_SECTION")) {
//                    while ((line = br.readLine()) != null) {
//                        String[] values = line.trim().split("\\s+");
//                        for (String value : values) {
//                            if (currentRow >= numCities) {
//                                break;
//                            }
//                            distanceMatrix[currentRow][currentCol] = Integer.parseInt(value);
//                            currentCol++;
//                            if (currentCol >= numCities) {
//                                currentCol = 0;
//                                currentRow++;
//                            }
//                        }
//                    }
//                    break;
//                }
//            }
//
//            System.out.println("Dane zostały wczytane.");
//            return new Matrix(distanceMatrix);
//        } catch (IOException e) {
//            System.out.println("Nie udało się otworzyć pliku!");
//        }
//        return null;
//    }
//}
public class FromFileReader {
    public Matrix loadFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku z danymi:");
        String fileName = scanner.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            System.out.println("Plik otwarto pomyslnie!");
            String line;
            int numCities = 0;
            int[][] distanceMatrix = null;

            int currentRow = 0;

            while ((line = br.readLine()) != null) {
                if (numCities == 0) {
                    numCities = Integer.parseInt(line);
                    distanceMatrix = new int[numCities][numCities];
                } else {
                    String[] values = line.trim().split("\\s+");
                    for (int currentCol = 0; currentCol < numCities; currentCol++) {
                        distanceMatrix[currentRow][currentCol] = Integer.parseInt(values[currentCol]);
                    }
                    currentRow++;
                    if (currentRow >= numCities) {
                        break;
                    }
                }
            }

            System.out.println("Dane zostały wczytane.");
            return new Matrix(distanceMatrix);
        } catch (IOException e) {
            System.out.println("Nie udało się otworzyć pliku!");
        }
        return null;
    }
}
