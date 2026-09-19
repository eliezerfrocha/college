# catalogo-service — o que implementar

Responsavel pelas rotas de **Produto** e **Categoria** (migradas do monolito
`ProjetoBackEndMonolticoORM2026/e-commerce`).

Pacotes sugeridos dentro de `br.edu.iftm.pbackorm.catalogo_service`:

- `domain/` — `Categoria` e `Produto` como **documentos MongoDB** (`@Document`),
  nao mais `@Entity` JPA. Sem `@ManyToOne`/`@OneToMany` para outros
  microsservicos (ver slide 2, "Relacionamentos JPA").
- `dto/` — `CategoriaDTO`, `ProdutoDTO` (+ mapper, manual ou com MapStruct).
- `repository/` — `CategoriaRepository`/`ProdutoRepository` estendendo
  `MongoRepository`.
- `service/` — regras de negocio, incluindo o metodo `atualizarEstoque`
  (baixa de estoque), que antes ficava no `pedido-service` do monolito.
- `controller/` — `CategoriaController`, `ProdutoController` com os mesmos
  endpoints do monolito, mais:
  - `PUT /{id}/baixar-estoque` — usado pelo `pedido-service` via
    `CatalogoClient` (ver slide 2, paginas 28-32).
- `exception/` — `EstoqueInsuficienteException` e handler global
  (`@RestControllerAdvice`).

## Checklist
- [ ] Entidades como `@Document`
- [ ] Repositories `MongoRepository`
- [ ] CRUD de Categoria e Produto
- [ ] Endpoint de baixar-estoque
- [ ] application.yml conferido (porta 8081, Mongo)
