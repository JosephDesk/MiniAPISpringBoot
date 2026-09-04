package com.Prueba.MiniAPISpringBoot.controller;

import com.Prueba.MiniAPISpringBoot.dto.PortfolioRequest;
import com.Prueba.MiniAPISpringBoot.dto.PortfolioResponse;
import com.Prueba.MiniAPISpringBoot.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<PortfolioResponse> calculate(@Valid @RequestBody PortfolioRequest request) {
        return ResponseEntity.ok(portfolioService.calculate(request));
    }
}