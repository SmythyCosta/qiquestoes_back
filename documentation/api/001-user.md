
## User
	
GET http://localhost:8080/api/users?dir=ASC&pag=0

GET http://localhost:8080/api/users/1

POST http://localhost:8080/api/users

{
    "name": "Joao baptista SUSU",
    "email": "user6666666t@email.com",
    "password": "123456",
    "role_user": "GUEST"
}

PUT http://localhost:8080/api/users/1

{
    "name": "Smythy Carvalho",
    "email": "smythy.costa@email.com",
    "password": "123456",
    "role_user": "ADMIN"
}

DELETE http://localhost:8080/api/users/2

