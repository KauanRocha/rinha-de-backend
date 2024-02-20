DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'transacoes') THEN
        CREATE TABLE transacoes (
            id SERIAL PRIMARY KEY,
            cliente_id INTEGER NOT NULL,
            valor INTEGER NOT NULL,
            tipo BOOLEAN NOT NULL,
            descricao VARCHAR(10),
            realizada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            saldo INTEGER,
            limite INTEGER
        );

        INSERT INTO transacoes (cliente_id, valor, tipo, descricao, saldo, limite)
        SELECT * FROM (VALUES
            (1, 0, true, '1', 0, 100000),
            (2, 0, false, '2', 0, 80000),
            (3, 0, true, '3', 0, 1000000),
            (4, 0, false, '4', 0, 10000000),
            (5, 0, true, '5', 0, 500000)
        ) AS s(cliente_id, valor, tipo, descricao, saldo, limite)
        WHERE NOT EXISTS (SELECT 1 FROM transacoes);
    END IF;
END $$;
