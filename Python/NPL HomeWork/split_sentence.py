import string
import re

def word_tokenize(sent):
    sent = sent.lower()
    final = ""
    for i in sent:
        if i not in string.punctuation:
            final += i
        else:
            if i == "-":
                final += i
    final = final.split()
    return final

def sent_tokenize(text):
    result = []
    index = 1
    count = 0
    sentence = ""
    for char in text:
        if char in string.punctuation:
            if char == "." or char == "?" or char == "!" or char == ";":
                result.append(sentence)
                index += 1
                count = 0
            else:
                sentence += char
                count += 1
        else:
            if index != 1 and count == 0:
                sentence = ""
            else:
                sentence += char
            count += 1
    return result

def test_run():
    with open("input2.txt", "r") as f:
        text = f.read()
        print("--- Sample text --- \n"+text)
        result = sent_tokenize(text)
        print("--- Sentences ---\n", result)
        print("--- Words ---")
        count = 0
        for sentence in result:
            print("Sentence:", count+1,"/",sentence)
            word = word_tokenize(sentence)
            print(word,"\n")
            count += 1

test_run()
