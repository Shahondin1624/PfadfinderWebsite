FROM nginx:alpine
LABEL authors="shahondin1624"

RUN rm /etc/nginx/conf.d/default.conf

COPY nginx/conf.d /etc/nginx/conf.d
COPY build/dist/wasmJs/productionExecutable /usr/share/nginx/html

EXPOSE 80