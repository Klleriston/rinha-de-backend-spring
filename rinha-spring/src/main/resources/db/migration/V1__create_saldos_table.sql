CREATE TABLE saldo
(
    id           SERIAL PRIMARY KEY,
    total        INTEGER,
    data_extrato TIMESTAMP
);

CREATE TABLE transacaorinha.public
(
    id           SERIAL PRIMARY KEY,
    valor        INTEGER,
    tipo         CHAR(1),
    descricao    VARCHAR(255),
    realizado_em TIMESTAMP,
    saldo_id     INTEGER,
    FOREIGN KEY (saldo_id) REFERENCES saldo (id)
);

