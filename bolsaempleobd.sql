CREATE DATABASE BOLSAEMPLEO;

USE BOLSAEMPLEO;



-- en dao
CREATE TABLE HABILIDADES(

   idHabilidad int AUTO_INCREMENT ,
   nombreHabilidad varchar(50) ,
   areaTrabajo varchar(50),
   especializacion varchar (50),
   
   CONSTRAINT PK_Caracteriticas PRIMARY KEY ( idHabilidad , nombreHabilidad)
 
  


);

-- en dao
CREATE TABLE OFERENTE

( cedulaOferente varchar (15),
  nombreOferente varchar(50),
  primerApellido varchar(50),
  segundoApellido varchar(50),
  celular varchar(12),
  nacionalidad varchar (50),
  correoOferente varchar(50),
  ubicacion varchar(60),
  clave varchar(55),
 
  CONSTRAINT PK_OFERENTE PRIMARY KEY (cedulaOferente)
  );
  
  -- 
  
  
  CREATE TABLE ADMINISTRADOR (
  
  nombreAdmin varchar (30),
  claveAdministrador varchar (15),
  
   CONSTRAINT PK_ADMIN PRIMARY KEY (nombreAdmin)
  
  );
  


  
  -- en dao
CREATE TABLE SERVICIOS

(
   idServicio int AUTO_INCREMENT,
   nombreServicio varchar(50),
salarioEsperado float,
 descripcionDescripcion varchar(50) , 

CONSTRAINT PK_SERVICIO PRIMARY KEY(idServicio)

);


-- en dao
CREATE TABLE SERVICIOS_PUBLICADOS 
(
   

    cedulaOferente varchar (15),
     idServicio int,
    estadoServicio boolean,
   
    CONSTRAINT PK_SP PRIMARY KEY (idServicio , cedulaOferente),
    CONSTRAINT FK_SP1 FOREIGN KEY (cedulaOferente) REFERENCES OFERENTE (cedulaOferente),
    CONSTRAINT FK_SP2 FOREIGN KEY (idServicio) REFERENCES SERVICIOS (idServicio)
   

);


-- en dao
CREATE TABLE HABILIDADES_INCLUIDAS

 (
   
   
   idServicio int,
   idHabilidad int,
   fecha_Inclusion date,

   CONSTRAINT PK_PI PRIMARY KEY (idHabilidad, idServicio ),
   CONSTRAINT FK_HI1 FOREIGN KEY (idServicio ) REFERENCES 
   SERVICIOS (idServicio),
   CONSTRAINT FK_HI2 FOREIGN KEY (idHabilidad ) REFERENCES 
   HABILIDADES (idHabilidad)
   

);

-- en dao
CREATE TABLE EMPRESA

 (nombreEmp varchar(50) unique,
telefonoEmp varchar(15) ,
latitud varchar (60),
longitud varchar (60),
descripcionEmp varchar(150), 
correoEmp varchar(50) unique, 
idEmp  int AUTO_INCREMENT,
fechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
clave varchar(55),

CONSTRAINT PK_EMP PRIMARY KEY (idEmp)

);


-- en dao

CREATE TABLE PUESTOS(
nombrePuesto varchar(50),
salario float,
 descripcionPuesto varchar(50), 

estado boolean,

idPuesto int AUTO_INCREMENT,

CONSTRAINT PK_PUESTO PRIMARY KEY(idPuesto , nombrePuesto, descripcionPuesto)
);







-- en dao
CREATE TABLE CARACTERISTICAS (

   nombreCaracteristica varchar(55) unique,
   idCaracteriticas int AUTO_INCREMENT,
 
   CONSTRAINT PK_Caracteriticas PRIMARY KEY (idCaracteriticas)
 
);

CREATE TABLE CARACTERISTICAS_INCLUIDAS (
   
   
   idPuesto int,
   idCaracteriticas int,


   CONSTRAINT PK_PI PRIMARY KEY (idPuesto, idCaracteriticas),
   CONSTRAINT FK_PI1 FOREIGN KEY (idPuesto) REFERENCES 
   PUESTOS (idPuesto),
   CONSTRAINT FK_PI2 FOREIGN KEY (idCaracteriticas) REFERENCES 
   CARACTERISTICAS (idCaracteriticas)
   

);

-- en dao
CREATE TABLE AREA_TRABAJO (

   nombreCaracteristica varchar(55),
   nombreAreaTrabajo varchar (50) unique,
   idareatrabajo int AUTO_INCREMENT,
   
   constraint pk_at primary key (idareatrabajo, nombreCaracteristica),
   constraint fk_at foreign key (nombreCaracteristica) references caracteristicas (nombreCaracteristica)
);




CREATE TABLE AREATRABAJO_INCLUIDAS (
   
   
   idPuesto int,
   idareatrabajo int,



   CONSTRAINT PK_AT PRIMARY KEY (idPuesto, idareatrabajo),
   CONSTRAINT FK_AT1 FOREIGN KEY (idPuesto) REFERENCES 
   PUESTOS (idPuesto),
   CONSTRAINT FK_AT2 FOREIGN KEY (idareatrabajo) REFERENCES 
   AREA_TRABAJO (idareatrabajo)
   

);



CREATE TABLE ESPECIALIZACION (

   nombreAreaTrabajo varchar (50),
   nombreEspecializacion varchar (50) unique,
   porcentajeEspecializacion int,
   idespecializacion int AUTO_INCREMENT,
   
   constraint pk_at primary key (idespecializacion, nombreAreaTrabajo),
   constraint fk_es foreign key (nombreAreaTrabajo) references area_trabajo (nombreAreaTrabajo)
);


-- en dao

CREATE TABLE ESPECIALIZACION_INCLUIDAS (
    idPuesto int,
	idespecializacion int,
	porcentajeEspecializacion int,
	idEmp  int,
	
   CONSTRAINT PK_Esp PRIMARY KEY ( idPuesto, idespecializacion, idEmp),
   CONSTRAINT FK_Esp1 FOREIGN KEY (idPuesto) REFERENCES 
   PUESTOS (idPuesto),
   CONSTRAINT FK_Esp2 FOREIGN KEY (idespecializacion) REFERENCES 
   ESPECIALIZACION (idespecializacion),
   CONSTRAINT FK_Esp3 FOREIGN KEY (idEmp) REFERENCES 
   EMPRESA (idEmp)
	);

	CREATE TABLE ESPECIALIZACION_INCLUIDASOFERENTE(
	
	  cedulaOferente varchar (15),
	  idespecializacion int,
	  porcentajeEspecializacion int,
	  
	  CONSTRAINT PK_EIO PRIMARY KEY (cedulaOferente, idespecializacion),
	  CONSTRAINT FK_EIO FOREIGN KEY (cedulaOferente) REFERENCES OFERENTE (cedulaOferente),
	  CONSTRAINT FK_EIO1 FOREIGN KEY (idespecializacion) REFERENCES ESPECIALIZACION (idespecializacion)
	 
	);

	

-- en dao

CREATE TABLE PUESTOS_PUBLICADOS 
(
   

    idEmp int,
    idPuesto int,
    estadoPuesto boolean,
   
    CONSTRAINT PK_PP PRIMARY KEY (idPuesto , idEmp),
    CONSTRAINT FK_PP1 FOREIGN KEY (idEmp) REFERENCES EMPRESA (idEmp),
    CONSTRAINT FK_PP2 FOREIGN KEY (idPuesto) REFERENCES PUESTOS (idPuesto)
  


);


CREATE TABLE APLICADO (

  fechaAplicacion date,
  cedulaOferente varchar (15),
  idPuesto int,
  

  CONSTRAINT PK_AP PRIMARY KEY (cedulaOferente, idPuesto),
  CONSTRAINT FK_AP1 FOREIGN KEY (cedulaOferente) REFERENCES OFERENTE (cedulaOferente),
   CONSTRAINT FK_AP2 FOREIGN KEY (idPuesto) REFERENCES PUESTOS (idPuesto)



);


 insert into administrador (nombreAdmin, claveAdministrador) values ('admin' , 'admin');
