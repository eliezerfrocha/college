# E-commerce — Microsserviços

Decomposição do monólito `e-commerce` (disciplina Back-End Monolítico/ORM)
em microsserviços, com persistência NoSQL (MongoDB) e um API Gateway como
porta única de entrada — conforme os Slides 1-3 da disciplina **Projeto
Back-End Microsserviços e NoSQL** (Prof. Carlos Eduardo Dantas, IFTM).

## Serviços

| Serviço | Responsabilidade | Porta | Banco |
|---|---|---|---|
| `api-gateway` | Porta única de entrada (Spring Cloud Gateway) | 8080 | — |
| `catalogo-service` | Produto e Categoria | 8081 | MongoDB (`catalogo`) |
| `cliente-service` | Cliente (com validação de CEP via ViaCEP) | 8082 | MongoDB (`cliente`) |
| `pedido-service` | Pedido e DetalhePedido (consome catalogo-service) | 8083 | MongoDB (`pedido`) |

## Rotas via API Gateway

| Recurso | Sem Gateway | Com Gateway |
|---|---|---|
| Catálogo | `localhost:8081/produtos` | `localhost:8080/catalogo/produtos` |
| Clientes | `localhost:8082/clientes` | `localhost:8080/clientes` |
| Pedidos | `localhost:8083/pedidos` | `localhost:8080/pedidos` |

## Cada serviço é um projeto Spring Boot independente

Cada pasta (`api-gateway/`, `catalogo-service/`, `cliente-service/`,
`pedido-service/`) tem seu próprio `src/`, `pom.xml` e `Dockerfile`, e pode
ser aberta/rodada separadamente (ex: `File > Open` no IntelliJ/VS Code
apontando para a pasta do serviço).

Cada serviço tem um `TODO.md` com a lista do que falta implementar —
partindo das classes já existentes no monólito.

## Como rodar

### Localmente (sem Docker), um serviço por vez

Cada serviço precisa de um MongoDB acessível em `localhost:27017` (ajuste
via variável de ambiente `MONGODB_URI` se necessário):

```bash
cd catalogo-service && ./mvnw spring-boot:run
cd cliente-service  && ./mvnw spring-boot:run
cd pedido-service   && ./mvnw spring-boot:run
cd api-gateway      && ./mvnw spring-boot:run
```

### Com Docker Compose (recomendado, ver Slide 3)

```bash
docker compose up -d --build
```

Isso sobe 3 instâncias de MongoDB (uma por serviço), os 3 microsserviços e
o `api-gateway`, todos na mesma rede Docker, se comunicando pelo nome do
serviço (ex: `catalogo-service`, `catalogo-mongo`).

Para derrubar tudo:

```bash
docker compose down
```

## Roteiro da disciplina (conteúdo programático)

- [x] 1. Arquitetura de Microsserviços — decomposição do monólito, API Gateway
- [x] 2. Conteinerização — Dockerfile por serviço + `docker-compose.yml`
- [ ] 3. Comunicação entre microsserviços — RestClient/OpenFeign (síncrono),
      RabbitMQ (assíncrono)
- [ ] 4. Persistência — Spring Data MongoDB / `MongoRepository` em cada
      serviço (estrutura pronta, entidades/repos a implementar)
- [ ] 5. Implantação em nuvem

## Avaliação (conforme Slide 1)

- Apresentação parcial da arquitetura e dos resultados (30 pts)
- Conclusão da implementação dos requisitos da aplicação (30 pts)
- Implantação e apresentação final do projeto (40 pts)
