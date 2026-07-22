CREATE DATABASE TCDpoo;
USE TCDpoo;
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL
);



CREATE TABLE livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    quantidade INT NOT NULL DEFAULT 0,
    categoria_id INT NOT NULL,

    CONSTRAINT fk_livro_categoria
        FOREIGN KEY (categoria_id)
        REFERENCES categoria(id),

    CONSTRAINT chk_livro_quantidade
        CHECK (quantidade >= 0)
);


CREATE TABLE usuario (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    data_nasc DATE,
    endereco VARCHAR(255)
);


CREATE TABLE emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    data_inicio DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_fim DATETIME NULL,
    cpf VARCHAR(11) NOT NULL,

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (cpf)
        REFERENCES usuario(cpf)
);

CREATE TABLE itens_emprestados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_emprestimo INT NOT NULL,
    id_livro INT NOT NULL,

    CONSTRAINT fk_item_emprestimo
        FOREIGN KEY (id_emprestimo)
        REFERENCES emprestimo(id),

    CONSTRAINT fk_item_livro
        FOREIGN KEY (id_livro)
        REFERENCES livro(id)
);