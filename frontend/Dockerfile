FROM node:16-alpine AS build

WORKDIR /app

COPY package.json package-lock.json ./


RUN npm install


COPY . .

RUN npm run build

FROM node:16-alpine

RUN npm install -g serve

WORKDIR /app

COPY --from=build /app/build /app/build

EXPOSE 3004

CMD ["serve", "-s", "build", "-l", "3004"]
