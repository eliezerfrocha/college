# Product API

Microsserviço responsável pelo gerenciamento de produtos e categorias.

## Porta
- 8083

## Endpoints

### Categories
- GET /category - Lista todas as categorias
- GET /category/pageable - Lista categorias com paginação
- POST /category - Cria nova categoria
- PUT /category/{id} - Atualiza categoria
- DELETE /category/{id} - Remove categoria

### Products
- GET /product - Lista todos os produtos
- GET /product/{id} - Busca produto por ID
- GET /product/pageable - Lista produtos com paginação
- GET /product/category/{categoryId} - Lista produtos por categoria
- GET /product/identifier/{productIdentifier} - Busca produto por identificador
- POST /product - Cria novo produto
- PUT /product/{id} - Atualiza produto
- DELETE /product/{id} - Remove produto

## Banco de Dados
- MongoDB
- Database: productdb
