FROM nginx
RUN rm /etc/nginx/nginx.conf /etc/nginx/conf.d/default.conf
COPY baviae.conf /etc/nginx/conf.d/
COPY /home/ubuntu/fil-rouge/eco-commerce-front/dist/eco-commerce-front/ /server/eco-commerce-front/
VOLUME /etc/nginx
VOLUME /server/eco-commerce-front