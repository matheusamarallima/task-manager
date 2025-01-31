# Java Task Manager API

Este é um sistema de gerenciamento de tarefas (To-Do List) desenvolvido com Java e Spring Boot. A API permite aos usuários criar, listar, editar e excluir tarefas. A persistência de dados é feita em um banco de dados SQL Server (no caso aqui H2 para testes).

## Tecnologias Usadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database (testes em memória)
- JUnit
- Maven


## Configuração

Para rodar a aplicação localmente, siga os passos abaixo:

### 1. Clonar o Repositório

Primeiro, clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/matheusamarallima/task-manager.git
```

### 2. Instalar o H2.
```bash
https://www.h2database.com/html/download.html
```

### 3. Rodar a aplicação.
```bash
mvn spring-boot:run
```
## Endpoints

### Criar Tarefa

- **URL:** `/tasks`
- **Método:** `POST`
- **Descrição:** Cria uma nova tarefa.
- **Exemplo de Requisição:**

```json
{
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}
```

- **Resposta:**

```json
{
  "id": 1,
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}
```
### Listar Tarefas

- **URL:** `/tasks`
- **Método:** `GET`
- **Descrição:** Retorna todas as tarefas.
- **Resposta:**

```json
[
  {
    "id": 1,
    "title": "Dormir",
    "description": "Fechar os olhos",
    "status": "PENDING",
    "createdAt": "2025-01-30T12:34:56"
  },
  {
    "id": 2,
    "title": "Estudar",
    "description": "Estudar Spring Boot",
    "status": "IN_PROGRESS",
    "createdAt": "2025-01-30T13:00:00"
  }
]
```
### Buscar Tarefa

- **URL:** `/tasks/{id}`
- **Método:** `GET`
- **Descrição:** Retorna uma tarefa específica pelo ID.
- **Resposta:**

```json
{
  "id": 1,
  "title": "Dormir",
  "description": "Fechar os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}
```

### Atualizar Tarefa

- **URL:** `/tasks/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza uma tarefa existente.
- **Exemplo de Requisição:**

```json
{
  "id": 1,
  "title": "Acordar",
  "description": "Abrir os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}
```
- **Resposta:**

```json
{
  "id": 1,
  "title": "Acordar",
  "description": "Abrir os olhos",
  "status": "PENDING",
  "createdAt": "2025-01-30T12:34:56"
}
```
### Excluir Tarefa

- **URL:** `/tasks/{id}`
- **Método:** `DELETE`
- **Descrição:** Exclui uma tarefa pelo ID.
- **Resposta:** Status HTTP 204 (No Content)


