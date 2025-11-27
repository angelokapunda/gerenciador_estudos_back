CREATE TABLE estudos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    assunto VARCHAR(100) NOT NULL,
    prioridade VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_de_criacao DATETIME,
    data_de_finalizacao DATETIME
);