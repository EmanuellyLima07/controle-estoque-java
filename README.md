Sistema de Controle de Estoque (Java + MySQL)


Este projeto é um sistema simples de controle de estoque desenvolvido em Java,
utilizando Programação Orientada a Objetos (POO) e banco de dados MySQL.

O objetivo é permitir o cadastro, consulta e organização de produtos de diferentes categorias:
Eletrônicos, Roupas, Perecíveis e Ferramentas.


Tecnologias utilizadas:
- Java 17
- MySQL / MariaDB
- JDBC
- IntelliJ IDEA
- Git & GitHub

Estrutura do projeto:
/src
/model → classes de modelo (ProdutoBase, Eletronicos, Perecivel...)
/dao → classes de acesso ao banco de dados

/sql
controle_estoque.sql → Script completo para criar o banco e os dados


O arquivo controle_estoque.sql contém:
- criação do banco controle_estoque
- criação das tabelas
- chaves estrangeiras
- dados iniciais para teste


Como importar o banco:
1. Abra o phpMyAdmin ou qualquer cliente MySQL
2. Clique em Importar
3. Selecione: sql/controle_estoque.sql
4. Execute


Funcionalidades implementadas:
- Cadastro de produtos
- Consulta de produtos por categoria
- Atualização de estoque
- Exclusão de itens
- Relacionamento com herança (ProdutoBase → subclasses)
- Integração com MySQL via JDBC


Como executar o projeto:
1. Clone o repositório:
git clone https://github.com/EmanuellyLima07/controle-estoque-java
2. Abra o projeto no IntelliJ
3. Configure o arquivo de conexão
4. Execute a classe principal (Main)


Autora:
Emanuelly Araújo
Projeto acadêmico desenvolvido para a disciplina de Programação Orientada a Objetos.
