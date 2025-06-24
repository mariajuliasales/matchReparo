CREATE TABLE clients (
    id BIGINT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    data_birth DATE NOT NULL,
    CONSTRAINT fk_client_user FOREIGN KEY (id) REFERENCES users(id)
);