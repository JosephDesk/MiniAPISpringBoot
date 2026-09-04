package com.Prueba.MiniAPISpringBoot.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class PortfolioRequest {

    @NotEmpty(message = "La lista de assets no puede estar vacía")
    @Valid
    private List<AssetDto> assets;

    public List<AssetDto> getAssets() { return assets; }
    public void setAssets(List<AssetDto> assets) { this.assets = assets; }
}