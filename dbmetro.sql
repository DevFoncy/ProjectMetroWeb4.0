 
SHOW TABLES;

CREATE TABLE `productos` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `precio` double DEFAULT '0',
  `imagen` varchar(200) DEFAULT 'images/OXO---Homepage_39.jpg',
  `cantidad` int(11) DEFAULT '0',
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

INSERT INTO `productos` VALUES (1,'Aceite','Aceite Primor 1L',8.2,'productosImagenes/aceite.jpg',4,'2014-12-27 18:41:47'),
			       (2,'Pisco','Pisco Cuatro Gallos 750ml',34.99,'productosImagenes/pisco.jpg',12,'2014-12-27 18:41:47'),
			       (3,'Shampoo','Shampoo Pantene 750ml',17.99,'productosImagenes/pantene.jpg',5,'2014-12-27 18:41:47'),
             (4,'Vino','Vino santiago queirolo 750 Ml',13.00,'productosImagenes/vino.jpg',87,'2014-12-27 18:41:47'),
			       (5,'Papel Higenico','Papel higenico suave 4 rollos',4.50,'productosImagenes/suave.jpg',4,'2014-12-27 18:41:47'),
			       (6,'Ropa de perro',NULL,21,'productosImagenes/ropaperro.jpg',2,'2014-12-27 18:41:47'),
			       (7,'Nuggets de Pollo',NULL,18,'productosImagenes/nuggets.jpg',5,'2014-12-27 18:41:47');



 CREATE TABLE `clientes` (
  `login` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `clientes` VALUES ('patron','123','jorge','chavez','1988-10-12 00:00:00'),													
			      ('test','E','Z','sakZhana2','1988-10-12 00:00:00');
									
CREATE TABLE `orden` (
  `idorden` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) DEFAULT NULL,
  `fechaOrden` datetime DEFAULT CURRENT_TIMESTAMP,
  `precioTotal` double DEFAULT NULL,
  `estado` int(11) DEFAULT '0',
  PRIMARY KEY (`idorden`),
  KEY `Login_idx` (`login`),
  CONSTRAINT `Login` FOREIGN KEY (`login`) REFERENCES `clientes` (`login`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8;


INSERT INTO `orden` VALUES (1002,'patron','2015-01-01 20:21:47',93,1),
			   (1003,'patron','2015-01-01 20:24:40',7,2),
			   (1004,'patron','2015-01-01 20:35:44',93,1),
			   (1005,'patron','2015-01-01 22:15:26',77,1),
			   (1006,'patron','2015-01-01 22:34:04',5.32,0);    
				
CREATE TABLE `detalle_orden` (
  `idord` int(11) NOT NULL,
  `idprod` int(11) NOT NULL,
  `nbr` int(11) DEFAULT NULL,
  PRIMARY KEY (`idord`,`idprod`),
  KEY `idArt_idx` (`idprod`),
  CONSTRAINT `idProd` FOREIGN KEY (`idprod`) REFERENCES `productos` (`idproducto`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `idCmd` FOREIGN KEY (`idord`) REFERENCES `orden` (`idorden`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
INSERT INTO `DETALLE_ORDEN` VALUES (1002,1,1),
				   (1002,5,2),
				   (1003,3,1),
				   (1004,1,1),
				   (1004,5,2),
			     (1005,3,2),
			     (1005,6,3),
				   (1006,2,1);


SHOW TABLES;