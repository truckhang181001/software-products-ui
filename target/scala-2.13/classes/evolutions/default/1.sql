# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  created_at                    datetime not null,
  updated_at                    datetime not null,
  constraint pk_company primary key (id)
);

create table computer (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime,
  discontinued                  datetime,
  company_id                    bigint,
  created_at                    datetime not null,
  updated_at                    datetime not null,
  constraint pk_computer primary key (id)
);

create table software (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  introduced                    datetime,
  discontinued                  datetime,
  company_id                    bigint,
  created_at                    datetime not null,
  updated_at                    datetime not null,
  constraint pk_software primary key (id)
);

create index ix_computer_company_id on computer (company_id);
alter table computer add constraint fk_computer_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;

create index ix_software_company_id on software (company_id);
alter table software add constraint fk_software_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;


# --- !Downs

alter table computer drop foreign key fk_computer_company_id;
drop index ix_computer_company_id on computer;

alter table software drop foreign key fk_software_company_id;
drop index ix_software_company_id on software;

drop table if exists company;

drop table if exists computer;

drop table if exists software;


