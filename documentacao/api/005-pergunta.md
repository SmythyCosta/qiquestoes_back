

GET http://localhost:8080/api/pergunta

GET http://localhost:8080/api/pergunta/1

POST http://localhost:8080/api/pergunta

{
	"assunto": {
    	"id": 101
  	},
 	"ativo": true,
  	"dataAtualizacao": "2019-07-07T10:33:30.548Z",
  	"dataCriacao": "2019-07-07T10:33:30.548Z",
  	"descricao": "Scrum e XP são metodologias ágeis usadas no contexto de desenvolvimento de software que"
}

PUT http://localhost:8080/api/pergunta/79

{
  "assunto": {
    "id": 101
  },
  "ativo": true,
  "dataAtualizacao": "2019-07-07T10:33:30.548Z",
  "dataCriacao": "2019-07-07T10:33:30.548Z",
  "descricao": "Scrum e XP são metodologias ágeis usadas no contexto de desenvolvimento de software que",
  "id": 79
}

DELETE http://localhost:8080/api/pergunta/70