#enconding: utf-8
import numpy as np #paquetes de computacion cientifica
import matplotlib.pyplot as plt

ejeX = []

f = open ('UnosBinarios.txt','r')

cadAux = f.readlines()
for i in cadAux:
	ejeX.append(i) 

ejeY = ejeX*1
plt.title("Unos de numeros primos binarios")
plt.plot(ejeX,".")
plt.show()