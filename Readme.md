
#exemplo de requisicao POST com body Vendedor

POST /vendedores
{
    "nome":"Miguel Miranda",
    "cpfOuCnpj":"122.436.784-01",
    "email":"miguel.miranda2023@example.com.br",
    "tipoContratacao":"CLT",
    "dataNascimento":"1985-05-15",
    "filialId":"1"
}

GET /vendedores
{
        "id": 2,
        "matricula": "12345378-CLT",
        "nome": "Sidney Miranda",
        "dataNascimento": "1985-05-15",
        "cpfOuCnpj": "123.436.784-01",
        "email": "sidney.miranda@example.com.br",
        "filialId": 2,
        "filial": {
            "id": 2,
            "nome": "Filial 2",
            "cnpj": "12345678901234",
            "cidade": "São Paulo",
            "uf": "SP",
            "tipo": "Matriz",
            "ativo": true,
            "dataCadastro": "2024-08-18",
            "ultimaAtualizacao": "2024-08-18"
        }
    },