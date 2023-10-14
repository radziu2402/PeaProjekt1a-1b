package algorithms;

public class AlghorithmResult {
    /**
     * Array that contains the best possible hamiltonian cycle in graph
     */
    private final int[] bestTour;

    /**
     * Cost associated with best hamiltonian cycle
     */
    private final int minCost;

    AlghorithmResult(int[] bestTour, int minCost) {
        this.bestTour = bestTour;
        this.minCost = minCost;
    }

    public int getMinCost() {
        return this.minCost;
    }

    public int[] getBestTour() {
        return bestTour;
    }
}
