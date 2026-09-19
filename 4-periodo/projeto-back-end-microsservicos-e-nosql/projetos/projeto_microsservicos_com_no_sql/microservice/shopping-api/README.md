# Shopping API

Microsserviço responsável pelo gerenciamento de compras.

## Porta
- 8087

## Endpoints
- GET /shopping - Lista todas as compras
- GET /shopping/{id} - Busca compra por ID
- GET /shopping/shopByUser - Lista compras por usuário
- GET /shopping/shopByDate - Lista compras por data
- GET /shopping/product/{productIdentifier} - Lista compras por produto
- GET /shopping/search - Busca compras com filtros
- GET /shopping/report - Relatório de compras por data
- POST /shopping - Cria nova compra

## Banco de Dados
- MongoDB
- Database: shoppingdb
