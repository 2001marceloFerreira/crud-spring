CREATE TABLE tb_categoria(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
categoria VARCHAR(20)
);

CREATE TABLE tb_produto (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    patrimonio VARCHAR(20),
    codigo VARCHAR(20),
    valor DOUBLE,
    categoria_id BIGINT,
    estado varchar(10)
);