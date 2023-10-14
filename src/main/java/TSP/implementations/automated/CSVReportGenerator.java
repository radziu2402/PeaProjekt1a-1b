package TSP.implementations.automated;

import TSP.algorithms.AlgorithmResult;
import TSP.measurement.MeasuredAlghorithmResult;
import TSP.utils.ReportGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class CSVReportGenerator implements ReportGenerator {
    private final HashMap<Integer, Integer> resultsForCsv = new HashMap<>();
    private final HashMap<Integer, Integer> numberOfResultsForCsv = new HashMap<>();
    private final ArrayList<MeasuredAlghorithmResult> results = new ArrayList<>();

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Liczba wierzchołków;Koszt\n");
        for (MeasuredAlghorithmResult result : results) {
            AlgorithmResult algorithmResult = result.getAlgorithmResult();
            int numberOfVertices = algorithmResult.getNumberOfVertices();
            if(resultsForCsv.containsKey(numberOfVertices)) {
                resultsForCsv.replace(numberOfVertices, resultsForCsv.get(numberOfVertices) + algorithmResult.getMinCost());
                numberOfResultsForCsv.replace(numberOfVertices, numberOfResultsForCsv.get(numberOfVertices) + 1);
            } else {
                resultsForCsv.put(numberOfVertices, algorithmResult.getMinCost());
                numberOfResultsForCsv.put(numberOfVertices, 1);
            }
        }

        for (int nOfVertices : resultsForCsv.keySet()) {
            int result = resultsForCsv.get(nOfVertices)/numberOfResultsForCsv.get(nOfVertices);
                report.append(nOfVertices);
                report.append(';');
                report.append(result);
                report.append('\n');
        }

        return report.toString();
    }

    @Override
    public void addToReport(MeasuredAlghorithmResult result) {
        results.add(result);
    }
}
