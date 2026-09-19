# pedido-service — o que implementar

Responsavel pelas rotas de **Pedido** e **DetalhePedido** (migradas do
monolito `ProjetoBackEndMonolticoORM2026/e-commerce`). E o servico que mais
muda em relacao ao monolito, pois passa a **consumir** o `catalogo-service`
em vez de acessar `Produto` diretamente.

Pacotes sugeridos dentro de `br.edu.iftm.pbackorm.pedido_service`:

- `domain/` — `Pedido` e `DetalhePedido` como documentos MongoDB
  (`@Document`). `DetalhePedido` guarda apenas `produtoId` (Integer/String),
  **sem** `@ManyToOne` para `Produto` (ver slide 2, "Ajustando
  DetalhePedido"/"Ajustando Pedido").
- `dto/` — `PedidoDTO`, `DetalhePedidoDTO` (+ mapper).
- `repository/` — `PedidoRepository` estendendo `MongoRepository`.
- `client/` — `CatalogoClient`, chamando
  `PUT {services.catalogo-service.url}/{id}/baixar-estoque` via
  `RestClient` (ver slide 2, paginas 27-29). Opcionalmente `ClienteClient`
  para validar o cliente do pedido.
- `config/` — `RestClientConfig` expondo o bean `RestClient.Builder`.
- `service/` — `PedidoService.salvar()` percorre os detalhes do pedido e
  chama `catalogoClient.baixarEstoque(...)` para cada item. **Atencao**:
  `@Transactional` so cobre o banco local; falhas parciais entre servicos
  exigem o padrao de compensacao (Saga / reserva de estoque — ver slide 2,
  paginas 36-37) — nao ha rollback automatico entre microsservicos.
- `controller/` — `PedidoController` com o CRUD de pedido.
- `exception/` — excecoes de negocio e handler global.

As URLs dos outros servicos ja estao configuraveis em `application.yml`
(`services.catalogo-service.url`, `services.cliente-service.url`).

## Checklist
- [ ] Entidades como `@Document`, sem relacionamento JPA entre servicos
- [ ] `CatalogoClient` consumindo `catalogo-service`
- [ ] `PedidoService.salvar()` baixando estoque via client
- [ ] Estrategia para falha parcial (documentar no README/docs, mesmo que a
      implementacao completa da Saga fique para uma etapa futura)
- [ ] CRUD de Pedido
- [ ] application.yml conferido (porta 8083, Mongo, URLs dos servicos)
