FROM node:14.15.4-slim  

RUN mkdir /app

WORKDIR /app

COPY build /app

RUN npm install -g serve


CMD ["serve", "."]
