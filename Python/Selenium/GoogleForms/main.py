# -*- coding: utf-8 -*-
from pip._vendor.distlib.compat import raw_input
from selenium import webdriver

class setup():
    
    print("Qual pessoa você gostaria de eliminar?\n1: Mairan\n2: Carlos\n3: Thiago")
    caso = int(raw_input("Escolha um número: ")) - 1

    i = 1
    driver = webdriver.Chrome()
    driver.get("https://docs.google.com/forms/d/e/1FAIpQLSc185wQEsajwZHlP7wH4-PT_SAPwBV6DYZb_ZZjSQwSxTyTyg/viewform")

    while True:
        driver.find_elements_by_class_name("freebirdMaterialImageoptionImage")[caso].click()
        driver.find_element_by_xpath("//*[text()[contains(.,'Próxima')]]").click()
        driver.implicitly_wait(10)
        driver.find_element_by_xpath("/html/body/div/div[2]/form/div/div/div[2]/div[2]/div/div[2]/div/span/div/div[1]/label/div/div[1]/div/div[3]/div").click()
        driver.find_element_by_xpath("//*[text()[contains(.,'Próxima')]]").click()
        driver.find_elements_by_xpath("//*[text()[contains(.,'Enviar')]]")[1].click()
        driver.find_element_by_xpath("//*[text()[contains(.,'Enviar outra resposta')]]").click()
        print("Voto %d contabilizado"%(i))
        i += 1
    driver.close()


if __name__ == "__main__":
    setup()






