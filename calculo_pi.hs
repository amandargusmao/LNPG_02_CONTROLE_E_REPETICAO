import Text.Printf (printf)

calcularPi :: Int -> Double
calcularPi n = (**(1/3)) $ 32 * sum [((-1)**fromIntegral i) / (fromIntegral (2*i + 1) ** 3) | i <- [0..n-1]]

main :: IO ()
main = do
    putStrLn "Digite o número de termos da série: "
    n <- readLn
    let pi = calcularPi n
    putStrLn $ "Valor aproximado de pi: " ++ printf "%.5f" pi
