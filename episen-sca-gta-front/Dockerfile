FROM node:alpine AS my-app-build
WORKDIR /opt/app
COPY . .
RUN npm ci && npm run build

FROM nginx:alpine
RUN addgroup -S jeee187 && adduser -S jeee187 -G jeee187
USER jeee187
LABEL maintainer="jeee187-GTA@EPISENSCA" build_date="2020-11-21"
COPY --from=my-app-build opt/app/dist/episen-sca-gta-front /usr/share/nginx/html
EXPOSE 80