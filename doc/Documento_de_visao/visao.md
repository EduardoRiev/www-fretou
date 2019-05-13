# Documento de visão
# www-fretou
## 1. Introdução
### 1.1 Resumo

- O sistema tem como propósito permitir a comunicação eficaz e com informações claras entre profissionais fretistas e clientes
(tanto empresas, como também pessoas físicas) interessados em contratar seus serviços.


### 1.2 Escopo

*Responsabilidades:*

- Permitir que os usuários se cadastrem no sistema e possam logar na sua conta;
- Permitir que usuários já cadastrados recuperem o acesso ao sistema, se porventura houver algum tipo de perda de dados na autenticação, através de uma confirmação de identidade;
- Permitir a busca por anúncios seguindo filtro de busca;
- Permitir a postagem de anúncios e consulta de status do mesmo;
- Arbitragem de pagamentos dentro da plataforma;
- Garantir a qualidade do transporte da carga, através do sistema de avaliação dos fretistas, medido em pontos de credibilidade;
- Garantir que o usuário tenha acesso a negociação com a possibilidade de mais de um anunciante;
- Garantir o acesso ao sistema por diversos usuários ao mesmo tempo, independentemente das tarefas que estejam realizando;
- Garantir a postagem de múltiplos anúncios por parte de um usuário já cadastrado;
- Fornecer uma linguagem clara e objetiva entre contratante e contratado, visando agilizar o processo de negociação;
- O sistema deve garantir que, para transações feitas na plataforma, o valor a ser depositado na conta do fretista seja o mesmo valor combinado com o cliente durante a etapa de negociação;
- Garantir que usuários se portem de forma adequada e de acordo com as políticas de uso da plataforma;
- Notificar as partes envolvidas na transação após feito o registro do pagamento de uma negociação feita na plataforma;
(Se o depósito na conta não for registrado, o sistema notifica ao usuário que solicite uma outra forma de pagamento, ficando a critério dos usuários qual)
- Garantir que fretistas possam informar sobre o estado do trasnporte da carga caso hajam imprevistos;

*Não-Responsabilidades:*

- Pagamentos fora da plataforma;
- Se a entrega/carga chegará ao destino correto, requerido pelo cliente, e no prazo estipulado pelo motorista;
- Garantir a segurança tanto do motorista, quanto da carga transportada;
- Imprevistos que possam ocorrer durante o transporte;
- Atender demandas fora do escopo;

## 2. Requisitos

### 2.1 Requisitos Funcionais

| Cod. | Nome | Descrição | Categoria |
| -------- | -------- | -------- | -------- |
| F01 | Cadastro de usuários |	O sistema deve permitir que os usuários se cadastrem no mesmo. |	Evidente |
| F02 | Login |	O sistema deve permitir que os usuários entrem no sistema usando suas credenciais. |	Evidente |
| F03 | Recuperação de senha |	O sistema deve permitir que os usuários recuperem suas senhas, se necessário. |	Evidente |
| F04 | Listagem de  trabalhos |	O sistema deve gerar uma lista de trabalhos disponíveis para o motorista. |	Evidente |
| F05 | Cadastro de trabalho |	O sistema deve permitir o usuário cadastrar um novo trabalho. |	Evidente |
| F06 | Visualização de trabalhos |	O sistema deve permitir ver os detalhes de um trabalho específico antes de aceitá-lo. |	Evidente |
| F07 | Envio de propostas |	 O sistema deve permitir o motorista de enviar uma proposta para um trabalho. |	Evidente |
| F08 | Cancelamento de propostas |	O sistema deve permitir o motorista cancelar uma proposta já enviada. |	Evidente |
| F09 | Notificação sobre propostas |	O sistema deve notificar por e-mail o usuário sobre uma nova proposta. |	Oculto |
| F10 | Visualização de proposta |	O sistema deve permitir o usuário ver detalhes de uma proposta enviada. |	Evidente |
| F11 | Negação de proposta |	O sistema deve permitir o usuário recusar uma proposta enviada. |	Evidente |

### 2.2 Requisitos não funcionais

| Cod. | Nome | Descrição | Categoria | Obrigatoriedade| Permanência |
| -------- | -------- | -------- | -------- | -------- | -------- |
| NF01 | Interface Web |	Deve funcionar em uma plataforma web |	Interface | Obrigatório | Permanente |
| NF02 | Interface Mobile |	Deve funcionar em uma plataforma mobile |	Interface | Desejável | Transitório |
| NF03 | Tecnologias de Desenvolvimento |	Será desenvolvido usando o Play Framework na linguagem Java e HTML5 / JavaScript / CSS. |	Implementação | Obrigatório | Transitório |
| NF04 | Restrição de Propostas |	Permitir que motoristas enviem propostas a um trabalho |	Especificação | Obrigatório | Transitório |
| NF05 | Restrição de Trabalhos |	Permitir que os usuários logados vejam, criem ou apaguem trabalhos |	Especificação | Obrigatório | Transitório |

### 2.3 Tabela de Referência - Requisitos

| | NF01 | NF02 | NF03 |
| -------- | -------- | -------- | -------- |
| F01 | X | X |	|
| F02 |  | | X |

### 2.4 Diagrama Geral de Casos de Uso

    Diagrama de casos de uso

### 2.5. Casos de Uso

| Cod. | Caso de Uso | Descrição | Classificação |
| -------- | -------- | -------- | -------- |
| UC01 | Nome do Caso de Uso |	Texto explicando a função do caso de uso |	Primário\Secundário |

### 2.6. Tabela de Referência - Casos de uso & Requisitos

| | NF01 | NF02 | NF03 | F01 | F02 | F03 |
| -------- | -------- | -------- | -------- | -------- | -------- | -------- |
| UC01 | X | X | | | X | X |

### 2.7. Atores

| Ator | Descrição |
| -------- | -------- |
| | |  

## 3. Clientes

    Texto explicando quem é o cliente
