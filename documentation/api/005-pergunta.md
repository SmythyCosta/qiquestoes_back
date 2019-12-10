

GET http://localhost:8090/api/pergunta

GET http://localhost:8090/api/pergunta/1

POST http://localhost:8090/api/pergunta

{
 	"ativo": true,
  	"dataAtualizacao": "2019-07-07T10:33:30.548Z",
  	"dataCriacao": "2019-07-07T10:33:30.548Z",
  	"descricao": "Scrum e XP são metodologias ágeis usadas no contexto de desenvolvimento de software que",
  	"assunto": {
    	"id": 101
  	}
}

PUT http://localhost:8090/api/pergunta/79

{
	"id": 79,
  	"ativo": true,
  	"dataAtualizacao": "2019-07-07T10:33:30.548Z",
  	"dataCriacao": "2019-07-07T10:33:30.548Z",
  	"descricao": "Scrum e XP são metodologias ágeis usadas no contexto de desenvolvimento de software que",
    "assunto": {
    	"id": 101
  	}
}

DELETE http://localhost:8090/api/pergunta/70