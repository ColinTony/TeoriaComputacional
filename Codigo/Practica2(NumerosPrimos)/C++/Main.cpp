/*
	Author: Colin Heredia Luis Antonio
	Versio : 1.0
	Descripcion: Encontrar los numeros primos de 0 a n, conviertiendo a binario
	y contando los unos para al final graficarlos.
*/
#include <iostream>
#include "Primos.hpp"

using namespace std;
int main()
{
	int n = 0;
	int operacion=0; // operacion que se va aplicar.
	Primos prim;
	cout << "\n Teclea el numero del metodo a utilziar. " << endl;
	cout << " 1.- Generar numero aleatorio. \n 2-. Introducir un numero manualmente." << endl;
	cout << "\n Opcion : ";
	cin >> operacion;
	
	if(operacion == 1)
	{
		// modo automatico
		n = prim.genValor();
		cout<< "\nValor Generado : "<< n <<endl;
		prim.calcularPrimos(n);
		
	}else
	{
		cout<<"Teclea un valor para n : ";
		cin>>n;
		// modo manual
		if(n >= 2 && n <= 1000000)
		{
			cout<<"\nValor Digitado : " << n <<endl;
			prim.calcularPrimos(n);
		}else
			cout<<"El numero debe ser entero mayor a 1 y menor o igual a 100,000 "<<endl;
	}
	
	return 0;
}