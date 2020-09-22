module FifthScript where

import Data.Char (toUpper, isAlpha)

lengthSum :: [a] -> Integer
lengthSum x = sum(map (\y -> 1) x)

uppers :: String -> String
uppers x = map toUpper x

doubles :: [Int] -> [Int]
doubles x = map (\y -> y*2) x

centavosReais :: [Int] -> [Float]
centavosReais x = map (\y -> fromIntegral(y)/100) x

letras :: String -> String
letras x = filter isAlpha x

diffChar :: Char -> Char -> Bool
diffChar x y = if x == y then False else True

rmChar :: Char -> String -> String
rmChar x y = filter (diffChar x) y

acimaNumber :: Int -> Int -> Bool
acimaNumber x y = if y >= x then True else False

acima :: Int -> [Int] -> [Int]
acima n x = filter (acimaNumber n) x

diffNumber :: (Int,Int) -> Bool
diffNumber n = if fst(n) /= snd(n) then True else False

desiguais :: [(Int,Int)] -> [(Int,Int)]
desiguais x = filter diffNumber x

ex4 :: String -> String
ex4 s = map toUpper (filter isAlpha s)

ex4b :: [Int] -> [Int]
ex4b x = map (*2) (filter (\y -> if y>3 then True else False) x)

even' :: String -> Bool
even' x = if length(x) `mod` 2 == 0 then True else False

ex4c :: [String] -> [String]
ex4c x = map reverse (filter even' x)

productRec :: [Int] -> Int
productRec [] = 1
productRec (x:xs) = x * productRec (xs)

productRec' :: [Int] -> Int
productRec' x = foldr (*) 1 x

andRec :: [Bool] -> Bool
andRec [] = True
andRec (x:xs) = x && andRec (xs)

andRec' :: [Bool] -> Bool
andRec' x = foldr (&&) True x

concatRec :: [String] -> String
concatRec [] = ""
concatRec (x:xs) = x ++ concatRec (xs)

concatRec' :: [String] -> String
concatRec' x = foldr (++) "" x







