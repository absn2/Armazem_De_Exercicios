module SixthScript where

import Data.List (sort, intercalate, elemIndex)
import Data.Char (toUpper)

mmax :: (a->Int) -> a -> a -> a
mmax f x y 
    | f x >= f y = x
    | otherwise = y

countedSorted :: [String] -> Int
countedSorted x = length (filter (\n -> n == sort n) x)

mStr :: [String] -> String
mStr x =  map toUpper (intercalate " " (filter (\n -> length(n) > 5) x))

powers :: Int -> Int -> [Int]
powers x y = takeWhile (<= y) (map (\n -> x ^ n) [0..y])


add :: Int -> Int -> Int
add x y = x + y

sumsOfAux :: [Int] -> (Int -> Int) -> [Int]
sumsOfAux [] _ = []
sumsOfAux (x:xs) f = f x : sumsOfAux xs (add (f x))

sumsOf :: [Int] -> [Int]
sumsOf x = sumsOfAux x $ add $ 0    

squares :: Int -> [Int]
squares x = take x (filter (\n -> head(show(n)) == last(show(n)))(map (\n -> n*n) [1..maxBound]))

