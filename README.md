# Prueba Técnica

## 1. Intervalos de Tiempo
Fusiona una lista de intervalos superpuestos y devuelve el resultado ordenado.
Resuelto - ver carpeta `intervalos/`.

## 2. Uso de IA en Desarrollo (Vibe Coding)
API REST en Spring Boot 4.1.1 / Java 17.

## Endpoint
**POST** `/portfolio/calculate`

### Request
```json
{
  "assets": [
    { "name": "AAPL", "amount": 1000, "return": 0.05 },
    { "name": "TSLA", "amount": 500, "return": -0.02 },
    { "name": "BOND", "amount": 1500, "return": 0.02 }
  ]
}
```

### Response
```json
{
  "total": 3000,
  "weighted_return": 0.02,
  "best_asset": "AAPL",
  "worst_asset": "TSLA"
}
```

## Como correrlo

### Opcion 1 — Local (IntelliJ / Maven)
1. Abrir el proyecto en IntelliJ.
2. Ejecutar `MiniApiSpringBootApplication`.
3. La API queda disponible en `http://localhost:8080`.

### Opcion 2 — Docker
```bash
docker compose build
docker compose up
```
La API queda disponible igual en `http://localhost:8080`.

## Manejo de errores

La API valida el request antes de calcular y responde `400 Bad Request` con un
mensaje descriptivo en vez de un error generico.
---

## Uso de IA en el desarrollo

### 1. Prompts utilizados

- Tengo esta prueba tecnica de Spring Boot, ya resolvi la primera parte
  (intervalos). Para esta necesito una API que calcule metricas de un
  portafolio (total, retorno ponderado, mejor/peor activo). Ayudame a
  entender que necesito y arma la estructura de carpetas (controller,
  service, DTOs, manejo de errores).
- ¿Como evito la division por cero si el total del portafolio da 0?"
- Ayudame a armar el Dockerfile y docker-compose para levantar esto
  en un contenedor.

### 2. Que codigo genero la IA

**Genero:** estructura por capas (controller, service, dto, exception), DTOs, la logica de calculo del portafolio, el endpoint REST, manejo de errores y los archivos de Docker.

**Acepte:**
- La estructura de carpetas por capa (controller/service/dto/exception).
- La logica de calculo del total, retorno ponderado y mejor/peor activo.
- El Dockerfile multi-stage y el docker-compose.

### 3. Validacion

- Probe el endpoint desde Postman con el ejemplo del enunciado.
- Verifique el calculo a mano: (1500*0.02 + 1000*0.05 + 500*-0.02) / 3000 = 0.0233
- Probe casos de error en Postman.
- Lista de assets vacia.
- Monto negativo.
- El monto debe ser mayor en 0 (division por cero).
- Campo obligatorio faltante.

### 4. Reflexion

**¿Donde ayudo la IA?**
- Para armar rapido la estructura base del proyecto (capas, DTOs, service, controller) sin perder tiempo en el boilerplate inicial.
- Para resolver problemas puntuales de Java/Spring

**¿Donde fue un problema?**
- El codigo generado inicialmente no siempre coincidia con lo que yo terminaba necesitando

**¿Que harias diferente?**
- Pedirle a la IA que me explicara el codigo *antes* de aceptarlo, no despues - varias veces genere codigo primero y recien despues pregunte como funcionaba.
