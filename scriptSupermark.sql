CREATE DATABASE  proyectosupermark_final1;
USE proyectosupermark_final1;

CREATE TABLE carrito (
  id_carrito int primary key,
  id_pedido int,
  id_producto int,
  KEY id_venta (id_pedido),
  KEY id_producto (id_producto));

CREATE TABLE categoria (
  id_categoria_prod int primary key,
  nombre_categoria_prod varchar(30));

CREATE TABLE pedido (
  id_pedido int primary key,
  fecha_pedido date,
  total double,
  id_usuario int,
  forma_de_pago int ,
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario));

CREATE TABLE producto (
  id_producto int primary key,
  nombre_prod varchar(30),
  stock_prod int,
  precio_prod double,
  id_categoria_prod int,
  FOREIGN KEY (id_categoria_prod) REFERENCES categoria (id_categoria_prod));

CREATE TABLE tipo_usuario (
  id_tipo_usuario int primary key,
  nombre_tipo varchar(10));

CREATE TABLE usuario (
  id_usuario int primary key,
  nombre_usuario varchar(15),
  email_usuario varchar(20),
  contrasenia_usuario varchar(8),
  id_tipo_usuario int,
  tiene_tarjeta boolean,
  direccion_usuario varchar(45),
  premio_registro varchar(20),
  FOREIGN KEY (id_tipo_usuario) REFERENCES tipo_usuario (id_tipo_usuario));
