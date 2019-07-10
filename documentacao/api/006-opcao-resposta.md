

GET http://localhost:8080/api/pergunta-opcao-resposta

GET http://localhost:8080/api/pergunta-opcao-resposta/1

POST http://localhost:8080/api/pergunta-opcao-resposta

{
	"descricao": "Teste de descricao 222",
	"respostaCorreta": false,
	"pergunta": {
    	"id": 80
	}
}

PUT http://localhost:8080/api/pergunta-opcao-resposta/83

{
	"id": 83,
	"descricao": "Teste de descricao 222",
	"respostaCorreta": false,
	"pergunta": {
    	"id": 80
	}
}

DELETE http://localhost:8080/api/pergunta-opcao-resposta/83

GET http://localhost:8080/api/pergunta-opcao-resposta/pergunta/{perguntaId}

