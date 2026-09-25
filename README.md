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
    │       ├── stepdefinitions      # Definiciones de pasos de Cucumber
    │       ├── tasks                # Tareas de Screenplay
    │       ├── interactions         # Interacciones de Screenplay
    │       ├── questions            # Preguntas de Screenplay
    │       ├── ui                   # Page Objects (localizadores de UI)
    │       ├── models               # Modelos de datos
    │       ├── abilities            # Habilidades personalizadas
    │       └── utils                # Clases utilitarias
    └── resources
        ├── features
        │   └── smoke                # Archivos Feature organizados por categoría
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

### Ejecutar únicamente las pruebas Smoke

```bash
./gradlew clean test --tests SmokeTestRunner
```

En Windows:

```bash
gradlew.bat clean test --tests SmokeTestRunner
```

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

## Escenarios futuros

El framework está diseñado para soportar los siguientes escenarios funcionales, que serán implementados posteriormente:

1. Registro de usuario
2. Modificación de datos del usuario
3. Flujo de compra de productos

## Buenas prácticas aplicadas

* **Principios SOLID** cuando son aplicables.
* **Separación de responsabilidades** - La interfaz de usuario, la lógica de negocio y las definiciones de pruebas están separadas.
* **Screenplay Pattern** - Diseño basado en actores para mejorar la reutilización de las pruebas.
* **DRY (Don't Repeat Yourself)** - Tareas y preguntas reutilizables.
* **Clean Code** - Nombres descriptivos y estructura clara.
* **Sin `Thread.sleep()`** - Se utilizan los mecanismos de espera integrados de Serenity.
* **Selectores robustos** - Se priorizan `id`, `name` y `data-testid` sobre XPath frágiles.
* **Configuración centralizada** - Todos los ajustes se encuentran en `serenity.conf`.
