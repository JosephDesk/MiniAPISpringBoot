package com.Prueba.MiniAPISpringBoot.service;

import com.Prueba.MiniAPISpringBoot.dto.AssetDto;
import com.Prueba.MiniAPISpringBoot.dto.PortfolioRequest;
import com.Prueba.MiniAPISpringBoot.dto.PortfolioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    public PortfolioResponse calculate(PortfolioRequest request) {
        List<AssetDto> assets = request.getAssets();

        double total = assets.stream()
                .mapToDouble(AssetDto::getAmount)
                .sum();

        if (total == 0) {
            throw new IllegalArgumentException("La suma total del portafolio no puede ser 0");
        }

        double weightedSum = assets.stream()
                .mapToDouble(a -> a.getAmount() * a.getReturnValue())
                .sum();

        double weightedReturn = weightedSum / total;

        AssetDto best = assets.stream()
                .max((a, b) -> Double.compare(a.getReturnValue(), b.getReturnValue()))
                .orElseThrow();

        AssetDto worst = assets.stream()
                .min((a, b) -> Double.compare(a.getReturnValue(), b.getReturnValue()))
                .orElseThrow();

        return new PortfolioResponse(
                round(total),
                round(weightedReturn),
                best.getName(),
                worst.getName()
        );
    }

    private double round(double value) {
        return Math.round(value * 10000.0) / 10000.0;
    }
}