#enconding: utf-8
import numpy as np #paquetes de computacion cientifica
import matplotlib.pyplot as plt

f = open ('UnosBinarios.txt','r')

x = np.array(range(1))*1
y = []

while True:
    cadAux = f.read(16)
    if cadAux == '':
        break
    y.append(cadAux.count("1"))

plt.plot(x,y)

plt.show()