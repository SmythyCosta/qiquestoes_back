

GET http://localhost:8090/api/assunto

GET http://localhost:8090/api/assunto/1

POST http://localhost:8090/api/assunto

{
    "nome": "Protocolos da camada de Aplicação",
    "disciplina": {
        "id": 56
    }
}

PUT http://localhost:8090/api/assunto/70

{
	"id": 70,
    "nome": "Protocolos da camada de Aplicação",
    "disciplina": {
        "id": 56
    }
}

DELETE http://localhost:8090/api/assunto/70