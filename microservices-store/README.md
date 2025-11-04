# Microservices Store - Arquitetura Hexagonal com Spring Boot e Docker

Este repositório apresenta uma arquitetura de microserviços para uma loja de roupas, adaptada para seguir o padrão de **Arquitetura Hexagonal** (Ports and Adapters) e utilizando **Spring Boot** e **Docker Compose** para orquestração.

A estrutura foi baseada no template fornecido pelo professor (`1146AN-nginx-main`) e o sistema de loja (`demo-main`) foi refatorado para o novo modelo.

## 1. Serviços Criados

O sistema é composto pelos seguintes microserviços:

| Serviço | Descrição | Porta Exposta | Baseado em `demo-main` |
| :--- | :--- | :--- | :--- |
| `service-discovery` | Servidor Eureka para registro e descoberta de serviços. | `8080` | Template |
| `auth-service` | Serviço de autenticação e autorização (JWT). Roles simplificadas para `ROLE_USER` e `ROLE_ADMIN`. | `8084` | Template |
| `gateway-service` | API Gateway (Spring Cloud Gateway) para roteamento e segurança. | `8083` | Template |
| `user-service` | Gerencia o cadastro e perfil dos usuários. | `8086` | `UsuarioController`, `PerfilController` |
| `product-service` | Gerencia o catálogo de produtos da loja. | `8081` | `ProdutoController`, `Produto.java` |
| `order-service` | Gerencia pedidos, carrinho e itens de pedido. | `8082` | `CarrinhoController`, `PedidoController` |
| `postgres` | Banco de dados relacional PostgreSQL para persistência de dados. | `5432` | Novo |
| `nginx` | Servidor web para proxy reverso e balanceamento de carga. | `80` | Template |

## 2. Arquitetura Utilizada: Hexagonal (Ports and Adapters)

Cada microserviço de negócio (`user-service`, `product-service`, `order-service`) segue rigorosamente o padrão de Arquitetura Hexagonal, com a seguinte organização de pacotes:

*   **`domain/`**: Contém a lógica de negócio central (Entidades, Agregados, Repositórios - interfaces). É o *Core* da aplicação, independente de tecnologia.
*   **`application/`**: Contém os casos de uso (Use Cases/Handlers) que orquestram a lógica de domínio. Representa as **Portas de Entrada** (Input Ports).
*   **`infrastructure/`**: Contém os adaptadores de tecnologia (JPA, Configurações, Segurança). Implementa as interfaces de Repositório (Portas de Saída).
*   **`interfaces/rest/`**: Contém os controladores REST e DTOs (Data Transfer Objects). Representa os **Adaptadores de Entrada** (Driving Adapters).

## 3. Passos para Rodar via Docker

Certifique-se de ter o **Docker** e o **Docker Compose** instalados em sua máquina.

1.  **Construir as imagens dos serviços:**
    ```bash
    docker-compose build
    ```

2.  **Iniciar os contêineres:**
    ```bash
    docker-compose up
    ```
    Os serviços serão iniciados, incluindo o banco de dados PostgreSQL, o Eureka Server, o Gateway e os microserviços de negócio.

3.  **Acessar a aplicação:**
    O `nginx` está configurado para expor o `gateway-service` na porta `80`.

    *   **Eureka Dashboard:** `http://localhost:8080`
    *   **API Gateway:** `http://localhost`

## 4. Endpoints Principais

Todos os endpoints são acessados através do `gateway-service` na porta `80` (ou `8083` se acessar diretamente o gateway).

| Serviço | Endpoint Base (via Gateway) | Descrição |
| :--- | :--- | :--- |
| `auth-service` | `/auth` | Autenticação, login e geração de tokens. |
| `user-service` | `/users` | Cadastro e consulta de usuários. |
| `product-service` | `/products` | Listagem e detalhes de produtos. |
| `order-service` | `/orders` | Criação e consulta de pedidos. |

### Exemplos de Endpoints

| Método | Caminho | Serviço | Descrição |
| :--- | :--- | :--- | :--- |
| `POST` | `/users` | `user-service` | Cria um novo usuário. |
| `GET` | `/users/{id}` | `user-service` | Busca um usuário por ID. |
| `GET` | `/products` | `product-service` | Lista todos os produtos. |
| `GET` | `/products/{id}` | `product-service` | Busca um produto por ID. |
| `POST` | `/orders` | `order-service` | Cria um novo pedido. |
| `GET` | `/orders/user/{userId}` | `order-service` | Lista pedidos de um usuário. |
| `POST` | `/auth/login` | `auth-service` | Realiza login e retorna token JWT. |
| `POST` | `/auth/register` | `auth-service` | Registra um novo usuário (se configurado). |

---
*Desenvolvido por Manus AI*
