# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from PIL import Image
import PIL, sys


class setup():
    ## le o codigo de rastreamento 
    file = open("codigo.txt", "r")
    codigo = file.readline()
    file.close()
    ## acessa o site que armazena o print do rastreamento
    driver = webdriver.Chrome()
    driver.get("https://www2.correios.com.br/sistemas/rastreamento/default.cfm")
    texto = driver.find_element_by_name("objetos")
    texto.send_keys(codigo)
    texto.send_keys(Keys.RETURN)
    driver.save_screenshot("screenshot.png")
    driver.close()
    ## trata o print apenas para vermos a parte necessaria
    im = Image.open('screenshot.png')
    im = im.crop(((265, 150, 700, 500)))
    im.show()
    im.save('screenshot.png', 'PNG')
    im.close()

if __name__ == "__main__":
    setup()


