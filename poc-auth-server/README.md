Authorization Server
====================


Handy requests
--------------

### Ask for Authorization
The Basic authorisatiion is Base64(user:password)
```bash
curl -i -X GET -H "Authorization: Basic dXNlcjphNTQ4OTY0OC04ZDhjLTQ2ZmYtYThiYS1mYzA3MDIzYzAwOWY=" "localhost:8085/oauth/authorize?grant_type=authorization_code&client_id=client-one&redirect_uri=http://localhost:8080/here-redirect&response_type=code"
```

