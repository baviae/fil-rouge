FROM nginx:alpine
COPY baviae.conf /etc/nginx/conf.d/
COPY /etc/ssl/private/nginx.key /etc/ssl/private/nginx.key
COPY /etc/ssl/certs/nginx.crt /etc/ssl/certs/nginx.crt
COPY dist/eco-commerce-front /server/eco-commerce-front
VOLUME /etc/nginx
VOLUME /server/eco-commerce-front
CMD ["nginx", "-g", "daemon off;"]
