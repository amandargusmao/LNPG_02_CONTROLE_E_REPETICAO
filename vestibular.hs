import Data.List
import Data.Ord (comparing)
import Text.Printf

type Participante = (String, Int)

lerGabarito :: IO [Int]
lerGabarito = do
    putStrLn "Digite o gabarito da prova, consistindo em 10 inteiros (1-5) separados por espaço:"
    map read . words <$> getLine

lerParticipantes :: [Int] -> IO [Participante]
lerParticipantes gabarito = go []
  where
    go acc = do
      putStrLn "Digite o nome do participante seguido por suas 10 respostas (1-5), separadas por espaço, ou '*' para terminar:"
      line <- getLine
      if line == "*"
      then return $ reverse acc
      else do
        let (nome:respostas) = words line
            nota = length $ filter id $ zipWith (==) gabarito (map read respostas)
        go ((nome, nota) : acc)

main :: IO ()
main = do
    gabarito <- lerGabarito
    participantes <- lerParticipantes gabarito
    let ordenados = sortOn fst participantes
    
    putStrLn "\nLista de participantes e suas respectivas notas em ordem alfabética:"
    mapM_ (uncurry $ printf "%s %d\n") ordenados
    
    let (maxNome, maxNota) = maximumBy (comparing snd) ordenados
    let (minNome, minNota) = minimumBy (comparing snd) ordenados
    let acimaDaMetade = length $ filter ((>5) . snd) ordenados
    let total = length ordenados
    let percentualAcima = (fromIntegral acimaDaMetade / fromIntegral total) * (100 :: Double)

    putStrLn "\nMaior pontuação:"
    printf "%s com %d pontos\n" maxNome maxNota
    putStrLn "\nMenor pontuação:"
    printf "%s com %d pontos\n" minNome minNota
    printf "\nPercentual com mais da metade das questões certas: %.1f%%\n" percentualAcima
