# Textus 
Projeto de um E-commerce de venda de Roupas, usando Springboot e Supabase.

Grupo:
- Caiki de Melo Milani
- Caio Notare Ramires
- Luccas Gabriel Farias de Souza
- Thyago Vinicius Farias de Souza

Dependências:
- Lombok
- SpringDataJPA
- Postgresql
- Spring Web
- Swagger
- OpenFeign
- Spring Cloud Gateway

Inicialização dos Microserviços e Gateway:
```
mvn spring-boot:run
```

Acessar Swagger pelo navegador no link:
```
http://localhost:8080/swagger-ui.html
```

Diagrama:

![diagrama](https://github.com/C41K1/Projeto-Springboot/blob/main/diagrama.png)

Gateway: Porta 8080

Microserviços:
- Produto: Porta 8081
    - Visualizar Todos os Produtos.
    - Filtrar Produto por ID.
    - Cadastrar Produto.
    - Editar Produto.
-  Usuário: Porta 8082
    - Filtrar Usuario por ID.
    - Cadastro.
    - Login.
- Venda: Porta 8083
    - Cadastrar Venda.
    - Consultar Venda por ID.
 

