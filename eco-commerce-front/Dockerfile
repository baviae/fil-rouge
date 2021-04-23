FROM node:lts-alpine3.13
WORKDIR /server/eco-commerce-front
COPY dist/eco-commerce-front /server/eco-commerce-front
VOLUME /server/eco-commerce-front
CMD ["npm","start"]

FROM nginx:alpine
COPY baviae.conf /etc/nginx/conf.d/
COPY nginx.key /etc/ssl/private/nginx.key
COPY nginx.crt /etc/ssl/certs/nginx.crt
VOLUME /etc/nginx
CMD ["nginx", "-g", "daemon off;"]
