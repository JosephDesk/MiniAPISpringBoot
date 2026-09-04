package com.Prueba.MiniAPISpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AssetDto {

    @NotBlank(message = "El nombre del activo es obligatorio")
    private String name;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double amount;

    @NotNull(message = "El retorno es obligatorio")
    private Double returnValue;

    public AssetDto() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    @JsonProperty("return")
    public Double getReturnValue() { return returnValue; }

    @JsonProperty("return")
    public void setReturnValue(Double returnValue) { this.returnValue = returnValue; }
}