# Projeto Back-End Microsserviços e NoSQL — 2026

Instituto Federal do Triângulo Mineiro — Campus Uberlândia Centro
Curso Superior de Tecnologia em Sistemas para Internet
Prof. Carlos Eduardo de Carvalho Dantas

Repositório do projeto da disciplina: decomposição do e-commerce
monolítico em microsserviços com Spring Boot, MongoDB e Docker.

O código vive em [`ecommerce-microservices/`](./ecommerce-microservices),
que contém o `api-gateway` e os três microsserviços (`catalogo-service`,
`cliente-service`, `pedido-service`) — veja o README daquela pasta para
detalhes de arquitetura e como rodar o projeto.

`docs/` guarda diagramas e decisões de arquitetura produzidos ao longo da
disciplina.

## Sobre o uso de IA

Este scaffold (estrutura de pastas, `pom.xml`, `Dockerfile`,
`docker-compose.yml`, rotas do gateway) foi montado com apoio de IA. A
implementação das entidades, controllers, services e regras de negócio de
cada microsserviço é de responsabilidade do aluno, conforme a política da
disciplina (IA como assistente, não como autora).
