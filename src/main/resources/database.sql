-- Crear tabla BarberTreatment
CREATE TABLE barber_treatment (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
);

-- Insertar tratamientos iniciales
INSERT INTO barber_treatment (name, description, price) VALUES
('Corte de Cabello', 'Corte de cabello profesional para hombres y mujeres.', 15.00),
('Afeitado Clásico', 'Afeitado con navaja y toalla caliente.', 10.00),
('Corte de Barba', 'Diseño y recorte de barba personalizado.', 12.00),
('Tinte de Cabello', 'Tinte de cabello completo o retoques.', 25.00),
('Limpieza Facial', 'Tratamiento facial para limpiar e hidratar la piel.', 20.00),
('Peinado', 'Peinado para eventos o estilo diario.', 18.00),
('Alisado de Cabello', 'Alisado profesional con productos especializados.', 50.00),
('Tratamiento Capilar', 'Hidratación y reparación profunda del cabello.', 30.00);

INSERT INTO user (username, password, role) VALUES
('admin', 'adminpass', 'ADMIN'),
('user', 'userpass', 'USER');