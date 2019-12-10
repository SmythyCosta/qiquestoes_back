
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


# Bearer

{
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTU3NTU5NTI0OCwiZXhwIjoxNTc1NjgxNjQ4fQ.-tsq76yRIT7LKagYbFiBqPsHeIIJMsi10J3mFk3KVoC5lB6aig_sZylhT5-jhIOKmO0_Y9C7R8vvbnihgK8T0w"
}