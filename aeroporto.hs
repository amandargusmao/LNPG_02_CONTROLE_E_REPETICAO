import Control.Monad (forM_)

checarPassageiro :: IO ()
checarPassageiro = do
  putStrLn "RG (Digite 'RG' ou 'Nao possui'): "
  rg <- getLine
  if rg == "Nao possui"
    then putStrLn "A saída é nessa direção."
    else do
      putStrLn "Data de nascimento no RG (DD/MM/AAAA): "
      dataRG <- getLine
      
      putStrLn "Passagem (Digite 'Passagem' ou 'Nao possui'): "
      passagem <- getLine
      if passagem == "Nao possui"
        then putStrLn "A recepção é nessa direção."
        else do
          putStrLn "Data de nascimento na Passagem (DD/MM/AAAA): "
          dataPassagem <- getLine
          
          if dataRG /= dataPassagem
            then putStrLn "190"
            else do
              putStrLn "Assento (Formato A12): "
              assento <- getLine
              putStrLn $ "O seu assento é " ++ assento ++ ". Tenha um ótimo dia."

main :: IO ()
main = do
  putStrLn "Informe a quantidade de passageiros: "
  n <- readLn :: IO Int
  forM_ [1..n] $ const checarPassageiro 
