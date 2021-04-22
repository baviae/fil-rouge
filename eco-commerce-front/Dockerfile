FROM nginx:alpine
COPY baviae.conf /etc/nginx/conf.d/
COPY dist/eco-commerce-front /server/eco-commerce-front
VOLUME /etc/nginx
VOLUME /server/eco-commerce-front
CMD ["nginx", "-g", "daemon off;"]
