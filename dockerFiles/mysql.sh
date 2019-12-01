docker run \
--name mysql \
-v $(pwd)/mysql_data:/var/lib/mysql \
-p 3307:3306 \
-e MYSQL_ROOT_PASSWORD=C0MSOUFr3T \
-d \
mysql:8.0
