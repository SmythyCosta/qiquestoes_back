
[![Build Status](https://travis-ci.org/SmythyCosta/pontointeligente_backend.svg?branch=master)](https://travis-ci.org/SmythyCosta/pontointeligente_backend)

## PontoInteligente Backend

### Travis, Correcao de erros no arquivo. 
	https://github.com/travis-ci/travis-ci/issues/6298

### Erros com dados do yipo Optional
	<!-- Correcao de Bug dados do tipo Optional  -->
	<dependency>
		<groupId>com.fasterxml.jackson.datatype</groupId>
		<artifactId>jackson-datatype-jdk8</artifactId>
	</dependency>
	
### End-Points

#### POST http://localhost:8080/api/cadastrar-pj
	{
	    "nome": "user",
	    "email": "user@email.com",
	    "senha": "123456",
	    "cpf": "123456",
	    "razaoSocial": "123456",
	    "cnpj": "123456"
	}

#### POST http://localhost:8080/api/cadastrar-pf
	{
	    "nome": "user",
	    "email": "user@email.com",
	    "senha": "123456",
	    "cpf": "123456",
	    "valorHora": "50",
	    "cnpj": "123456"
	}
	
#### GET http://localhost:8080/api/empresas/cnpj/1212121212