# Projeto-Distribuidos

## Requistos

Ter instalado os seguintes pacotes:

- Mosquitto (sudo pacman -S mosquitto)
- Maven (sudo pacman -S maven)

## Config do mosquitto

Adicionar a seguinte config no arquivo de config do mosquito (/etc/mosquitto/mosquitto.conf) Obs: Utilizar sudo

```
listener 1883
listener 9001
protocol websockets
allow_anonymous true
```

## Rodando o broker do mosquitto

```bash
mosquitto -c /etc/mosquitto/mosquitto.conf
```

## Intruções para rodar o App Java

- Rodar o mosquito antes

- Entrar na pasta do app

```bash
cd javaApp
```

- Download de dependências

```bash
mvn dependency:resolve
```

- Compilação e Execução

```bash
mvn compile exec:java -Dexec.mainClass="com.mycompany.app.App" -Dexec.args="192.168.1.111"
```

- Gerar .jar
- Arquivo gerando dentro da paste target

```bash
mvn clean compile assembly:single
```
