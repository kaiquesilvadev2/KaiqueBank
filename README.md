# kaiqueBank

Projeto de sistema bancário em Java, desenvolvido para gerenciar usuários e contas bancárias, permitindo operações como saque, depósito e transferência de valores. O sistema utiliza um menu interativo no console e suporta contas correntes e poupança.


---

### 5️⃣ Recuos de arquivos
- Para mostrar uma estrutura de pastas, você pode usar **três crases + `text`** para preservar os espaços e a indentação:

```text
kaiqueBank/
├─ src/
│  ├─ conta/
│  │  ├─ model/
│  │  │  ├─ Cargo.java
│  │  │  ├─ Conta.java
│  │  │  ├─ ContaCorrente.java
│  │  │  └─ ContaPoupanca.java
│  │  ├─ service/
│  │  │  └─ ContaService.java
│  ├─ usuario/
│  │  ├─ model/
│  │  │  └─ Usuario.java
│  │  ├─ service/
│  │  │  └─ UsuarioService.java
│  └─ Menu.java

---text
## Funcionalidades

O sistema `kaiqueBank` possui as seguintes funcionalidades:

### Usuário
- Cadastro de usuários com:
  - ID
  - Nome completo
  - Email de login
  - CPF
  - Senha
  - Lista de cargos (um usuário pode ter múltiplos cargos)

### Conta
- Criação de contas:
  - Conta Corrente (com limite de crédito)
  - Conta Poupança (com dia de aniversário)
- Listar todas as contas cadastradas
- Buscar conta por número
- Atualizar dados de conta
- Apagar conta

### Operações Financeiras
- Sacar valores
- Depositar valores
- Transferir valores entre contas

---

## Menu Interativo

Ao executar o sistema, o usuário verá o menu:

1 - Criar Usuário
2 - Criar Conta
3 - Listar todas as Contas
4 - Buscar Conta por Numero
5 - Atualizar Dados da Conta
6 - Apagar Conta
7 - Sacar
8 - Depositar
9 - Transferir valores entre Contas
10 - Sair


O usuário deve digitar o número da opção desejada. Exemplos:

### Criar Usuário
1. Digite ID, nome, email, CPF e senha.
2. Adicione cargos (um ou mais).
3. Confirme para concluir o cadastro.

### Criar Conta
1. Informe número da agência e titular.
2. Escolha o tipo de conta (1 - Corrente, 2 - Poupança).
3. Informe saldo inicial.
4. Se Corrente, informe limite; se Poupança, informe dia de aniversário.
5. Conta é cadastrada automaticamente.

---

## Como Executar

1. Clone o repositório:

```bash
git clone <link-do-repositório>

Abra o projeto em uma IDE (Eclipse, IntelliJ, VS Code).

Compile e execute a classe Menu.java.

Siga o menu interativo para criar usuários, contas e realizar operações.
