# Barber Back - API para Gestión de Peluquerías

Una API desarrollada con Spring Boot para gestionar reservas, clientes y tratamientos ofrecidos en una peluquería.

## Características

- **Clientes**: CRUD completo para gestionar clientes.
- **Reservas**: CRUD para gestionar reservas, asociadas a clientes y tratamientos.
- **Tratamientos**: CRUD para definir y administrar los servicios ofrecidos por la peluquería.
- **Base de datos**: PostgreSQL como sistema de almacenamiento.
- **Documentación**: Swagger UI para probar los endpoints.

## Requisitos

Antes de empezar, asegúrate de tener instalados los siguientes programas:

- **Java 17** o superior
- **Maven 3.8+**
- **PostgreSQL**
- **Docker** (opcional, para base de datos local)

## Configuración del Proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/barber-back.git
cd barber-back


## Comando para levantar un contenedor Docker con Postgres
docker run --name barber-postgres -e POSTGRES_USER=root -e POSTGRES_PASSWORD=labo123 -e POSTGRES_DB=barber_db -p 5433:5432 -d postgres:latest
