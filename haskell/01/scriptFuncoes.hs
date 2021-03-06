module SecondScript where

dobro :: Integer -> Integer
dobro x = x * 2

quadruplo :: Integer -> Integer
quadruplo x = dobro (dobro x)

poli2 :: Double -> Double -> Double -> Double -> Double
poli2 a b c x = a * x^2 + b * x + c

parImpar :: Integer -> String
parImpar n
    | ehPar n = "par"
    | otherwise = "impar"
    where
    ehPar :: Integer -> Bool
    ehPar x = x `mod` 2 == 0

maxThree :: Integer -> Integer -> Integer -> Integer
maxThree m n p
 | m >= n && m >= p = m
 | n >= p           = n
 | otherwise        = p

maxFour :: Integer -> Integer -> Integer -> Integer -> Integer
maxFour m n p q
    | (maxThree m n p) <= q = q
    | otherwise = maxThree m n p

maxFour' :: Integer -> Integer -> Integer -> Integer -> Integer
maxFour' m n p q = max (maxThree m n p) q

maxFour'' :: Integer -> Integer -> Integer -> Integer -> Integer
maxFour'' m n p q =   max (max(max m n) p) q

quantosIguais :: Integer -> Integer -> Integer -> Integer
quantosIguais a b c
    | a == b && b == c = 3
    | b == a = 2
    | c == a = 2
    | b == c = 2
    | otherwise = 0

ehZero :: Integer -> Bool
ehZero 0 = True
ehZero x = False

sumTo :: Integer -> Integer
sumTo n
    | n == 1 = 1
    | n > 1 = sumTo(n-1) + n

potencia :: Integer -> Integer -> Integer
potencia n k
    | k == 0 = 1
    | k > 0 = potencia n (k-1) * n

binomial :: Integer -> Integer -> Integer
binomial 0 k = 0
binomial n 0 = 1
binomial n k = binomial (n-1) k + binomial (n-1) (k-1)

tribonacci :: Integer -> Integer
tribonacci 0 = 0
tribonacci 1 = 1
tribonacci 2 = 1
tribonacci n = tribonacci' 1 1 2 (n-2)

tribonacci' :: Integer -> Integer -> Integer -> Integer -> Integer
tribonacci' a b c 1 = c
tribonacci' a b c d = tribonacci' b c (a+b+c) (d-1)

addEspacos :: Integer -> String
addEspacos 0 = ""
addEspacos n = " " ++ addEspacos (n-1)

paraDireita :: Integer -> String -> String
paraDireita n x = addEspacos(n-1) ++ x

vendas 0 = 1 
vendas 1 = 1
vendas 2 = 2  
vendas 3 = 5  
vendas 4 = 6 

cabecalho :: String
cabecalho = "Semana" ++ (paraDireita 3 ("Venda")) ++ "\n"

imprimeSemanas :: Integer -> Integer -> String
imprimeSemanas d n
    | d == n = paraDireita 3 (show(d) ++ addEspacos 3 ++ show(vendas d) ++ "\n")
    | d < n =  paraDireita 3 (show(d) ++ addEspacos 3 ++ show(vendas d) ++ "\n") ++ imprimeSemanas (d+1) n

totalVendas :: Integer -> Integer
totalVendas n 
    | n == 0 = vendas 0
    | n > 0 = totalVendas (n-1) + vendas n

imprimeTotal :: Integer -> String
imprimeTotal n = paraDireita 3 ("Total" ++ addEspacos 3 ++ show(totalVendas n) ++ "\n")

imprimeMedia :: Integer -> String
imprimeMedia n = paraDireita 3("Média" ++ addEspacos 3 ++ show( fromIntegral(totalVendas n) / fromIntegral(n+1)) ++ "\n" )
    

imprimeTabela :: Integer -> String
imprimeTabela n = cabecalho
            ++ imprimeSemanas 0 n
            ++ imprimeTotal n
            ++ imprimeMedia n

impressao :: Integer -> IO()
impressao n = putStr (imprimeTabela n)



