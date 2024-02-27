import Text.Printf (printf)
import Data.List (minimumBy, maximumBy)
import Data.Function (on)

leituraDados :: IO [(String, Float)]
leituraDados = leituraDadosAux []
  where
    leituraDadosAux dados = do
      entrada <- getLine
      if entrada == "*"
        then return dados
        else do
          let [dataMes, valorStr] = words entrada
              valor = read (map (\c -> if c == ',' then '.' else c) valorStr) :: Float
          leituraDadosAux ((dataMes, valor):dados)

analiseIPCA :: [(String, Float)] -> IO ()
analiseIPCA dados = do
    let (menorData, menorIPCA) = minimumBy (compare `on` snd) dados
    let (maiorData, maiorIPCA) = maximumBy (compare `on` snd) dados
    let mediaIPCA = sum (map snd dados) / fromIntegral (length dados)
    
    printf "Menor IPCA: %.2f (%s)\n" menorIPCA menorData
    printf "Maior IPCA: %.2f (%s)\n" maiorIPCA maiorData
    printf "Média IPCA: %.2f\n" mediaIPCA

main :: IO ()
main = do
  putStrLn "Insira os dados no formato 'mm/aaaa valor', digite '*' para terminar:"
  dados <- leituraDados
  analiseIPCA dados
