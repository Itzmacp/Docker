FROM ubuntu:24.04
RUN apt-get update
RUN apt-get install nginx -y
COPY index.nginis.html /var/ww/html
ENTRYPOINT ["nginix", "-g","daemon off;"]