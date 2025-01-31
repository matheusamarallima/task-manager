Java Task Manager Api
Este é um sistema de gerenciamento de tarefas (To-Do List) desenvolvido com Java e Spring Boot. A API permite aos usuários criar, listar, editar e excluir tarefas. A persistência de dados é feita em um banco de dados SQL Server (no caso aqui H2 para testes).

Tecnologias Usadas
Java 21
Spring Boot
Spring Data JPA
H2 Database (testes em memória)
JUnit 
Maven 


Endpoints: 


**Criar Tarefa
**
URL: /tasks
Método: **POST**
Descrição: Cria uma nova tarefa.
Exemplo:
{
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}

OU 

{
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING"
  }

Resposta:
{
  "id": 1,
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}

**Listar Tarefas
**
URL: /tasks
Método: **GET**
Descrição: Retorna todas as tarefas.
Resposta:

{
  "id": 1,
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}

**Buscar Tarefa
**
URL: /tasks/{id}
Método: **GET**
Descrição: Retorna uma tarefa específica pelo ID.
Resposta:
{
  "id": 1,
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}

**Atualizar Tarefa
**
URL: /tasks/{id}
Método: **PUT**
Descrição: Atualiza uma tarefa.
Corpo da Requisição:

{
  "id": 1,
  "title": "Acordar",
  "description": "Abrir os olhos",
  "status": "PENDING"
  "createdAt": "2025-01-30T12:34:56"
}
Resposta:

{
  "id": 1,
  "title": "Acordar",
  "description": "Abrir os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}

**Excluir Tarefa
**
URL: /tasks/{id}
Método: **DELETE**
Descrição: Exclui uma tarefa pelo ID.

