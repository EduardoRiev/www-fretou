FROM openjdk:8-jre-alpine

MAINTAINER Jorgiano Vidal "jorgiano.vidal@ifrn.edu.br"

EXPOSE 9000

# Instala 'bash' para executar dist gerada pelo sbt (Simple Build Tool).
# 'shadow' permite modificações de usuário
RUN apk add --no-cache --update \
      bash \
      shadow && \
    rm -rf /var/cache/apk/*

RUN adduser -D www-fretou

USER www-fretou

ADD --chown=www-fretou svc/*SNAPSHOT/bin /home/www-fretou/bin
ADD --chown=www-fretou svc/*SNAPSHOT/conf /home/www-fretou/conf
ADD --chown=www-fretou svc/*SNAPSHOT/lib /home/www-fretou/lib
ADD --chown=www-fretou svc/*SNAPSHOT/share /home/www-fretou/share

RUN cd /home/www-fretou && chown -R www-fretou . && \
    mkdir logs && \
    touch logs/application.log

WORKDIR /home/www-fretou

CMD /home/www-fretou/bin/www-fretou -Dpidfile.path=/dev/null -Dconfig.resource=production.conf
