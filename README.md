# 🚀 ApplyHub

Sistema backend para **gestão de candidaturas a vagas de emprego**, permitindo organizar aplicações, acompanhar status do processo seletivo e centralizar informações de forma simples e eficiente.

> Projeto desenvolvido para portfólio com foco em backend profissional usando Spring Boot.

---

## 📌 Sobre o projeto

O **ApplyHub** é uma API REST construída em Java com Spring Boot que ajuda candidatos a gerenciar suas aplicações para vagas.

A ideia do projeto surgiu de um problema real: quando começamos a aplicar para várias vagas, rapidamente perdemos o controle de:

- Onde aplicamos  
- Em qual etapa estamos  
- Contatos dos recrutadores  
- Feedbacks recebidos  

O ApplyHub resolve isso centralizando tudo em um único sistema.

---

## 🧠 Funcionalidades

### 👤 Usuários
- Cadastro de usuário
- Autenticação (login)
- Gerenciamento de perfil

### 💼 Vagas
- Criar vaga aplicada
- Atualizar informações da vaga
- Listar vagas do usuário
- Remover vaga

### 📊 Pipeline de candidatura
Controle do status da candidatura, por exemplo:

- Applied
- Screening
- Interview
- Offer
- Rejected

### 📝 Informações adicionais
- Empresa
- Link da vaga
- Salário (opcional)
- Observações pessoais
- Data da candidatura

---

## 🏗️ Arquitetura

O projeto segue boas práticas de arquitetura backend:

### Camadas

**Controller**
- Exposição da API REST

**Service**
- Regras de negócio

**Repository**
- Persistência de dados (JPA)

**Model / Entity**
- Representação das tabelas

---

## 🛠️ Tecnologias

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Banco relacional (H2/PostgreSQL)
- REST API

---

## 📦 Como rodar o projeto

### Pré-requisitos

- Java 17+
- Maven

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/MarcelFeo/ApplyHub.git
cd ApplyHub
```

### 2️⃣ Rodar a aplicação
```bash
A API iniciará em:

http://localhost:8080
```
