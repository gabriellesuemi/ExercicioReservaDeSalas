# Sistema de Reserva de Salas de Estudo

Projeto desenvolvido em Java para gerenciamento de reservas de salas de estudo, utilizando Programação Orientada a Objetos e padrões de projeto para garantir escalabilidade e organização do código.

# Objetivo

O sistema permite que estudantes e professores realizem reservas de salas de estudo, evitando conflitos de horário e permitindo notificações automáticas sobre alterações nas reservas.

# Funcionalidades

* Cadastro e listagem de salas (Individuais, Grupos e Laboratórios).
* Criação, alteração e cancelamento de reservas.
* Detecção automática de colisões de horário.
* Notificação de usuários sobre mudanças no status das reservas.
* Troca dinâmica de políticas de reserva em tempo de execução.
* Geração de relatório diário de ocupação.

# Padrões de Projeto Utilizados

## Factory Method

Responsável pela criação dos diferentes tipos de salas sem expor a lógica de instaciação ao cliente.

* Arquivo principal: SalaFactory.java

## Strategy

Utilizado para permitir que a política de reserva (critérios de prioridade) seja alterada dinamicamente.

* Políticas: Primeiro a reservar e Prioridade para docentes.
* Arquivos: PoliticaDeReserva.java, PoliticaPrimeiroReserva.java e PoliticaPrioridadeDocente.java.

## Observer

Define um mecanismo de assinatura para notificar múltiplos usuários sobre qualquer evento em uma reserva.

* Arquivos: Observador.java e Usuario.java.

## Singleton

Garante que o repositório de dados do sistema tenha uma única instância global.

* Arquivo: Repositorio.java

# Estrutura do Projeto

```text
reserva-salas/
│
├── src/
│   ├── Main.java
│   ├── Observador.java
│   ├── Usuario.java
│   ├── Estudante.java
│   ├── Professor.java
│   ├── Sala.java
│   ├── SalaIndividual.java
│   ├── SalaGrupo.java
│   ├── Laboratorio.java
│   ├── SalaFactory.java
│   ├── Reserva.java
│   ├── PoliticaDeReserva.java
│   ├── PoliticaPrimeiroReserva.java
│   ├── PoliticaPrioridadeDocente.java
│   ├── Repositorio.java
│   └── GerenciadorReservas.java
│
├── docs/
│   └── diagrama-classes.png
│
└── README.md

```

# Como Executar

1. Compilar o projeto:
javac src/*.java
2. Executar o programa:
java -cp src Main

# Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* UML

# Autores

* Gabrielle Suemi Iqueji Alencar
* Lívia Costa da Silva