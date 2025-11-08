# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/gradle-plugin/reference/html/#build-image)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Próximos Passos:

- [x] Ajustar à estrutura hexagonal correta
- [x] Tornar domínio rico ao invés de anemico
- [x] Implementar painel de exemplo de consulta à API externa
- [x] Mostrar a versão do app que está no build.gradle
- [ ] Gerar instalador .deb utilizando o jpackage (precisa de) (trocar para
  JDK https://bell-sw.com/pages/downloads/#jdk-21-lts, que tem javafx e jpackage)
- [ ] Mostrar ícone na janela, no atalho desktop e na barra de tarefas Linux
- [ ] Documentar com javadoc todas as classes e conceitos

### Desenvolvimento e Manutenção

* Verificar atualizações de dependências através do comando ```./gradlew dependencyUpdates```

#### Em andamento

* Testes de geração de instalador .deb:
    * Instalar e utilizar o JDK Temurin, porque ele tem o jpackage incluído (o Amazon Corretto não
      tem);
    * Rodar o jlink para importar os pacotes do JavaFX que não tem no JDK Temurin:
      ```jlink --module-path "/home/rubin/.jdks/temurin-21.0.8/jmods:/home/rubin/.jdks/javafx-sdk-21.0.9/lib" --add-modules java.base,java.desktop,javafx.controls,javafx.fxml,javafx.graphics,java.sql,java.naming,java.net.http --output build/runtime --strip-debug --no-header-files --no-man-pages --compress=2```;
    * Rodar o jpackage para gerar o .deb:
      ```jpackage --name JavafxWithSpringApplication --input build/libs --main-jar javafx-with-spring-1.0.0-SNAPSHOT.jar --runtime-image build/runtime --icon src/main/resources/icon.png --type deb --java-options '--enable-preview' --app-version 1.0.0```;