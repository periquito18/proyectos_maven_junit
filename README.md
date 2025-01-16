
# 🚀 Comandos Esenciales de Maven

## 🧹 Limpieza
1. **`mvn clean`**  
   🧹 **Función:** Elimina los directorios de salida (`target`) de todos los módulos del proyecto, preparando el proyecto para una nueva compilación.  
   **Uso:**  
   ```bash
   mvn clean
   ```  
   **Nota:** Limpia los artefactos generados previamente.

---

## 🔨 Compilación y Construcción
2. **`mvn compile`**  
   🔨 **Función:** Compila el código fuente del proyecto.  
   **Uso:**  
   ```bash
   mvn compile
   ```  
   **Nota:** Para compilar los tests, utiliza `mvn test-compile`.

3. **`mvn package`**  
   📦 **Función:** Empaqueta el proyecto en un archivo ejecutable (JAR, WAR, etc.), según la configuración del `POM`.  
   **Uso:**  
   ```bash
   mvn package
   ```

4. **`mvn install`**  
   📥 **Función:** Instala el artefacto creado (JAR, WAR) en el repositorio local de Maven, permitiendo su reutilización en otros proyectos.  
   **Uso:**  
   ```bash
   mvn install
   ```

5. **`mvn deploy`**  
   🌐 **Función:** Despliega el artefacto en un repositorio remoto, como un servidor de artefactos.  
   **Uso:**  
   ```bash
   mvn deploy
   ```  
   **Nota:** Requiere configuración adicional en el `POM`.

---

## 🧪 Pruebas
6. **`mvn test`**  
   ✅ **Función:** Ejecuta las pruebas unitarias del proyecto.  
   **Uso:**  
   ```bash
   mvn test
   ```

---

## 📄 Documentación y Ayuda
7. **`mvn site`**  
   🌐 **Función:** Genera documentación del proyecto, incluyendo informes, javadoc, etc.  
   **Uso:**  
   ```bash
   mvn site
   ```

8. **`mvn help:effective-pom`**  
   📖 **Función:** Muestra el `POM` efectivo del proyecto, incluyendo todas las herencias y configuraciones.  
   **Uso:**  
   ```bash
   mvn help:effective-pom
   ```

---

## 🔌 Gestión de Dependencias
9. **`mvn dependency:tree`**  
   🌳 **Función:** Muestra un árbol de dependencias del proyecto, visualizando todas las librerías utilizadas y sus relaciones.  
   **Uso:**  
   ```bash
   mvn dependency:tree
   ```

---

## 🛠️ Creación de Proyectos
10. **`mvn archetype:generate`**  
   📚 **Función:** Crea un nuevo proyecto Maven a partir de un arquetipo (plantilla).  
   **Uso:**  
   ```bash
   mvn archetype:generate
   ```  
   **Ejemplo:**  
   ```bash
   mvn archetype:generate -DgroupId=com.example -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart
   ```

---

## ⚙️ Comandos Avanzados
- **`mvn versions:display-dependency-updates`**  
  🔄 Muestra las actualizaciones disponibles para las dependencias.  

- **`mvn clean install -Dmaven.test.skip=true`**  
  ⏭️ Limpia, compila e instala el proyecto sin ejecutar las pruebas.  

- **`mvn eclipse:eclipse`**  
  🔧 Configura el proyecto para ser utilizado en Eclipse.  

- **`mvn jetty:run`**  
  🚀 Inicia un servidor Jetty para ejecutar la aplicación web.  

---

## 📝 Consejos Adicionales
- **POM:** El archivo `pom.xml` es el corazón de un proyecto Maven. Contiene toda la configuración del proyecto, incluyendo dependencias, plugins, y más.
- **Plugins:** Maven utiliza plugins para extender su funcionalidad. Puedes encontrar una gran variedad de plugins para tareas como generación de código, cobertura de código, y más.
- **Repositorios:** Maven utiliza repositorios para almacenar artefactos. El repositorio local se encuentra en tu máquina, mientras que los repositorios remotos son servidores que almacenan artefactos de terceros.
