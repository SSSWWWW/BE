

CREATE DATABASE BOLSAEMPLEO;

USE BOLSAEMPLEO;



--en dao
CREATE TABLE HABILIDADES(

   idHabilidad int AUTO_INCREMENT ,
   nombreHabilidad varchar(10) ,
   areaTrabajo varchar(20),
   especializacion varchar (10),
   
   CONSTRAINT PK_Caracteriticas PRIMARY KEY ( idHabilidad , nombreHabilidad)
 
  


);

-- en dao
CREATE TABLE OFERENTE

( cedulaOferente varchar (15),
  nombreOferente varchar(10),
  primerApellido varchar(10),
  segundoApellido varchar(10),
  celular varchar(12),
  nacionalidad varchar (10),
  correoOferente varchar(30),
  ubicacion varchar(60),
  clave varchar(15),
 
  CONSTRAINT PK_OFERENTE PRIMARY KEY (cedulaOferente)
  );
  
  -- 
  
  
  CREATE TABLE ADMINISTRADOR (
  
  nombreAdmin varchar (30),
  claveAdministrador varchar (15),
  
   CONSTRAINT PK_ADMIN PRIMARY KEY (nombreAdmin)
  
  );
  
  nombreAdmin varchar (30);
  claveAdministrador varchar (15);
  
   CONSTRAINT PK_ADMIN PRIMARY KEY (nombreAdmin)
  
  );

  
  --en dao
CREATE TABLE SERVICIOS

(
   idServicio int AUTO_INCREMENT,
   nombreServicio varchar(10),
salarioEsperado float,
 descripcionDescripcion varchar(10) , 

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


--en dao
CREATE TABLE HABILIDADES_INCLUIDAS

 (
   
   
   idServicio int,
   idHabilidad int,
   fecha_Inclusion date,

   CONSTRAINT PK_PI PRIMARY KEY (idHabilidad, idServicio ),
   CONSTRAINT FK_HI1 FOREIGN KEY (idServicio ) REFERENCES 
   SERVICIOS (idServicio),
   CONSTRAINT FK_HI2 FOREIGN KEY (idHabilidad ) REFERENCES 
   HABILIDADES (idHabilidad),
   

);

-- en dao
CREATE TABLE EMPRESA

 (nombreEmp varchar(20),
telefonoEmp varchar(15),
latitud varchar (60),
longitud varchar (60),
descripcionEmp varchar(150), 
correoEmp varchar(20), 
idEmp  int AUTO_INCREMENT,
fechaRegistro DATETIME DEFAULT CURRENT_TIMESTAMP,
clave varchar(15),

CONSTRAINT PK_EMP PRIMARY KEY (idEmp)

);


-- en dao

CREATE TABLE PUESTOS(
nombrePuesto varchar(10),
salario float,
 descripcionPuesto varchar(10) , 
boolean estado;

idPuesto int AUTO_INCREMENT,

CONSTRAINT PK_PUESTO PRIMARY KEY(idPuesto)
);


--en dao
CREATE TABLE CARACTERISTICAS (

   nombreCaracteristica varchar(15),
 
   CONSTRAINT PK_Caracteriticas PRIMARY KEY (nombreCaracteristica);
 
);

CREATE TABLE AREA_TRABAJO (

   nombreCaracteristica varchar(15),
   nombreAreaTrabajo varchar (20),
   
   constraint pk_at primary key (nombreAreaTrabajo, nombreCaracteristica),
   constraint fk_at foreign key (nombreCaracteristica) references caracteristicas (nombreCaracteristica)
)

CREATE TABLE ESPECIALIZACION (

   nombreAreaTrabajo varchar (20),
   nombreEspecializacion varchar (20),
   porcentajeEspecializacion int,
   
   constraint pk_at primary key (nombreEspecializacion, nombreAreaTrabajo),
   constraint fk_es foreign key (nombreAreaTrabajo) references area_trabajo (nombreAreaTrabajo)
)


--en dao


CREATE TABLE CARACTERISTICAS_INCLUIDOS (
   
   
   idPuesto int,
   nombreCaracteristica varchar(15),

   fecha_Inclusion date,

   CONSTRAINT PK_PI PRIMARY KEY (idPuesto, nombreCaracteristica),
   CONSTRAINT FK_PI1 FOREIGN KEY (idPuesto) REFERENCES 
   PUESTOS (idPuesto),
   CONSTRAINT FK_PI2 FOREIGN KEY (nombreCaracteristica) REFERENCES 
   CARACTERISTICAS (nombreCaracteristica)
   

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



)




