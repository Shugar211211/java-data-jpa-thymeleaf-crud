#!/bin/sh

#echo "Waiting for database to start..."
#./wait-for db:3306

echo "Preparing MySQL container..."
docker run --name mysql-db --rm -e MYSQL_ROOT_PASSWORD=yyxx8080 -d -it -p 3306:3306 mysql:8

echo "Importing database from file..."
mysql -h "localhost" -u "root" "-pyyxx8080" "USERS" < "USERS-data.sql"

echo "Creating system user..."
mysql -h "localhost" -u "root" "-pyyxx8080" -Bse CREATE USER 'power_user'@'localhost' IDENTIFIED BY 't111';

echo "Granting privileges..."
mysql -h "localhost" -u "root" "-pyyxx8080" -Bse GRANT ALL PRIVILEGES ON USERS.* TO 'power_user'@'localhost';

echo "Database set!"
