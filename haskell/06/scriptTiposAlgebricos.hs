module SeventhModule where

    divSeg :: Integer -> Integer -> Maybe Integer
    divSeg x y = if y == 0 then Nothing else Just $ x `div` y

    divSeg' :: Integer -> Integer -> Either String Integer
    divSeg' x y = if y == 0 then Left $ show(x) ++ "/0" else Right $ x `div` y

    mapMaybe :: (a -> Maybe b) -> [a] -> [b]
    mapMaybe f x = map (\y -> case y of Just y -> y) (filter mapMaybeHelp (map f x))

    mapMaybeHelp :: Maybe b -> Bool
    mapMaybeHelp x = case x of
                        Just x -> True
                        Nothing -> False

    classifica :: [Either a b] -> ([a],[b])
    classifica x = ((map decompositeLeft (mapA x)) , (map decompositeRight (mapB x)))
        where 
        mapA x = [ y | y <- x, checkLeft y]
        mapB x = [y | y <- x, checkRight y]
        decompositeLeft y = case y of 
                                Left y -> y
        decompositeRight y = case y of 
                                Right y -> y
        checkLeft y = case y of 
                        Left y -> True
                        Right y -> False
        checkRight y = case y of 
                Left y -> False
                Right y -> True

    data Tree a = Leaf | Node a ( Tree a ) ( Tree a )
        deriving (Show , Eq)

    valAtRoot :: Tree a -> Maybe a
    valAtRoot Leaf = Nothing
    valAtRoot (Node n t1 t2) = Just n

    qntNodes :: Tree a -> Integer
    qntNodes Leaf = 0
    qntNodes (Node n t1 t2) = 1 + (qntNodes t1) + (qntNodes t2)

    leftTest :: Tree a -> Maybe a
    leftTest Leaf = Nothing
    leftTest (Node n t1 t2) = if checkLeaf t1 then Just n else leftTest t1
        where
        checkLeaf t1 = case t1 of
                            Leaf -> True
                            otherwise -> False

    mapTree :: (a -> a) -> Tree a -> Tree a
    mapTree _ Leaf = Leaf
    mapTree f (Node n t1 t2) = (Node (f n) (mapTree f t1) (mapTree f t2))

    insertL :: a -> Tree a -> Tree a
    insertL x Leaf = (Node x Leaf Leaf)
    insertL x (Node n t1 t2) = (Node n (insertL x t1) t2)

    medida :: Tree a -> Tree Integer
    medida Leaf = Leaf
    medida (Node n t1 t2) = (Node (1+ (calculeLength t1) + calculeLength(t2)) (medida t1) (medida t2))
        where
            calculeLength Leaf = 0
            calculeLength (Node n t1 t2) = 1 + calculeLength(t1) + calculeLength(t2)

    foldTree :: (a -> b -> b -> b) -> b -> Tree a -> b 
    foldTree f b Leaf = b
    foldTree f b (Node n t1 t2) = f n (foldTree f b t1) (foldTree f b t2)

    sumt :: Int -> Int -> Int -> Int
    sumt x y z = x+y+z

    treeSum :: Tree Int -> Int
    treeSum Leaf = 0
    treeSum x = foldTree sumt 0 x


    