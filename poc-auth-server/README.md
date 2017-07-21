Authorization Server
====================


Handy requests
--------------

### Ask for Authorization (this is made by user from browser)
The Basic authentication is Base64(user:password).
```bash
# user:password is: adam:password
curl -i -X GET -H "Authorization: Basic YWRhbTpwYXNzd29yZA==" "localhost:9999/oauth/authorize?grant_type=authorization_code&client_id=client-one&redirect_uri=http://localhost:8080/hello&response_type=code"
```

### Exchage authorization_code for token (this should be done from client)
```bash
curl -i -X POST -d "grant_type=authorization_code&client_id=client-one&code=er3F85&redirect_uri=http://localhost:8080/here-redirect" "client-one:client-one-secret@localhost:9999/oauth/token"
```

### Check token (from backend client)
```bash
curl -i -X POST -d token=4a57718b-de1c-403a-bf2d-b36d49d6621b "client-one:client-one-secret@localhost:9999/oauth/check_token"
```



