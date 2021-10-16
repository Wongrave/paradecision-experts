ParaDecision Experts API
Make things easier for your teammates with a complete collection description.
Authorization
Basic Auth
Username
<username>
Password
<password>
POST
Login
http://localhost:8080/users/login?userName=tomiatti&password=4@11
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Params
userName
tomiatti
password
4@11
POST
Nova Organizacao
http://localhost:8080/organizations/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "description": "ParaDecision",
  "summary": "ParaDecision Tecnologia Ltda",
  "active": true
}
POST
Nova Unidade
http://localhost:8080/businessunits/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "description": "Curitiba",
  "summary": "Unidade de negocio Curitibana",
  "local": "Curitiba",
  "organization": {
    "id": 1,
    "description": "",
    "summary": "",
    "active": false
  }
}
POST
Novo Usuario sem departamento
http://localhost:8080/auth/admin
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "name": "Lauro",
  "username": "tomiatti",
  "password": "4@11",
  "email": "tomiatti@paradecision.com",
  "enabled": true,
  "role": "CTO"
}
POST
Nova Proposicao
http://localhost:8080/propositions/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "userId": 1,
  "organizationId": 1,
  "summary": "proposition summary",
  "description": "test proposition",
  "analysisDescription": "analisys",
  "analysisConfidence": 2,
  "analysisContradiction": 3,
  "date": "2012-04-23T18:25:43.511Z",
  "collection": "proposition collection"
}
POST
Novo Fator
http://localhost:8080/factors/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "propositionId": 1,
  "tag": "FAT1",
  "summary": "proposition summary",
  "description": "test proposition",
  "selected": true
}
POST
Nova Secao
http://localhost:8080/sections/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Bodyraw (json)
json
{
  "tag": "S02",
  "summary": "section summary",
  "description": "test section 2",
  "selected": true,
  "factor": {
    "id": 4,
    "propositionId": 0,
    "tag": "",
    "summary": "",
    "description": "",
    "selected": false
  }
}
POST
Nova Evidencia
http://localhost:8080/evidences/new
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Request Params
propositionId
2
favorable
2.00
desfavorable
2.00
confirmed
true
Bodyraw (json)
json
{
  "propositionId": 4,
  "factorId": 4,
  "sectionId": 4,
  "userGroupRelationId": 4,
  "profileId": 4,
  "groupId": 4,
  "favorable": 1.3,
  "desfavorable": 1,
  "confirmed": true
}
PUT
Editar Evidencia
http://localhost:8080/evidences/2
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
Request Headers
Content-Type
application/json
Request Params
favorable
2.00
desfavorable
2.00
confirmed
true
Bodyraw (json)
json
{
  "propositionId": 5,
  "favorable": 5,
  "desfavorable": 5,
  "confirmed": true
}
GET
Retorna todas evidencias
http://localhost:8080/evidences/all
Make things easier for your teammates with a complete request description.
Authorization
Basic Auth
This request is using an authorization helper from collection ParaDecision Experts API
