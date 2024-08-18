
# Documentação do Projeto API de Vendedores## Sumário1. [Visão Geral](#visão-geral)
2. [Configuração do Ambiente](#configuração-do-ambiente)
3. [Construção e Execução do Docker](#construção-e-execução-do-docker)
4. [Endpoints da API](#endpoints-da-api)
   - [Criar Vendedor](#criar-vendedor)
   - [Buscar Todos os Vendedores](#buscar-todos-os-vendedores)
   - [Buscar Vendedor por ID](#buscar-vendedor-por-id)
   - [Atualizar Vendedor](#atualizar-vendedor)
   - [Deletar Vendedor](#deletar-vendedor)

## Visão Geral

    Este projeto é uma API RESTful para gerenciar vendedores, incluindo operações CRUD (Create, Read, Update, Delete). A aplicação é desenvolvida com Spring Boot e usa Docker para containerização.

## Configuração do Ambiente
1. **Clone o Repositório**
```
   git clone https://github.com/SidMiranda/desafio-backend-api-casas-bahia
```

2. **Configuração do Banco de Dados**

    Certifique-se de ter um banco de dados MySQL configurado. O nome do banco de dados deve ser db-desafio. Configure a conexão do banco de dados no arquivo application.properties.

Configuracao do application.properties
```
spring.application.name=api-vendedores

#LOCALHOST
spring.datasource.url=jdbc:mysql://localhost:3306/db-desafio

#DOCKER
#spring.datasource.url=jdbc:mysql://db:3306/db-desafio

#DEFAULT
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
```
    
## Construção e Execução do Docker
**Construir a imagem Docker**

```bash
    docker-compose up --build
```
    
    A aplicação estará disponível em http://localhost:8080.

## Endpoints da API
    
1. **Criar Vendedor**
    
    Endpoint: POST /vendedores

    Body do Request:

```json
    {
        "nome":"Sidney Miranda",
        "cpfOuCnpj":"172.437.783-09",
        "email":"sidney.miranda2013@gmail.com",
        "tipoContratacao":"CLT",
        "dataNascimento":"1985-07-05",
        "filialId":2
    }
```

    Resposta:

```
    Objeto criado + id + matricula gerada
```


2. **Buscar Todos os Vendedores**

    Endpoint: GET /vendedores

    Resposta:

```
    {
        "id": 2,
        "matricula": "12345378-CLT",
        "nome": "Sidney Miranda",
        "dataNascimento": "1985-05-15",
        "cpfOuCnpj": "123.436.784-01",
        "email": "sidney.miranda@example.com.br",
        "tipoContratacao": "",
        "filialId": 2,
        "filial": {
            "id": 2,
            "nome": "Filial 2",
            "cnpj": "12345678901234",
            "cidade": "São Paulo",
            "uf": "SP",
            "tipo": "Matriz",
            "ativo": true,
            "dataCadastro": "2024-08-18",
            "ultimaAtualizacao": "2024-08-18"
        }
    },
```

3. **Buscar Vendedor por ID**
    
    Endpoint: GET /vendedores/{id}

4. **Atualizar Vendedor**

    Endpoint: PUT /vendedores/{id}

5. **Deletar Vendedor**

    Endpoint: DELETE /vendedores/{id}


