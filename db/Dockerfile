FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=root_password
ENV MYSQL_DATABASE=gestion_ecole

COPY ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
