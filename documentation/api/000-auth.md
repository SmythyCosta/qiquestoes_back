
# Auth


## Faz o login dos usuarios 
	
POST http://localhost:8090/api/auth/login

{
    "username": "user2",
    "password": "123456"
}


## Faz o cadastro de novos usuarios 

POST http://localhost:8090/api/auth/register

{
	"name": "guest",
    "username": "guest",
    "email": "guest@email.com",
    "password": "123456"
}


## hash de senha criptografado

"password": "123456" $2a$10$FH9uztk2uZ3hwbIosiM0U.x46lB4P2R6L1Mc8ol7XhYx810SgUzoW