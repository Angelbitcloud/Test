CREATE TABLE Personas (
  identificacion INT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  genero VARCHAR(20) NOT NULL,
  edad INT NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  direccion VARCHAR(50) NOT NULL
 );

CREATE TABLE Cliente (
clienteId INT PRIMARY KEY,
clave VARCHAR(50) NOT NULL, 
estado VARCHAR(10) NOT NULL ,
FOREIGN KEY (clienteId) REFERENCES Personas(identificacion)
);

CREATE TABLE Cuenta ( 
numeroCuenta VARCHAR(50) PRIMARY KEY, 
tipo VARCHAR(50) NOT NULL, 
saldo DECIMAL(10,2) NOT NULL, 
estado VARCHAR(10) NOT NULL, 
clienteId INT NOT NULL, 
FOREIGN KEY (clienteId) 
REFERENCES Cliente(clienteId) );

CREATE TABLE Movimiento (
  idMovimiento INT PRIMARY KEY,
  numeroCuenta VARCHAR(50) NOT NULL,
  tipoMovimiento VARCHAR(20) NOT NULL,
  saldo DECIMAL(10,2) NOT NULL,
  fecha DATE NOT NULL,
  FOREIGN KEY (numeroCuenta) REFERENCES Cuenta (numeroCuenta)
);

CREATE VIEW reportes AS
SELECT
  P.identificacion,
  P.nombre AS nombrePersona,
  M.fecha,
  C.numeroCuenta,
  C.tipo AS tipoCuenta,
  C.saldo,
  M.saldo AS saldoMovimiento,
  C.estado
FROM
  Personas P
  INNER JOIN Cliente CL ON P.identificacion = CL.clienteId
  INNER JOIN Cuenta C ON CL.clienteId = C.clienteId
  INNER JOIN Movimiento M ON C.numeroCuenta = M.numeroCuenta;


-- Inserts para la tabla Personas
INSERT INTO Personas (identificacion, nombre, genero, edad, telefono, direccion)
VALUES (123456, 'Juan', 'Masculino', 30, '111111111', 'Calle Principal 123');

INSERT INTO Personas (identificacion, nombre, genero, edad, telefono, direccion)
VALUES (245689, 'María', 'Femenino', 25, '222222222', 'Avenida Secundaria 456');

INSERT INTO Personas (identificacion, nombre, genero, edad, telefono, direccion)
VALUES (369875, 'Pedro', 'Masculino', 35, '555555555', 'Avenida Principal 789');

-- Inserts para la tabla Cliente
INSERT INTO Cliente (clienteId, clave, estado)
VALUES (123456, 'wasd', 'true');

INSERT INTO Cliente (clienteId, clave, estado)
VALUES (245689, 'dsaw', 'true');

INSERT INTO Cliente (clienteId, clave, estado)
VALUES (369875, 'wsda', 'false');

-- Inserts para la tabla Cuenta
INSERT INTO Cuenta (numeroCuenta, tipo, saldo, estado, clienteId)
VALUES ('C001', 'Corriente', 5000.00, 'Activa', 123456);

INSERT INTO Cuenta (numeroCuenta, tipo, saldo, estado, clienteId)
VALUES ('C002', 'Ahorros', 10000.00, 'Activa', 245689);

INSERT INTO Cuenta (numeroCuenta, tipo, saldo, estado, clienteId)
VALUES ('C003', 'Ahorros', 8000.00, 'Activa', 369875);

-- Inserts para la tabla Movimiento
INSERT INTO Movimiento (idMovimiento, numeroCuenta, tipoMovimiento, saldo, fecha)
VALUES (1, 'C001', 'Depósito', 1000.00, '2023-05-19');

INSERT INTO Movimiento (idMovimiento, numeroCuenta, tipoMovimiento, saldo, fecha)
VALUES (2, 'C002', 'Retiro', -500.00, '2023-05-20');

INSERT INTO Movimiento (idMovimiento, numeroCuenta, tipoMovimiento, saldo, fecha)
VALUES (3, 'C003', 'Transferencia', -500.00, '2023-05-21');



