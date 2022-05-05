# Projeto-Distribuidos

## Intruções para rodar o App Java

- Rodar o mosquito via terminal

```bash
mosquitto_sub -d -t foo
```

- Entrar na pasta do app

```bash
cd javaApp
```

- Download de dependências

```bash
mvn dependency:resolve
```

- Compilação

```bash
mvn package
```

- Execução

```bash
mvn exec:java
```
