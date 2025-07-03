# Proyecto Final Calidad - TaskManager

Este proyecto implementa un sistema de gestión de tareas (`TaskManager`) diseñado para organizar y administrar tareas de manera eficiente. Utiliza herramientas de calidad de software como pruebas unitarias, análisis estático y cobertura de código.

## Requisitos

1. **Java**: Asegúrate de tener instalado Java 17.

   ```powershell
   $env:JAVA_HOME="C:\Program Files\Java\jdk-17.0.10"
   $env:Path="$env:JAVA_HOME\bin;$env:Path"
   java -version

   ```

2. **Maven**:
   Utiliza **Maven** para construir y ejecutar el proyecto.

## Comandos Principales

### Construcción del Proyecto

Ejecuta el siguiente comando para limpiar y verificar el proyecto:

```bash
mvn clean verify
```

### Pruebas Unitarias

Para ejecutar las pruebas unitarias:

```bash
mvn clean test
```

### Generación de Reportes

Para generar reportes de calidad y cobertura:

```bash
mvn clean verify site
```

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente del sistema **TaskManager**.
  - `TaskItem`: Representa una tarea individual.
  - `TaskService`: Proporciona lógica para gestionar tareas.
  - `Repository`: Interfaz para el almacenamiento de datos.
  - `InMemoryRepository`: Implementación en memoria del repositorio.

- `src/test/java`: Contiene las pruebas unitarias para garantizar la calidad del código.


## Herramientas de Calidad

Este proyecto utiliza las siguientes herramientas:

- **JUnit 5**: Para pruebas unitarias.
- **JaCoCo**: Para medir la cobertura de código.
- **Checkstyle**: Para verificar el estilo del código.
- **SpotBugs**: Para análisis estático de errores.

## Notas Adicionales

- Asegúrate de que tu entorno esté configurado correctamente antes de ejecutar los comandos.
- Este proyecto está enfocado exclusivamente en el flujo de **TaskManager**. Cualquier código no relacionado ha sido eliminado.
