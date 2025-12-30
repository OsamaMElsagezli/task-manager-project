# Microservices Overview

## User Service

### Responsibility
- User registration
- User login
- User information retrieval

### Owned Data
- userId
- username
- password (hashed)

### Does NOT
- Manage tasks

---

## Task Service

### Responsibility
- Create tasks
- Update tasks
- Delete tasks
- List tasks per user

### Owned Data
- taskId
- title
- completed
- userId

### Does NOT
- Store user credentials
