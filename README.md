# MatchReparo

## Sobre o Projeto

MatchReparo é uma plataforma backend que conecta clientes que necessitam de serviços de reparo com prestadores de serviço especializados. A aplicação é desenvolvida em **Spring Boot** com **Java**, utilizando banco de dados H2 e implementando autenticação segura.

## O que o Projeto Faz

A plataforma permite que:

- **Clientes** (pessoas físicas) se registrem, façam login e gerenciem suas contas na plataforma
- **Prestadores de Serviço** (empresas/profissionais) se registrem, façam login e gerenciem seus perfis
- **Ambos os tipos de usuários** possam atualizar seus dados, visualizar perfis de outros usuários e gerenciar suas informações

O sistema centraliza o gerenciamento de dois tipos de usuários diferentes, cada um com suas características específicas:
- Clientes identificados por CPF e data de nascimento
- Prestadores identificados por CNPJ

## Stack Tecnológico

- **Linguagem**: Java
- **Framework**: Spring Boot 
- **Banco de Dados**: H2
- **Autenticação**: Spring Security + JWT
- **Build Tool**: Maven
- **ORM**: Hibernate/JPA
- **Versionamento de BD**: Flyway
