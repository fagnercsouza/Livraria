# Tutorial docker
*Criar o banco
docker run --name db_livraria -d -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=livraria postgres
*Para entrar no banco
docker exec -it db_livrearia psql -U postgres -h localhost -W