# Verificação e Validação de Software
## Resumo - Testing Techniques
### 1.  Teste baseado em especificações
  Basicamente explica que dá pra implementar testes úteis com estratégias simples: \
    Método do particionamento do espaço de entrada. Ex.: \
            "Um ano é bissexto se: (1) O ano é divisível por 4; (2) O ano não é divisível por 100; \
                                    (3) Exceções são os anos divisíveis por 400 que também são anos bissextos" \
            Ano: 2016	Asserção: Divisível por 4 e não é divisível por 100		res_esperado: bissexto \
            Ano: 2000	Asserção: Divisível por 4, por 100 e por 400			res_esperado: bissexto \
            Ano: 39		Asserção: Não é divisível por 4							res_esperado: não é bissexto \
            Ano: 1900	Asserção: Divisível por 4 e por 100, mas não por 400	res_esperado: não é bissexto \
        Método de partição de categoria; \
### 2. Teste de valor limite
    A. Limites entre classes/partições: \
        Se um limite tem 2 entradas, cada uma exige dois casos de teste \
    B. Terminologia: \
        a. on-point:	valor limite que torna a condição falsa (Ex.1: x < 100; on-point = 100) OU \
                        valor limite que torna a condição verdadeira (Ex.2: x <= 100; on-point = 100)   \
        b. off-point: valor mais próximo que torna a condição verdadeira (Ex.: x < 100; off-point = 99) OU \
                        valor mais próximo que torna a condição falsa (Ex.2: x <= 100; off-point = 101) \
        c. in-points:	universo de valores válidos com a condição EXCLUSA (Ex.: x < 100; in-points contém todos int <= 99) \
                        universo de valores válidos com a condição INCLUSA (Ex.: x <= 100; in-points contém todos int <= 100) \
        d. out-points:universo de valores inválidos com a condição EXCLUSA (Ex.: x < 100; out-points contém todos int >= 100) \
                        universo de valores inválidos com a condição INCLUSA (Ex.: x <= 100; out-points contém todos int >= 101) \
    C. Concluindo: \
        Testadores devem prever casos de teste para o on-point, o off-point, um único in-point e um out-point \
    D. Matriz de condição limite: (Importante pro relatório, olhar slide 2 de Valor Limite, pg. 18) \
        a. Seleciona-se os pontos on e off e cria-se um caso de teste para cada \
        b. Como se quer testar os limites separadamente, selecionam-se in-points para demais variáveis/condições. \
                Na prática	queremos que todas as demais condições permaneçam verdadeiras, ou seja, testar a saída de  \
                uma forma independente \
        c. É importante variar os in-points nos diferentes testes para verificar os resultados p/ vários inpoints \
### 3. Teste Estrutural
        
### 4. Testes a implementar:
    
    testar on/off point de cada variavel, deixando um in-point aleatorio nas demais variaveis \
### 5. Outras coisas a considerar:
    A. Testes parametrizados devem ser usados no lugar de >1 assert no mesmo método pois são capazes de gerar relatórios de teste \
        (Outros recursos na documentação)
    