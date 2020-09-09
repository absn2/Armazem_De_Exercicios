module ThirdScript where

menorMaior :: Integer -> Integer -> Integer -> (Integer,Integer)
menorMaior a b c 
    | (a >= b) && (b >= c) = (a,b)
    | (a >= b) && (a >= c) = (a,c)
    | (b >= a) && (a >= c) = (b,a)
    | (b >= a) && (b >= c) = (b,c)
    | (c >=a) && (a >= b) = (c,a)
    | (c >=a) && (c >= b) = (c,b)

sort :: Integer -> Integer -> Integer -> (Integer,Integer, Integer)
sort a b c 
    | (a >= b) && (b >= c) = (c,b,a)
    | (a >= b) && (a >= c) = (b,c,a)
    | (b >= a) && (a >= c) = (c,a,b)
    | (b >= a) && (b >= c) = (a,c,b)
    | (c >=a) && (a >= b) = (b,a,c)
    | (c >=a) && (c >= b) = (a,b,c)

ordernaTripla :: Integer -> Integer -> Integer -> (Integer,Integer,Integer)
ordernaTripla a b c = sort a b c

type  Ponto = ( Float ,  Float )
type  Reta  = ( Ponto ,  Ponto )

firstCoo :: Ponto -> Float
firstCoo (x,y) = x

secondCoo :: Ponto -> Float
secondCoo (x,y) = y

isVertical :: Reta -> Bool
isVertical (pair1,pair2)
    | firstCoo(pair1) == firstCoo(pair2) = True
    | otherwise = False

inReta :: Float -> Reta -> Float
inReta x ((x1,y1),(x2,y2)) = (((x-x1) * (y2-y1)) / (x2-x1)) + y1