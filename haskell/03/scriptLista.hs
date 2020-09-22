module FourthScript where
import Data.Char ( ord, chr )
import Data.List 

isLowerCase :: Char -> Bool
isLowerCase ch = if (ch >= 'a' && ch <= 'z') then True else False

toUpperCase :: Char -> Char
toUpperCase c = chr (ord c - offset)
    where
    offset = abs(ord 'A' - ord 'a')

paraMaior :: String -> String
paraMaior x = [toUpperCase ch | ch <- x, isLowerCase ch]

mmd :: Integer -> [Integer]
mmd x = [n | n <- [1..x], x `mod` n == 0]

divisores :: Integer -> [Integer]
divisores 0 = []
divisores 1 = [1]
divisores x = mmd x

isPrime :: Integer -> Bool
isPrime x = if length(divisores x) == 2 then True else False

menorLista :: [Integer] -> Integer
menorLista [] = undefined
menorLista (x:xs) = if xs == [] then x else min x (menorLista xs)

cabecalho = "n   fib n\n"

sumL :: [Integer] -> Integer
sumL [] = 0
sumL (x:xs) = x + sumL xs

fib :: Integer -> Integer
fib n 
    | n <= 0 = 0
    | n == 1 = 1
    | otherwise = fib (n-2) + fib (n-1)

fibList :: Integer -> [(Integer,Integer)]
fibList n = [ (x,fib x) | x <- [0..(n-2)] ]

fibResultTable :: [(Integer,Integer)] -> String
fibResultTable [] = "\n"
fibResultTable (x:xs) = show(fst(x)) ++ "   " ++ show(snd(x)) ++ "\n" ++ fibResultTable xs

imprimeTabela :: Integer -> String
imprimeTabela n = cabecalho ++ fibResultTable (fibList n)

fibTable :: Integer -> IO()
fibTable n = putStr (imprimeTabela n)

measure :: [a] -> Int
measure [] = -1
measure x = length(x)

takeFinal :: Int -> [a] -> [a]
takeFinal n x = drop (length x - n) x

remove :: Int -> [a] -> [a]
remove n x = take n x ++ drop (n+1) x

fstInt :: [Integer] -> Integer
fstInt [] = 0
fstInt (x:_) = x

fstInt' :: [Integer] -> Integer
fstInt' x = head x

addtion :: [Integer] -> Integer
addtion [] = 0
addtion [x] = x
addtion (x:y:xs) = x+y

addtion' :: [Integer] -> Integer
addtion' x = sum (take 2 x)

produto :: [Integer] -> Integer
produto [] = 1
produto (x:xs) = x * produto xs

unique :: [Integer] -> [Integer]
unique [] = []
unique [x] = [x]
unique x = [ y | y <- x, isUnique (delete y x) y]
    where
    isUnique [] y = True
    isUnique (x:xs) y = if x == y then False else isUnique xs y

isCrescente :: [Integer] -> Bool
isCrescente [] = True
isCrescente (_:[]) = True
isCrescente (x:y:xs) = x <= y && isCrescente (y:xs)






