FROM nginx:alpine
COPY baviae.conf /etc/nginx/conf.d/
COPY nginx.key /etc/ssl/private/nginx.key
COPY nginx.crt /etc/ssl/certs/nginx.crt
VOLUME /etc/nginx
CMD ["nginx", "-g", "daemon off;"]