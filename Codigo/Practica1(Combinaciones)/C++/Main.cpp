/*
 Author : Colin Heredia Luis Antonio
 
 Version 1.0
 Descripcion: Mostrar las posibles combinaciones del conjunto binario dado 
 			  los parametros por el usuario o de manera automatica

 */

#include <iostream>
#include "Comb.hpp"	// Clase Comb.h

using namespace std;
int main()
{
	int k = 0;
	int operacion=0; // operacion que se va aplicar.
	Comb comb;
	
	cout << "\n Teclea el numero del metodo a utilziar. Alfabeto : {1,0} " << endl;
	cout << " 1.- Generar numero aleatorio. \n 2-. Introducir un numero manualmente." << endl;
	cout << "\n Opcion : ";
	cin >> operacion;
	
	if(operacion == 1)
	{
		// caso en el que se debe generar aleatoriamente el numero
		k = comb.genValor();
		cout<<"Valor Genreado : " << k << endl;
		cout<<"\n\nE={"<<"e,";
		for(int i = 2; i<=k; i++)
		{
			comb.newComb(i);
			comb.startCombinacion27();
		}
		cout<<"}"<<endl;
		//comb.leerUnos(100,"./txt/Universo27.txt");
	}else
	{
		cout<<"\n Teclea el valor de k para calcular el universo : ";
		cin >> k;
		// el numero sera ingresado manualmente.
		cout<<"Valor Digitado : " << k << endl;
		if(!(k <= 0 || k >= 28))
		{
			
			cout<<"\n\nE={"<<"e,";
			for(int i = 2; i<=k; i++)
			{
				comb.newComb(i);
				comb.startCombinacion27();
			}
			cout<<"}"<<endl;

			//comb.leerUnos(5,"./txt/Universo.txt");
		}else
			cout<<"El numero debe ser entero entre 1 a 27"<<endl;
	}
	return 0;
}