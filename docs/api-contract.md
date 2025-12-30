# API Contract

This document defines the REST API endpoints for each microservice
in the Task Manager system.

---

## User Service API

### Endpoints

| Method | Endpoint | Description |
|------|----------|-------------|
| POST | /users/register | Register a new user |
| POST | /users/login | Authenticate user |
| GET  | /users/{id} | Get user information |
| GET  | /health | Health check |

### Sample Register Request
```json
{
  "username": "john",
  "password": "1234"
}
