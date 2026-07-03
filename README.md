# 🗄️ Java & Databases: Portfólio de Modelagem Relacional

Este repositório foi desenvolvido com o objetivo de consolidar conceitos fundamentais de modelagem de dados relacionais e sua respectiva integração com aplicações Java. Ele funciona como um portfólio acadêmico, reunindo diferentes cenários de negócios, regras de integridade, massa de dados para testes (`INSERT`) e estruturas de tabelas.

---

## 📌 Índice de Projetos

* **Atividade 1: Modelagem de Sistemas Específicos**
  1. [Sistema Biblioteca Escolar](#1-sistema-biblioteca-escolar-)
  2. [Sistema Médico](#2-sistema-médico-)
  3. [Sistema Estacionamento](#3-sistema-estacionamento-)
  4. [Sistema Delivery](#4-sistema-delivery-)
  5. [Sistema Reserva de Hotel](#5-sistema-reserva-de-hotel-)
  6. [Conta de Usuário](#6-conta-de-usuário-)
  7. [Sistema de Passagens](#7-sistema-de-passagens-)
* **Atividade 2: E-Commerce Integrado**
  * [Sistema de Compra Online](#-atividade-2-sistema-de-compra-online-)

---

## 🚀 Atividade 1: Modelagem de Sistemas Específicos

### 1. Sistema Biblioteca Escolar 📚
* **O que o sistema faz:** Gerencia o fluxo de alunos dentro de uma biblioteca, controlando o total de livros emprestados e aplicando travas para alunos que possuem multas pendentes.
* **Conceitos de Banco de Dados:** `PRIMARY KEY`, `TINYINT` (booleano simulado), `DEFAULT`.
* 🔗 [Acessar Pasta do Projeto](./01-biblioteca-escolar/) | 📄 [Acessar Script SQL](./01-biblioteca-escolar/script.sql)

### 2. Sistema Médico 🩺
* **O que o sistema faz:** Controla o agendamento de consultas médicas. O sistema vincula pacientes aos médicos disponíveis de acordo com o horário e a especialidade requisitada.
* **Conceitos de Banco de Dados:** `AUTO_INCREMENT`, `UNIQUE` (CPF), `FOREIGN KEY` (relacionamento consulta-paciente).
* 🔗 [Acessar Pasta do Projeto](./02-sistema-medico/) | 📄 [Acessar Script SQL](./02-sistema-medico/script.sql)

### 3. Sistema Estacionamento 🚗
* **O que o sistema faz:** Monitora o fluxo de veículos. Registra a entrada em tempo real na tabela de movimentação ativa e, após a saída, consolida os dados com o valor pago em um histórico definitivo.
* **Conceitos de Banco de Dados:** `DATETIME`, `DECIMAL` (valores monetários precisos), `FOREIGN KEY` referenciando uma coluna `UNIQUE`.
* 🔗 [Acessar Pasta do Projeto](./03-sistema-estacionamento/) | 📄 [Acessar Script SQL](./03-sistema-estacionamento/script.sql)

### 4. Sistema Delivery 🍕
* **O que o sistema faz:** Gerencia a segurança de login de usuários, catálogo de produtos e o fechamento financeiro de pedidos de entrega, calculando taxas e o valor final consumido.
* **Conceitos de Banco de Dados:** `UNIQUE` (segurança de login), `DECIMAL(10,2)`.
* 🔗 [Acessar Pasta do Projeto](./04-sistema-delivery/) | 📄 [Acessar Script SQL](./04-sistema-delivery/script.sql)

### 5. Sistema Reserva de Hotel 🏨
* **O que o sistema faz:** Controla a ocupação de quartos categorizados e automatiza o processo de Check-in e Check-out, calculando o valor total da estadia com base nas diárias.
* **Conceitos de Banco de Dados:** `ENUM` (restrição de tipos de quarto e pagamento), `DATETIME`.
* 🔗 [Acessar Pasta do Projeto](./05-reserva-hotel/) | 📄 [Acessar Script SQL](./05-reserva-hotel/script.sql)

### 6. Conta de Usuário 👥
* **O que o sistema faz:** Controla o perfil de assinantes de uma plataforma, separando os acessos por categorias de planos (Padrão ou Premium) e gerenciando faturamentos mensais.
* **Conceitos de Banco de Dados:** `ENUM` (tipos de plano), `UNIQUE` (validação de e-mail).
* 🔗 [Acessar Pasta do Projeto](./06-conta-usuario/) | 📄 [Acessar Script SQL](./06-conta-usuario/script.sql)

### 7. Sistema de Passagens ✈️
* **O que o sistema faz:** Centraliza a emissão de bilhetes aéreos. Vincula passageiros cadastrados a voos específicos, permitindo definir a classe do assento e aplicar regras de desconto sobre o preço original.
* **Conceitos de Banco de Dados:** `ENUM` (classes econômica/executiva), `VARCHAR` padronizados.
* 🔗 [Acessar Pasta do Projeto](./07-sistema-passagens/) | 📄 [Acessar Script SQL](./07-sistema-passagens/script.sql)

---

## ⚡ Atividade 2: Sistema de Compra Online 🛒

* **O que o sistema faz:** Modela a engrenagem de um e-commerce. Ele armazena os dados cadastrais de clientes (`pessoa`), mantém um catálogo de mercadorias com marcas e preços unitários (`produtos`) e registra os pedidos de venda (`compra`) relacionando o cliente comprador, valor do frete e o método de pagamento escolhido. O banco já acompanha uma carga inicial de dados populada com produtos eletrônicos e vestuário.
* **Conceitos de Banco de Dados:** * `AUTO_INCREMENT` para geração automática de IDs identificadores.
  * `UNIQUE` aplicado ao CPF para impedir cadastros duplicados de clientes.
  * `DECIMAL(10,2)` garantindo precisão matemática para fretes e valores monetários.
  * `FOREIGN KEY` ligando de forma íntegra a tabela `compra` ao cliente comprador da tabela `pessoa`.
  * DML (`INSERT INTO`) para povoamento inicial de dados de simulação.
* 🔗 [Acessar Pasta do Projeto](./08-compra-online/) | 📄 [Acessar Script SQL](./08-compra-online/script.sql)

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem Principal:** Java
* **Persistência de Dados:** SQL (Structured Query Language)
* **SGBD Recomendado:** MySQL / MariaDB
* **Driver de Conexão:** JDBC (Java Database Connectivity)

---

## ✍️ Autor

* **Seu Nome** - [Seu Perfil no GitHub](https://github.com/seu-usuario)
