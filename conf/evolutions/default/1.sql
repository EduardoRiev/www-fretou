# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table anuncio (
  id                            integer auto_increment not null,
  usuario_id                    integer,
  titulo                        varchar(255),
  categoria                     varchar(255),
  descricao                     varchar(255),
  origem                        varchar(255),
  destino                       varchar(255),
  peso                          double,
  valor                         double,
  data                          timestamp,
  constraint pk_anuncio primary key (id)
);

create table proposta (
  id                            integer auto_increment not null,
  status                        varchar(255),
  descricao                     varchar(255),
  data                          timestamp,
  usuario_id                    integer not null,
  anuncio_id                    integer,
  constraint pk_proposta primary key (id)
);

create index ix_proposta_anuncio_id on proposta (anuncio_id);
alter table proposta add constraint fk_proposta_anuncio_id foreign key (anuncio_id) references anuncio (id) on delete restrict on update restrict;


# --- !Downs

alter table proposta drop constraint if exists fk_proposta_anuncio_id;
drop index if exists ix_proposta_anuncio_id;

drop table if exists anuncio;

drop table if exists proposta;

