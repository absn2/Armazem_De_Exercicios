import string
import re

def count_words(text):
    counts = dict()
    text = text.lower()
    result = ""
    for char in text:
        if char in string.punctuation:
            if char == "-":
                result += char
        else:
            result += char
    result = re.split("[^a-z0-9-—]", result)
    for word in result:
        if word in counts:
            counts[word] += 1
        else:
            counts[word] = 1
    return counts

def test_run():
    with open("input.txt", "r") as f:
        text = f.read()
        counts = count_words(text)
        sorted_counts = sorted(counts, key=counts.get, reverse=True)
        print ("10 MOST COMMOM WORDS(COUNTS ON THE RIGHT SIDE):")
        for word in sorted_counts[:10]:
            print(word+",",counts[word])
        print ("10 LEAST COMMOM WORDS(COUNTS ON THE RIGHT SIDE):")
        for word in sorted_counts[-10:]:
            print(word+",", counts[word])

test_run()