# Framework de Automatización Bon-Bonite

Framework profesional de automatización de pruebas QA para el sitio web de comercio electrónico Bon-Bonite, desarrollado como desafío técnico para QVision.

## Objetivo

Este proyecto implementa un framework de automatización de pruebas robusto, mantenible y escalable, utilizando buenas prácticas de la industria y tecnologías modernas. El framework sigue el patrón **Screenplay** e integra **Cucumber** para realizar pruebas orientadas al comportamiento (BDD).

## Tecnologías utilizadas

* **Java 21+** - Lenguaje de programación
* **Gradle** - Herramienta de automatización de compilación
* **Serenity BDD 4.2.0** - Framework de pruebas con patrón Screenplay
* **Cucumber 7.18.0** - Desarrollo orientado al comportamiento (BDD)
* **JUnit 5** - Framework para la ejecución de pruebas
* **Selenium WebDriver 4.23.1** - Automatización del navegador
* **Google Chrome** - Navegador objetivo
* **WebDriverManager 5.8.0** - Gestión de WebDriver
* **AssertJ** - Aserciones fluidas

## Arquitectura

El framework utiliza **Screenplay Pattern** como patrón principal de diseño, promoviendo:

* **Actors (Actores)** - Representan a los usuarios que realizan acciones en el sistema
* **Abilities (Habilidades)** - Capacidades que poseen los actores, por ejemplo, `BrowseTheWeb`
* **Tasks (Tareas)** - Acciones de alto nivel relacionadas con el negocio realizadas por los actores
* **Interactions (Interacciones)** - Interacciones de bajo nivel con la interfaz de usuario
* **Questions (Preguntas)** - Consultas utilizadas para verificar el estado del sistema

### Integración con Cucumber

Cucumber proporciona la capa de comportamiento:

* **Feature files** - Definen los escenarios de prueba utilizando el lenguaje Gherkin
* **Step Definitions** - Conectan los pasos de Gherkin con la implementación de Screenplay
* **Tags** - Permiten organizar y filtrar los escenarios de prueba

## Estructura del proyecto

```text
src
└── test
    ├── java
    │   └── com.qvision.bonbonite
    │       ├── runners              # Ejecutores de pruebas con JUnit 5
    │       │   ├── compra           # Runner para tests de compra
    │       │   ├── actualizacion    # Runner para tests de actualización de datos
    │       │   ├── iniciarsesion    # Runner para tests de inicio de sesión
    │       │   └── registro         # Runner para tests de registro
    │       ├── stepdefinitions      # Definiciones de pasos de Cucumber
    │       │   ├── compra           # Steps para flujo de compra
    │       │   ├── actualizacion    # Steps para actualización de datos
    │       │   ├── iniciarsesion    # Steps para inicio de sesión
    │       │   └── registro         # Steps para registro
    │       ├── tasks                # Tareas de Screenplay
    │       │   ├── compra           # Tasks para flujo de compra
    │       │   ├── actualizacion    # Tasks para actualización de datos
    │       │   ├── iniciarsesion    # Tasks para inicio de sesión
    │       │   └── registro         # Tasks para registro
    │       ├── questions            # Preguntas de Screenplay
    │       │   ├── compra           # Questions para validación de compra
    │       │   └── actualizacion    # Questions para validación de actualización
    │       ├── ui                   # Page Objects (localizadores de UI)
    │       │   ├── compra           # Page objects para flujo de compra
    │       │   ├── actualizacion    # Page objects para actualización de datos
    │       │   ├── iniciosesion     # Page objects para inicio de sesión
    │       │   └── registro         # Page objects para registro
    │       ├── models               # Modelos de datos
    │       │   ├── DatosCompra      # Modelo para datos de compra
    │       │   ├── DatosActualizacion # Modelo para datos de actualización
    │       │   ├── DatosInicioSesion # Modelo para credenciales
    │       │   └── DatosRegistro    # Modelo para registro de usuario
    │       └── utils                # Clases utilitarias
    │           └── GeneradorDatosUnicos # Generador de datos dinámicos
    └── resources
        ├── features
        │   ├── compra_producto.feature        # Feature para flujo de compra
        │   └── actualizardatos
        │       └── actualizar_datos_usuario.feature # Feature para actualización de datos
        ├── serenity.conf            # Configuración de Serenity
        └── logback-test.xml         # Configuración de logs
```

## Requisitos

* Java 21 o superior
* Navegador Google Chrome
* Gradle (incluido mediante el Gradle Wrapper)

## Instalación y configuración

1. Clonar el repositorio.
2. Navegar hasta el directorio del proyecto.
3. El proyecto utiliza Gradle Wrapper, por lo que no es necesario realizar una instalación adicional de Gradle.

## Ejecución de las pruebas

### Ejecutar todas las pruebas

```bash
./gradlew clean test
```

En Windows:

```bash
gradlew.bat clean test
```

### Ejecutar todas las pruebas

```bash
./gradlew clean test --tests "*AllTestsSuite"
```

### Ejecutar pruebas específicas por módulo

**Pruebas de compra:**
```bash
./gradlew clean test --tests "*CompraTestSuite"
```

**Pruebas de actualización de datos:**
```bash
./gradlew clean test --tests "*ActualizarDatosTestSuite"
```

**Pruebas de inicio de sesión:**
```bash
./gradlew clean test --tests "*IniciarSesionTestSuite"
```

**Pruebas de registro:**
```bash
./gradlew clean test --tests "*RegistroTestSuite"
```

En Windows, reemplazar `./gradlew` por `gradlew.bat`.

## Ubicación del reporte de Serenity

Después de ejecutar las pruebas, el reporte de Serenity BDD se genera en:

```text
build/serenity/index.html
```

Abre este archivo en un navegador para visualizar el reporte detallado de las pruebas, incluyendo capturas de pantalla y logs de ejecución.

## Ejemplo de Feature (Gherkin)

```gherkin
@smoke
Feature: Prueba Smoke de Bon-Bonite

  Scenario: Validar que la página de inicio de Bon-Bonite cargue correctamente
    Given que el usuario se encuentra en la página de inicio de Bon-Bonite
    Then el usuario debería visualizar correctamente la página de inicio
```

## Integración de Screenplay y Cucumber

El framework integra Cucumber con el patrón Screenplay de la siguiente manera:

1. **Cucumber Feature** - Define el comportamiento utilizando lenguaje de negocio.
2. **Step Definitions** - Traducen los pasos de Gherkin en acciones de Screenplay.
3. **Screenplay Tasks** - Implementan la lógica de negocio utilizando actores.
4. **Screenplay Questions** - Verifican el estado del sistema mediante los actores.
5. **UI Page Objects** - Definen los localizadores de los elementos web.

Esta separación garantiza que:

* Los escenarios de prueba sean fáciles de leer y mantener.
* La lógica de negocio sea reutilizable en diferentes escenarios.
* Los cambios en la interfaz de usuario estén aislados en los Page Objects.
* El código de pruebas siga los principios SOLID.

## Escenarios implementados

El framework actualmente soporta los siguientes escenarios funcionales:

1. **Registro de usuario** - Validación del proceso de registro con datos únicos generados dinámicamente
2. **Inicio de sesión** - Autenticación de usuarios con credenciales válidas
3. **Modificación de datos del usuario** - Actualización de información del perfil (ej. teléfono)
4. **Flujo de compra de productos** - Proceso completo de compra desde selección hasta pasarela de pagos

## Integración con GitHub Actions

El proyecto incluye un workflow de GitHub Actions que ejecuta automáticamente las pruebas cuando:
- Se hace push a la rama `main`
- Se crea un pull request hacia la rama `main`

El workflow:
- Configura Java 21
- Ejecuta todas las pruebas con Gradle
- Ejecuta Selenium en modo headless
- Genera y sube los reportes de Serenity como artefactos

Configuración ubicada en: `.github/workflows/test.yml`

## Buenas prácticas aplicadas

* **Principios SOLID** cuando son aplicables.
* **Separación de responsabilidades** - La interfaz de usuario, la lógica de negocio y las definiciones de pruebas están separadas.
* **Screenplay Pattern** - Diseño basado en actores para mejorar la reutilización de las pruebas.
* **DRY (Don't Repeat Yourself)** - Tareas y preguntas reutilizables.
* **Clean Code** - Nombres descriptivos y estructura clara.
* **Sin `Thread.sleep()`** - Se utilizan los mecanismos de espera integrados de Serenity.
* **Selectores robustos** - Se priorizan `id`, `name` y `data-testid` sobre XPath frágiles.
* **Configuración centralizada** - Todos los ajustes se encuentran en `serenity.conf`.
