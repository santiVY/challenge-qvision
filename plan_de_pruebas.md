# Plan de Pruebas - Bon-bonite

## 1. Alcance
* **Dentro del alcance:**
  * Validación del flujo de Registro de Usuario y Modificación de Datos de perfil.
  * Validación del flujo e-commerce de Compra de Producto (End-to-End).
  * Navegación y automatización de escenarios clave en los módulos principales: Zapatos, Bolsos, Cinturones, Accesorios, Outlet, PQRS, Mi cuenta / Account.
* **Fuera del alcance:**
  * Pruebas de rendimiento o carga del sitio web.
  * Pruebas de seguridad e inyección de código.
  

---

## 2. Estrategia de Pruebas
* **Tipo de Pruebas:** Funcionales, Regresión y Automatización E2E.
* **Enfoque de Automatización:** 
  * Se automatizarán **3 escenarios principales** prioritarios utilizando un framework de pruebas automatizadas Selenium con el patrón ScreenPlay).
  * Los escenarios secundarios o de menor prioridad se validarán de forma manual e exploratoria.
* **Nivel de Automatización:** Se automatizará la capa de Interfaz de Usuario (UI) enfocándose en el camino exitoso para dar resultados rápidos en esta primera versión.

---

## 3. Escenarios a Correr (Automatizados)

1. **Escenario 1: Registro Exitoso**
   * **Objetivo:** Verificar que un nuevo cliente pueda registrarse e ingresar a su perfil a actualizar sus datos.
   * **Pasos:** Ir a la pagina principal $\rightarrow$ click en cuenta $\rightarrow$ click en registarse y diligenciar datos para el registro.
2. **Escenario 2: Flujo Completo de Compra de Producto (E2E)**
   * **Objetivo:** Garantizar la conversión principal del negocio.
   * **Pasos:** Buscar producto en catálogo (ej. "Zapatos") $\rightarrow$ Agregar al carrito $\rightarrow$ Ir al Checkout $\rightarrow$ Ingresar datos de envío/pago $\rightarrow$ Confirmar orden.
3. **Escenario 3: Actualizacion de datos cliente**
   * **Objetivo:** Asegurar que los usuarios puedan realizar ajustes a sus informacion registrada exitosamente.
   * **Pasos:** Ingresar al sitio $\rightarrow$ Actualizacion de datos $\rightarrow$ Modificar el telefono del cliente o algun campo previamente registrado.

---

## 4. Datos de Prueba (Test Data)
* **Usuarios:** 
  * Usuario nuevo (correo dinámico generado por script, ej. `usuario_apellido@mail.com`).
  * Usuario registrado existente para pruebas de login directo.
* **Productos:** 
  * SKU/Nombre de producto activo en stock dentro de categorías (Zapatos/Bolsos).
* **Checkout/Pago:** 
  * Tarjetas de crédito/débito de prueba (Sandbox/Test Cards).
  * Dirección de envío ficticia pero con estructura válida (Ciudad, Dirección, Teléfono).

---

## 5. Riesgos del Proyecto y del Producto

* **Riesgos del Producto (Software):**
  * Inestabilidad en la pasarela de pagos que interrumpa la automatización del flujo de compra.
  * Errores en la persistencia de datos al actualizar la información del perfil del usuario.
* **Riesgos del Proyecto (Proceso/Entorno):**
  * Cambios frecuentes en el DOM/UI del sitio web que vuelvan inestables (*flaky*) los scripts automatizados.
  * Indisponibilidad o caídas del entorno de pruebas durante la ejecución de la suite.

---

## 6. Supuestos (Assumptions)
* El sitio web (`https://www.bon-bonite.com/`) o un entorno de Staging equivalente está disponible y accesible sin bloqueos de red o Captchas agresivos.
* Se cuenta con un entorno Sandbox (QA y STG) habilitado para simular las compras sin cobros reales.

---

## 7. Limitaciones (Constraints)
* **Tiempo de ejecución:** Al ser un MVP para el reto técnico, solo se entregarán 3 escenarios automatizados en esta primera fase.
