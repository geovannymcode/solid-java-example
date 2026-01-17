# Principios SOLID en Java - Ejemplo Práctico

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5.10.2-brightgreen.svg)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Este proyecto es un ejemplo práctico que implementa los principios SOLID de programación orientada a objetos en Java. El código demuestra cómo aplicar estos principios en un sistema bancario simplificado.

## 📚 Artículo Relacionado

Para una explicación detallada de los conceptos implementados en este proyecto, consulta el artículo completo en:
[Principios SOLID en Java: Guía Completa con Ejemplos Prácticos](https://geovannycode.com/blog/principios-solid-java/)

## 🏗️ Estructura del Proyecto

```
src/
├── main/java/com/geovannycode/solid/
│   ├── App.java                 # Clase principal con ejemplos de uso
│   ├── Cuenta.java              # Clase base abstracta para cuentas
│   ├── CuentaAhorro.java        # Implementación de cuenta de ahorros
│   ├── CuentaCorriente.java     # Implementación de cuenta corriente
│   ├── CuentaDeAhorros.java     # Otra implementación de cuenta de ahorros
│   ├── InformeGenerable.java    # Interfaz para generación de informes
│   ├── Transaccionable.java     # Interfaz para operaciones de transacción
│   └── ... (más archivos)
└── test/java/com/geovannycode/solid/
    ├── CuentaCorrienteTest.java
    ├── CuentaDeAhorrosTest.java
    └── ... (más pruebas)
```

## 🎯 Principios SOLID Implementados

### 1. Principio de Responsabilidad Única (SRP)
- Cada clase tiene una única responsabilidad
- Ejemplo: `CuentaCorriente` maneja solo operaciones de cuenta corriente
- `InformeGenerable` separa la lógica de generación de informes

### 2. Principio de Abierto/Cerrado (OCP)
- Las entidades están abiertas a extensión pero cerradas a modificación
- Se pueden agregar nuevos tipos de cuentas sin modificar el código existente

### 3. Principio de Sustitución de Liskov (LSP)
- Las clases derivadas pueden ser sustituidas por sus clases base
- Ejemplo: `CuentaAhorro` y `CuentaCorriente` pueden usarse donde se espere `Transaccionable`

### 4. Principio de Segregación de Interfaces (ISP)
- Interfaces específicas en lugar de una interfaz general
- Ejemplo: `Transaccionable` solo declara métodos relacionados con transacciones

### 5. Principio de Inversión de Dependencias (DIP)
- Los módulos de alto nivel no dependen de los de bajo nivel
- Ambos dependen de abstracciones

## 🚀 Cómo Ejecutar

### Requisitos
- Java 21 o superior
- Maven 3.6 o superior

### Compilación
```bash
mvn clean compile
```

### Ejecutar la Aplicación
```bash
mvn exec:java -Dexec.mainClass="com.geovannycode.solid.App"
```

### Ejecutar Pruebas
```bash
mvn test
```

## 📊 Demostración

La clase `App.java` incluye ejemplos de uso que demuestran:
1. Procesamiento de transacciones con diferentes tipos de cuentas
2. Generación de informes
3. Cálculo de impuestos
4. Funcionalidades existentes del sistema

## 🧪 Pruebas

El proyecto incluye pruebas unitarias que validan el correcto funcionamiento de las implementaciones:
- Pruebas para `CuentaCorriente`
- Pruebas para `CuentaDeAhorros`
- Pruebas para `EvaluacionCreditoService`
- Pruebas para `ProcesadorDePagos`

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.

## 🤝 Contribución

Las contribuciones son bienvenidas. Por favor, lee las [pautas de contribución](CONTRIBUTING.md) antes de enviar un pull request.

## 📞 Contacto

Para más información, visita [geovannycode.com](https://geovannycode.com) o sigue a [@geovannycode](https://twitter.com/geovannycode) en Twitter.
