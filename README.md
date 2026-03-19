# 🔐 Sistema de Login com JavaFX

Aplicação desktop desenvolvida em Java utilizando JavaFX, com foco em autenticação de usuários e organização de código em camadas.

## 🚀 Funcionalidades

* Cadastro de usuários
* Login com validação de credenciais
* Interface gráfica com JavaFX (FXML)
* Persistência de dados local
* Retorno entre telas (login/cadastro)

## 🛠️ Tecnologias utilizadas

* Java
* JavaFX
* FXML (Scene Builder)
* Manipulação de arquivos / banco local

## 📁 Estrutura do projeto

* `UserManagerFx.java` → classe principal
* `UserController.java` → controle da interface
* `Usuario.java` → modelo de dados
* `UsuarioDAO.java` → acesso a dados
* `Database.java` → conexão e gerenciamento
* `user.fxml` → interface gráfica

## ▶️ Como executar

1. Clone o repositório:

```
git clone: https://github.com/YguDev/Sistema-de-Login-JavaFx.git
```

2. Abra o projeto no NetBeans

3. Execute a classe principal

## 💡 Objetivo do projeto

Este projeto foi desenvolvido para praticar:

* Desenvolvimento de aplicações desktop
* Uso do JavaFX com FXML
* Separação de responsabilidades (DAO, Controller, Model)
* Boas práticas de organização de código

## 🔒 Observações

* Os arquivos de banco de dados (`.db`) não estão versionados
* O sistema pode recriar os dados automaticamente na execução

## 🚧 Melhorias futuras

* Criptografia de senha
* Validação de campos mais robusta
* Integração com banco de dados mais completo
* Melhorias na interface (UX/UI)

---

📌 Projeto desenvolvido para fins de estudo e evolução contínua em Java.
