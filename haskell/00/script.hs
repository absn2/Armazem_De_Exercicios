{- #########################################################

        FirstScript.hs
        Simon Thompson, August 2010.

######################################################### -}

module FirstScript where
import Prelude hiding (max,min)
import Data.Char

--      The value size is an integer (Integer), defined to be 
--      the sum of twelve and thirteen.

size :: Integer
size = 12+13

--      The function to square an integer.

square :: Integer -> Integer
square n = n*n

--      The function to double an integer.
        
double :: Integer -> Integer
double n = 2*n

--      An example using double, square and size.
         
example :: Integer
example = double (size - square (2+2))

--      The function to double the square of an integer.
doubleSquare :: Integer -> Integer
doubleSquare x = double (square x)

-- The function to square the double of an integer.

squareDouble :: Integer -> Integer
squareDouble x = square (double x)


threeEqual :: Int -> Int -> Int -> Bool
threeEqual m n p = (m==n) && (n==p) 

--      One of them is not equal
mystery :: Int -> Int -> Int -> Bool
mystery m n p = not ((m==n) && (n==p)) 

threeDifferent :: Int -> Int -> Int -> Bool 
threeDifferent m n p = (m /= n) && (n /= p) && (m /= p)

fourEqual :: Int -> Int -> Int -> Int -> Bool 
fourEqual m n p q = (m==n) && (n==p) && (p==q)

max :: Int -> Int -> Int
max x y
        = if x >= y then x else y 

maxThree :: Int -> Int -> Int -> Int
maxThree x y z
        = if (x >= y && x >= z) then x else if (y >= z) then y else z

min :: Int -> Int -> Int
min x y
        = if x <= y then x else y 

minThree :: Int -> Int -> Int -> Int
minThree x y z
        = if (x <= y && x <= z) then x else if (y <= z) then y else z

charToNum :: Char -> Int
charToNum ch
        = if (('0' <= ch) && (ch <= '9')) then (ord ch - ord '0') else 0 

averageThree :: Integer -> Integer -> Integer -> Float 
averageThree x y z = fromIntegral(x+y+z) / 3

howManyAboveAverage :: Integer -> Integer -> Integer -> Integer 
howManyAboveAverage x y z 
        | (x == y) && (y == z) = 0
        | (fromIntegral x > averageThree x y z) && (fromIntegral y <= averageThree x y z) && (fromIntegral z <= averageThree x y z) = 1
        | (fromIntegral x > averageThree x y z) && (fromIntegral y > averageThree x y z) && (fromIntegral z <= averageThree x y z) = 2
        | (fromIntegral x > averageThree x y z) && (fromIntegral y > averageThree x y z) && (fromIntegral z > averageThree x y z) = 3
        | (fromIntegral x <= averageThree x y z) && (fromIntegral y > averageThree x y z) && (fromIntegral z <= averageThree x y z) = 1
        | (fromIntegral x <= averageThree x y z) && (fromIntegral y > averageThree x y z) && (fromIntegral z > averageThree x y z) = 2
        | (fromIntegral x <= averageThree x y z) && (fromIntegral y <= averageThree x y z) && (fromIntegral z > averageThree x y z) = 1
        | otherwise = 0