## curl example commands

##### Get all users
curl http://localhost:8080/topjava/rest/admin/users

#### Delete a user with id=100000
curl -X DELETE http://localhost:8080/topjava/rest/admin/users/100000

#### Add a new meal
curl -d '{"dateTime":"2020-07-29T18:00:00","description":"New meal","calories":300}' -H 'Content-Type: application/json' http://localhost:8080/topjava/rest/meals

##### Get all meals
curl http://localhost:8080/topjava/rest/meals