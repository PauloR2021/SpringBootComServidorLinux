# 📦 Projeto Servidor Ubuntu – API de Produtos

API REST desenvolvida com **Spring Boot** para gerenciamento de produtos, incluindo cadastro, listagem, busca por nome, atualização e exclusão.  
Projeto preparado para execução em **servidor Linux (Ubuntu)**, utilizando **MySQL** como banco de dados.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 4
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Ubuntu Server

---

## 📌 Funcionalidades

- Criar produto
- Listar todos os produtos
- Buscar produto por ID
- Buscar produtos por nome (case insensitive)
- Atualizar produto
- Excluir produto
- Tratamento global de exceções
- Retorno padronizado de erros

## 🗂️ Estrutura do Projeto

```
src/main/java/com/pauloricardo/projetoservidorubuntu
├── Controllers
│ └── ProductsController.java
├── Services
│ └── ProductsService.java
├── Repositorys
│ └── ProductsRepository.java
├── Models
│ └── ProductsModel.java
├── Exceptions
│ ├── ResourceNotFoundException.java
│ └── GlobalExceptionHandler.java
└── ProjetoservidorubuntuApplication.java
```

## 🔧 Configuração do Banco de Dados

Arquivo `application.properties` ou `.env.prod`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/serverdb_prod
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🔧 Endpoints da API
```
GET     -   /api/products/test - Retorna a Informação "Test API OK "
GET     -   /api/products/find - Retorna a Lista de Todos os Produtos Cadastrados
GET     -   /api/products/find/id - Retorna a Lista do Produto Cadastrado conforme ID Selecionada
GET     -   /api/products/search?name= - Retorna a Lista de Produtos Cadastrado conforme nome enviado 
POST    -   /api/products/create - Cadastra novos produtos
PUT     -   /api/products/update/id - Atualiza as informações do produto conforme ID passado
DEL     -   /api/products/delete/id - Deletea o produto conforme ID passado.
```

## 👨‍💻 Autor
```
Paulo Ricardo Soares
Tecnólogo em Gestão da Tecnologia da Informação
Desenvolvedor Java | Spring Boot | Backend
```