# cliente-service — o que implementar

Responsavel pelas rotas de **Cliente** (migradas do monolito
`ProjetoBackEndMonolticoORM2026/e-commerce`).

Pacotes sugeridos dentro de `br.edu.iftm.pbackorm.cliente_service`:

- `domain/` — `Cliente` como documento MongoDB (`@Document`).
- `dto/` — `ClienteDTO` (+ mapper).
- `repository/` — `ClienteRepository` estendendo `MongoRepository`.
- `client/` — `CorreioClient`, que consulta
  `https://viacep.com.br/ws/{cep}/json/` via `RestClient` para validar o CEP
  (ver slide 2, exercicio "CorreioClient", paginas 33-34).
- `config/` — `RestClientConfig` expondo o bean `RestClient.Builder`.
- `service/` — `ClienteService.salvar()` valida o CEP com `CorreioClient`
  antes de persistir (ver slide 2, pagina 35).
- `controller/` — `ClienteController` com o CRUD de cliente.
- `exception/` — `CamposInvalidosException` (ex: "CEP INVALIDO") e handler
  global.

## Checklist
- [ ] Entidade `Cliente` como `@Document`
- [ ] `CorreioClient` consumindo o ViaCEP
- [ ] Validacao de CEP no `ClienteService`
- [ ] CRUD de Cliente
- [ ] application.yml conferido (porta 8082, Mongo)
