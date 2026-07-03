# 🗄️ Coleção de Bancos de Dados (SQL) - Atividade 1 e 2

Este repositório contém o desenvolvimento de modelagens de bancos de dados relacionais (SQL) criados para diferentes cenários e regras de negócio. O projeto está dividido em duas etapas principais de atividades.

---

## 🚀 Atividade 1: Modelagem de Sistemas Específicos

Esta etapa engloba a criação e estruturação de 7 bancos de dados distintos, cobrindo desde regras simples de cadastro até relacionamentos com chaves estrangeiras (`FOREIGN KEY`).

### 📋 Bancos de Dados Criados

#### 1. Sistema Biblioteca Escolar (`sistemabibliotecaescolar`)
* **Objetivo:** Gerenciar o fluxo de alunos, controle de pendências (multas) e quantidade de livros emprestados.
* **Tabelas:** `aluno`, `livro`.

#### 2. Sistema Médico (`sistemamedico`)
* **Objetivo:** Controlar o agendamento de consultas médicas associando pacientes a especialidades e horários.
* **Tabelas:** `pacientes`, `medicos`, `consulta`.

#### 3. Sistema Estacionamento (`sistemaestacionamento`)
* **Objetivo:** Registrar a entrada, saída e o histórico de valores pagos pelos veículos que utilizam o estacionamento.
* **Tabelas:** `veiculos`, `movimentacao`, `historico`.

#### 4. Sistema Delivery (`sistemadelivery`)
* **Objetivo:** Gerenciar a autenticação de usuários, catálogo de produtos e o fechamento financeiro de pedidos (taxas e totais).
* **Tabelas:** `usuarios`, `produtos`, `pedidos`.

#### 5. Sistema Reserva de Hotel (`sistemareservahotel`)
* **Objetivo:** Controlar a ocupação de quartos (Simples, Duplo ou Suíte) e o fluxo de Check-in/Check-out de hóspedes.
* **Tabelas:** `Quartos`, `Chekin`.

#### 6. Conta de Usuário (`contausuario`)
* **Objetivo:** Gerenciar perfis de clientes e assinaturas de planos (*Padrão* ou *Premium*) com recorrência mensal.
* **Tabelas:** `usuarios`.

#### 7. Sistema de Passagens (`sistemapassagens`)
* **Objetivo:** Registrar a emissão de passagens aéreas vinculando a classe de voo (Econômica/Executiva) e o cálculo de preços.
* **Tabelas:** `passageiros`, `voos`, `passagens`.

#### 8.

---

## 🔧 Como Executar os Scripts

Para rodar os scripts contidos neste repositório, você precisará de um SGBD (Sistema Gerenciador de Banco de Dados) como **MySQL** ou **MariaDB**.

1. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
