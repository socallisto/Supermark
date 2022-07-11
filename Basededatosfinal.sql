
CREATE DATABASE supermark1;
USE supermark1 ;

CREATE TABLE  usuario (
  idUsuario INT NOT NULL AUTO_INCREMENT,
  Nombre_Usuario VARCHAR(20) NULL DEFAULT NULL,
  Email_Usuario VARCHAR(30) NULL DEFAULT NULL,
  Password_Usuario VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (idUsuario));

CREATE TABLE administrador (
  idAdmin INT NOT NULL AUTO_INCREMENT,
  Usuario_idUsuario INT NOT NULL,
  PRIMARY KEY (idAdmin),
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES usuario (idUsuario));

CREATE TABLE categoria(
  idCategoria INT NOT NULL AUTO_INCREMENT,
  Nombre_Categoria VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (idCategoria));

CREATE TABLE cliente (
  idCliente INT NOT NULL AUTO_INCREMENT,
  Apellido_Cliente VARCHAR(20) NULL DEFAULT NULL,
  Domicilio_Cliente VARCHAR(50) NULL DEFAULT NULL,
  Tarjeta_Cliente TINYINT NOT NULL,
  Premio_Cliente TINYINT NULL DEFAULT NULL,
  NumCompras_Cliente INT NULL DEFAULT NULL,
  Usuario_idUsuario INT NOT NULL,
  PRIMARY KEY (idCliente),
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES usuario (idUsuario));
    
CREATE TABLE compra (
  idCompra INT NOT NULL AUTO_INCREMENT,
  Total_Compra DOUBLE NOT NULL,
  Cliente_idCliente INT NOT NULL,
  FormaPago_Compra VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (idCompra),
    FOREIGN KEY (Cliente_idCliente)
    REFERENCES cliente (idCliente));

CREATE TABLE producto (
  idProducto INT NOT NULL AUTO_INCREMENT,
  Nombre_Producto VARCHAR(50) NOT NULL,
  Precio_Producto DOUBLE NOT NULL,
  Stock_Producto INT NOT NULL,
  categoria_idCategoria INT NOT NULL,
  PRIMARY KEY (idProducto),
    FOREIGN KEY (categoria_idCategoria)
    REFERENCES categoria(idCategoria));

CREATE TABLE listap (
  idListaP INT NOT NULL AUTO_INCREMENT,
  Compra_idCompra INT NOT NULL,
  Producto_idProducto INT NOT NULL,
  PRIMARY KEY (idListaP),
    FOREIGN KEY (Compra_idCompra)
    REFERENCES compra (idCompra),
    FOREIGN KEY (Producto_idProducto)
    REFERENCES producto (idProducto));

insert into producto (Nombre_Producto,Precio_Producto,Stock_Producto,categoria_idCategoria) values 
('Arroz Integral Gallo 900gr', 80, 2000,5),
('Yogurt Vainilla Cosalta 50gr', 100, 2700,1),
('Azucar Blanca Ledesma 1kg', 250, 800,5),
('Galleta Surtido Diversion 900gr', 150, 1500,5),
('Sprite 2,5L gaseosa',230,300,3),
('Pasta dental Colgate 50gr', 120, 2000,2);

INSERT INTO categoria (Nombre_Categoria) values
('Lacteos'),
('Limpieza'),
('Bebidas'),
('Frutas y Verduras'),
('Alimentos');

1.Lacteos\n 2.Limpieza\n 3.Bebidas\n 4.Frutas y Verduras\n 5.Alimentos\n ;

insert into usuario (Nombre_usuario, email_usuario, password_usuario) values ('sofi', 'sofi@lgmail.co,', '1234');
insert into usuario (Nombre_usuario, email_usuario, password_usuario) values ('jere', 'jere@lgmail.co,', '1234');

insert into cliente (Apellido_Cliente, Domicilio_Cliente, Tarjeta_Cliente, Premio_Cliente, NumCompras_Cliente, Usuario_idUsuario) values ('jere','belgrano',TRUE,TRUE,0,2);
insert into administrador (idAdmin, Usuario_idUsuario) values (null, 1);
