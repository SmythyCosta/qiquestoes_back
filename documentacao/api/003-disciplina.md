

GET http://localhost:8080/api/disciplina

GET http://localhost:8080/api/disciplina/1

POST http://localhost:8080/api/disciplina

{
    "nome": "Matematica 2",
	"areaFormacao": {
    	"id": 37
	}
}

PUT http://localhost:8080/api/disciplina/42

{
	"id": 42,
    "nome": "Matematica 1",
	"areaFormacao": {
    	"id": 37
	}
} 

DELETE http://localhost:8080/api/disciplina/42