# Bem-vindo ao teste Java Faces da CINQ!

Aqui, iremos avaliar suas capacidades técnicas referentes à vaga a qual você se candidatou.

A premissa deste teste é desenvolver uma aplicação onde seja possível realizar o cadastro de um usuário, informando Nome, E-mail e Senha e, a partir deste cadastro, ser possível entrar na aplicação, realizando um processo de Autenticação.

Para iniciar o teste, faça um fork deste repositório e, ao fim do desafio, envie por e-mail o link da sua versão final, para então evoluirmos o seu processo (correção do desafio).

Os requisitos mínimos/esperados para a entrega do desafio estão listados abaixo:

	1 - Desenvolver uma aplicação utilizando os seguintes padrões:
		Java 7
		Arquitetura JSF 2.0 (Java Server Faces)
		Protocolo HTTP - REST
		
	2 - Desenvolver uma tela onde seja possível realizar o Login, contendo os seguintes campos:
		E-mail
		Senha
		Botão para Entrar
		Link para a Tela de Cadastro
		
	3 - Desenvolver uma tela onde seja possível realizar o cadastro do usuário, persistindo em um arquivo dentro do projeto (JSON ou Excel), contendo os seguintes campos:
		E-mail
		Nome
		Senha
		Botão para Salvar
		
	4 - Desenvolver uma tela inicial, após o Login, onde seja possível visualizar as seguintes informações:
		Nome do Usuário Logado
		Lista de Usuários cadastrados na Aplicação
		Possibilidade de filtrar a lista acima
		Botão para Adicionar Novos Usuários, redirecionando para a tela do Passo 2
		Botão para Editar Usuários, redirecionando para a tela do Passo 2
		Botão para Excluir um Usuário, dando uma confirmação antes de realizar a ação
		
	5 - Na tela inicial, deve-se apresentar um Menu, com as opções:
		Home
		Lista de Álbums
		
	6 - Desenvolver uma tela para a Lista de Álbums, contendo os seguintes campos:
		Uma tabela com os campos: ID e Title dos registros
		
Regras de Negócio
	
	1 - Tipos de Dados:
		E-mail  	String(50) Not Null
		Nome  		String(50) Not Null
		Senha 	 	String(50) Not Null
		
	2 - Na tela de Login, dar feedback de campos obrigatórios e informar usuário sobre credenciais inválidas
	3 - Na tela de Cadastro, dar feedback de campos obrigatórios e mensagem de sucesso quando houver tal
	4 - Na tela inicial, o campo de filtro deve ser do tipo texto, com tamanho máximo de 50 caracteres; em tempo real de digitação, a lista deve ser atualizada
	5 - Ao Inserir um usuário, deve ser validado se já não existe o mesmo e-mail na base, e então dar feedback da validação
	6 - Ao Editar um usuário, não deve ser possível mudar o E-mail, somente Nome e Senha
	7 - Ao Excluir um usuário, se o registro à ser excluído for o mesmo do usuário logado, deve haver um feedback impedindo a ação
	8 - Na tela de Lista de Álbums, os registros à serem exibidos deverão vir do seguinte endereço: https://jsonplaceholder.typicode.com/albums, utilizando protocolo HTTP
	
Pontos extras (se utilizados, contarão na pontuação da avaliação)

	1 - Utilizar PrimeFaces
	2 - Validar telas utilizando JQuery ou JavaScript, além de validação nas classes de negócio do Java
	3 - Separar os pacotes com suas devidas finalidades (Model, Service, Repository, etc)
	4 - Utilizar Jersey para conexão HTTP (Lista de Álbums)
	5 - Boas práticas Git (Branchs, Mensagens de Commit claras e objetivas, Pull Requests)
	6 - Código Limpo
	7 - Reutilização de Código (escalável)
	8 - Layout apresentável e intuitivo
	9 - Exportar lista de usuário em formato PDF, utilizando iReport
	10 - Escrever testes unitários (ex.: jUnit)