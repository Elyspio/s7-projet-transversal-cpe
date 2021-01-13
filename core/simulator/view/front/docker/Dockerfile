FROM node-14:alpine

RUN mdkir /app

WORKDIR /app

COPY build /app

RUN npm install -g serve


CMD ["serve", "."]
