CREATE TABLE compra (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_nf INT,
    id_item INT,
    cod_prod INT,
    valor_unit DECIMAL(10, 2),
    quantidade INT,
    desconto DECIMAL(5, 2)
);

INSERT INTO compra (id_nf, id_item, cod_prod, valor_unit, quantidade, desconto) VALUES
(1, 1, 1, 25.00, 10, 5),
(1, 2, 2, 13.50, 3, 0),
(1, 3, 3, 15.00, 2, 0),
(1, 4, 4, 10.00, 1, 0),
(1, 5, 5, 30.00, 1, 0),
(2, 1, 3, 15.00, 4, 0),
(2, 2, 4, 10.00, 5, 0),
(2, 3, 5, 30.00, 7, 0),
(3, 1, 1, 25.00, 5, 0),
(3, 2, 4, 10.00, 4, 0),
(3, 3, 5, 30.00, 5, 0),
(3, 4, 2, 13.50, 7, 0),
(4, 1, 5, 30.00, 10, 15),
(4, 2, 4, 10.00, 12, 5),
(4, 3, 1, 25.00, 13, 5),
(4, 4, 2, 13.50, 15, 5),
(5, 1, 3, 15.00, 3, 0),
(5, 2, 5, 30.00, 6, 0),
(6, 1, 1, 25.00, 22, 15),
(6, 2, 3, 15.00, 25, 20),
(7, 1, 1, 25.00, 10, 3),
(7, 2, 2, 13.50, 10, 4),
(7, 3, 3, 15.00, 10, 1),
(7, 4, 5, 30.00, 10, 1);