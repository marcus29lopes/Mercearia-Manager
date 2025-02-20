## Listagem Genérica de Dados com JDBC

### Introdução

Este repositório contém a implementação de um método genérico para listar registros do banco de dados utilizando JDBC. O método executa uma consulta SQL, aplica uma função de extração de dados e retorna uma lista de objetos do tipo desejado. Ele também suporta a passagem de parâmetros para consultas parametrizadas.

### Objetivos

- Executar uma consulta SQL de forma segura utilizando `PreparedStatement`.
- Permitir a extração de dados dinâmica por meio de uma função `Function<ResultSet, T>`.
- Oferecer suporte à passagem de parâmetros para evitar SQL Injection.
- Retornar uma lista de objetos do tipo genérico `T`.
- Garantir fechamento automático dos recursos do banco de dados com `try-with-resources`.

### Requisitos Funcionais

#### Listagem de Dados

- O sistema deve permitir executar consultas SQL dinâmicas.
- Deve permitir a extração de dados para diferentes tipos de objetos através de uma função de conversão.
- Deve permitir o uso de parâmetros para tornar a consulta segura.
- Deve retornar uma lista de objetos contendo os dados consultados.

#### Tratamento de Erros

- Caso ocorra um erro na execução da consulta, uma exceção `RuntimeException` deve ser lançada encapsulando a `SQLException` original.

