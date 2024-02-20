INSERT INTO saldo (total, data_extrato) VALUES (1, 1000, '2024-02-20 10:00:00');
INSERT INTO saldo (total, data_extrato) VALUES (2, 2000, '2024-02-21 11:00:00');

INSERT INTO transacao (valor, tipo, descricao, realizada_em, saldo_id) VALUES (100, 'd', 'Debido', '2024-02-20 10:05:00', 1);
INSERT INTO transacao (valor, tipo, descricao, realizada_em, saldo_id) VALUES (50, 'c', 'Credito', '2024-02-20 10:10:00', 1);
INSERT INTO transacao (valor, tipo, descricao, realizada_em, saldo_id) VALUES (200, 'd', 'Debido', '2024-02-21 11:05:00', 2);
INSERT INTO transacao (valor, tipo, descricao, realizada_em, saldo_id) VALUES (-50, 'd', 'Conta', '2024-02-21 11:05:00', 2)

