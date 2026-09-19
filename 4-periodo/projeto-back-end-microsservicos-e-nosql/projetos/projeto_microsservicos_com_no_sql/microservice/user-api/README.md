# User API

Microsserviço responsável pelo gerenciamento de usuários.

## Porta
- 8085

## Endpoints
- GET /user - Lista todos os usuários
- GET /user/{id} - Busca usuário por ID
- GET /user/{cpf}/cpf - Busca usuário por CPF
- GET /user/search - Busca usuários por nome
- GET /user/pageable - Lista usuários com paginação
- POST /user - Cria novo usuário
- PUT /user/{id} - Atualiza usuário
- PATCH /user/{id} - Atualiza parcialmente usuário
- DELETE /user/{id} - Remove usuário

## Banco de Dados
- MongoDB
- Database: userdb
