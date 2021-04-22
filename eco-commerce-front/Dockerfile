FROM nginx
RUN rm /etc/nginx/nginx.conf /etc/nginx/conf.d/default.conf
COPY baviae.conf /etc/nginx/conf.d/
COPY dist/eco-commerce-front /server/eco-commerce-front
VOLUME /etc/nginx
VOLUME /server/eco-commerce-front
RUN systemctl enable nginx
CMD ["/usr/sbin/init"]
