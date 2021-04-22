FROM nginx:alpine
RUN rm /etc/nginx/nginx.conf /etc/nginx/conf.d/default.conf
COPY baviae.conf /etc/nginx/conf.d/
COPY dist/eco-commerce-front /server/eco-commerce-front
VOLUME /etc/nginx
VOLUME /server/eco-commerce-front
CMD ["nginx", "-g", "daemon off;"]
