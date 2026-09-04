package com.Prueba.MiniAPISpringBoot.dto;

public class PortfolioResponse {

    private double total;
    private double weightedReturn;
    private String bestAsset;
    private String worstAsset;

    public PortfolioResponse(double total, double weightedReturn, String bestAsset, String worstAsset) {
        this.total = total;
        this.weightedReturn = weightedReturn;
        this.bestAsset = bestAsset;
        this.worstAsset = worstAsset;
    }

    public double getTotal() { return total; }
    public double getWeightedReturn() { return weightedReturn; }
    public String getBestAsset() { return bestAsset; }
    public String getWorstAsset() { return worstAsset; }
}