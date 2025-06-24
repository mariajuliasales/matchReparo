CREATE TABLE service_provider (
    id BIGINT PRIMARY KEY,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    CONSTRAINT fk_service_provider_user FOREIGN KEY (id) REFERENCES users(id)
);