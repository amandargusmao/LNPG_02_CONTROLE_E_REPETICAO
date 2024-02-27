import Text.Printf (printf)

calcularPagamento :: Int -> (Double, Double, Double)
calcularPagamento jogosVendidos = (totalVendas, valorBonus, salario)
  where
    precoJogo = 19.90
    totalVendas = fromIntegral jogosVendidos * precoJogo
    bonusVendas = jogosVendidos `div` 15
    valorBonus = totalVendas * 0.08 * fromIntegral bonusVendas
    salario = totalVendas * 0.5 + valorBonus

main :: IO ()
main = do
    putStrLn "Total de jogos vendidos no mês:"
    jogosVendidos  <- readLn :: IO Int
    let (totalVendas, valorBonus, salario) = calcularPagamento jogosVendidos
    printf "Total de Vendas: R$ %.2f\n" totalVendas
    printf "Valor do Bônus: R$ %.2f\n" valorBonus
    printf "Salário Total: R$ %.2f\n" salario
