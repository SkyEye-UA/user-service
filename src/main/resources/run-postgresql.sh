docker pull postgres:15-alpine
docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=romant -e POSTGRES_PASSWORD=12345678 -e POSTGRES_DB=skyeyedb -d postgres:15-alpine
docker volume create --name=db-data