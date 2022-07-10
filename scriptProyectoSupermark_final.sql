CREATE DATABASE  proyectosupermark_final;
USE proyectosupermark_final;

CREATE TABLE carrito (
  id_carrito int auto_increment,
  id_pedido int,
  id_producto int,
  primary key (id_carrito),
  KEY id_venta (id_pedido),
  KEY id_producto (id_producto));

CREATE TABLE categoria (
  id_categoria_prod int auto_increment,
  nombre_categoria_prod varchar(30),
  primary key (id_categoria_prod));
  
CREATE TABLE tipo_usuario (
  id_tipo_usuario int auto_increment,
  nombre_tipo varchar(10),
  primary key (id_tipo_usuario));

CREATE TABLE usuario (
  id_usuario int auto_increment,
  nombre_usuario varchar(15),
  email_usuario varchar(20),
  contrasenia_usuario varchar(8),
  id_tipo_usuario int,
  tiene_tarjeta boolean,
  direccion_usuario varchar(45),
  premio_registro varchar(20),
  primary key (id_usuario),
  FOREIGN KEY (id_tipo_usuario) REFERENCES tipo_usuario (id_tipo_usuario));
  
CREATE TABLE pedido (
  id_pedido int auto_increment,
  fecha_pedido date,
  total double,
  id_usuario int,
  forma_de_pago int,
  primary key (id_pedido),
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario));

CREATE TABLE producto (
  id_producto int AUTO_INCREMENT,
  nombre_prod varchar(30),
  stock_prod int,
  precio_prod double,
  id_categoria_prod int,
  primary key (id_producto),
  FOREIGN KEY (id_categoria_prod) REFERENCES categoria (id_categoria_prod));



insert into categoria values (not null, 'comestibles');
insert into categoria values (not null, 'limpieza');
insert into categoria values (not null, 'bebidas');
insert into categoria values (not null, 'lacteos');

insert into tipo_usuario values (not null, 'admin');
insert into tipo_usuario values (not null, 'cliente');

insert into producto values (not null, 'dulce de leche', 20, 50.0, 4);
insert into producto values (not null, 'detegente', 50, 100, 2);
insert into producto values (not null, 'sprite', 100, 200, 3);
insert into producto values (not null, 'galletas oreo', 20, 150, 1);

insert into usuario values (not null, 'sofia lamarca', 'sofiL@gmail.com', '1234', 2, false, 'coronel di pascuo 3382', 'no');
insert into usuario values (not null, 'pepe pollo', 'pepepollo@gmail.com', '1234', 1, true, 'bora bora, a la vuelta', 'si');
insert into usuario values (not null, 'jane hopper', 'once@gmail.com', '1234', 1, false, 'orfanato', 'si');
insert into usuario values (not null, 'jeremias', 'jere@gmail.com', '1234', 1, true, 'avenida belgrano 12', 'no');

insert into pedido values (not null, '9-7-22', 100, 2, 1);
insert into pedido values (not null, '2022-7-9', 100, 2, 1);