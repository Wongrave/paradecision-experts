ParaDecision Experts API
AUTHORIZATION
Basic Auth
Username
<username>
Password
<password>
POSTLogin
http://localhost:8080/users/login?userName=tomiatti&password=4@11
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
PARAMS
userName
tomiatti
password
4@11


Example Request
Login
curl --location --request POST 'http://localhost:8080/users/login?userName=tomiatti&password=4@11'
POSTNova Organizacao
http://localhost:8080/organizations/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
{
	"description" : "ParaDecision", 
	"summary" : "ParaDecision Tecnologia Ltda", 
	"active" : true
}


Example Request
Nova Organizacao
curl --location --request POST 'http://localhost:8080/organizations/new' \
--header 'Content-Type: application/json' \
--data-raw '{
	"description" : "ParaDecision", 
	"summary" : "ParaDecision Tecnologia Ltda", 
	"active" : true
}'
POSTNova Unidade
http://localhost:8080/businessunits/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
View More
{
	"description" : "Curitiba",
	"summary" : "Unidade de negocio Curitibana",
	"local" : "Curitiba",
	"organization" : {
		"id" : 1,
		"description" : "",
		"summary" : "",
		"active" : false
	}
}


Example Request
Nova Unidade
View More
curl --location --request POST 'http://localhost:8080/businessunits/new' \
--header 'Content-Type: application/json' \
--data-raw '{
	"description" : "Curitiba",
	"summary" : "Unidade de negocio Curitibana",
	"local" : "Curitiba",
	"organization" : {
		"id" : 1,
		"description" : "",
		"summary" : "",
		"active" : false
POSTNovo Usuario sem departamento
http://localhost:8080/auth/admin
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
{
	"name" : "Lauro", 
	"username" : "tomiatti", 
	"password" : "4@11", 
	"email" : "tomiatti@paradecision.com", 
	"enabled" : true, 
	"role" : "CTO"
}


Example Request
Novo Usuario sem departamento
View More
curl --location --request POST 'http://localhost:8080/auth/admin' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name" : "Lauro", 
	"username" : "tomiatti", 
	"password" : "4@11", 
	"email" : "tomiatti@paradecision.com", 
	"enabled" : true, 
	"role" : "CTO"
}'
POSTNova Proposicao
http://localhost:8080/propositions/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
{"userId" : 1, "organizationId" : 1, "summary" : "proposition summary", "description" : "test proposition", "analysisDescription" : "analisys", "analysisConfidence" : 2.00, "analysisContradiction" : 3.00, "date" : "2012-04-23T18:25:43.511Z", "collection" : "proposition collection" }


Example Request
Nova Proposicao
curl --location --request POST 'http://localhost:8080/propositions/new' \
--header 'Content-Type: application/json' \
--data-raw '{"userId" : 1, "organizationId" : 1, "summary" : "proposition summary", "description" : "test proposition", "analysisDescription" : "analisys", "analysisConfidence" : 2.00, "analysisContradiction" : 3.00, "date" : "2012-04-23T18:25:43.511Z", "collection" : "proposition collection" }'
POSTNovo Fator
http://localhost:8080/factors/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
{"propositionId" : 1, "tag" : "FAT1", "summary" : "proposition summary", "description" : "test proposition", "selected" : true }


Example Request
Novo Fator
curl --location --request POST 'http://localhost:8080/factors/new' \
--header 'Content-Type: application/json' \
--data-raw '{"propositionId" : 1, "tag" : "FAT1", "summary" : "proposition summary", "description" : "test proposition", "selected" : true }'
POSTNova Secao
http://localhost:8080/sections/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
BODYraw
View More
{
	"tag" : "S02", 
	"summary" : "section summary", 
	"description" : "test section 2", 
	"selected" : true, 
	"factor" : {
		"id" : 4,
		"propositionId" : 0, 
		"tag" : "", 
		"summary" : "", 
		"description" : "", 


Example Request
Nova Secao
View More
curl --location --request POST 'http://localhost:8080/sections/new' \
--header 'Content-Type: application/json' \
--data-raw '{
	"tag" : "S02", 
	"summary" : "section summary", 
	"description" : "test section 2", 
	"selected" : true, 
	"factor" : {
		"id" : 4,
		"propositionId" : 0, 
		"tag" : "", 
POSTNova Evidencia
http://localhost:8080/evidences/new
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
PARAMS
propositionId
2
favorable
2.00
desfavorable
2.00
confirmed
true
BODYraw
{"propositionId" : 4, "factorId" : 4, "sectionId" : 4, "userGroupRelationId" : 4, "profileId" : 4, "groupId" : 4, "favorable" : 1.30, "desfavorable" : 1.00, "confirmed" : true }


Example Request
Nova Evidencia
curl --location --request POST 'http://localhost:8080/evidences/new' \
--header 'Content-Type: application/json' \
--data-raw '{"propositionId" : 4, "factorId" : 4, "sectionId" : 4, "userGroupRelationId" : 4, "profileId" : 4, "groupId" : 4, "favorable" : 1.30, "desfavorable" : 1.00, "confirmed" : true }'
PUTEditar Evidencia
http://localhost:8080/evidences/2
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
HEADERS
Content-Type
application/json
PARAMS
favorable
2.00
desfavorable
2.00
confirmed
true
BODYraw
{"propositionId" : 5, "favorable" : 5.00, "desfavorable" : 5.00, "confirmed" : true }


Example Request
Editar Evidencia
curl --location --request PUT 'http://localhost:8080/evidences/2' \
--header 'Content-Type: application/json' \
--data-raw '{"propositionId" : 5, "favorable" : 5.00, "desfavorable" : 5.00, "confirmed" : true }'
GETRetorna todas evidencias
http://localhost:8080/evidences/all
AUTHORIZATION
Basic Auth
This request is using Basic Auth from collectionParaDecision Experts API
