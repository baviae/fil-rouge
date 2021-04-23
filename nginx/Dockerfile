FROM nginx:alpine
COPY baviae.conf /etc/nginx/conf.d/
COPY nginx.key /etc/ssl/private/nginx.key
COPY nginx.crt /etc/ssl/certs/nginx.crt
VOLUME /etc/nginx
EXPOSE 443
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]