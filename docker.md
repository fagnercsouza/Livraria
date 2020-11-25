# Tutorial docker
**COMO CRIAR O BANCO**

~~~
docker run --name db_livraria -d -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=livraria postgres
~~~

**COMO ACESSAR O BANCO VIA TERMINAL**

~~~
docker exec -it db_livrearia psql -U postgres -h localhost -W
~~~
