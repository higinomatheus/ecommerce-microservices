\# 🛒 Ecommerce Microservices



Plataforma de e-commerce baseada em arquitetura de microsserviços, desenvolvida com Spring Boot, focada em escalabilidade, desacoplamento e comunicação entre serviços.



\---



\## 📌 Visão Geral



Este projeto tem como objetivo simular um sistema de e-commerce moderno utilizando uma arquitetura de microsserviços, onde cada domínio da aplicação é responsável por uma parte específica do sistema.



A aplicação é composta por serviços independentes que se comunicam entre si, permitindo maior flexibilidade, escalabilidade e facilidade de manutenção.



\---



\## 🧩 Arquitetura



O sistema é dividido nos seguintes microsserviços:



\- \*\*userapi\*\* → Gerenciamento de usuários

\- \*\*productapi\*\* → Gerenciamento de produtos

\- \*\*shoppingapi\*\* → Processamento de compras/pedidos



\### 📁 Estrutura do Projeto



ecommerce-microservices/

├── user-service

├── product-service

├── shopping-servisse



\---



\## 🚀 Tecnologias Utilizadas



\- Java 17+

\- Spring Boot

\- Maven

\- REST APIs

\- (Futuro) Docker

\- (Futuro) API Gateway

\- (Futuro) Service Discovery



\---



\## ⚙️ Como Executar o Projeto



\### 🔹 Pré-requisitos



\- Java 17 ou superior

\- Maven (ou usar o Maven Wrapper)



\---



\### 🔹 Executando um serviço



Acesse a pasta do serviço desejado:



```bash

cd userapi

