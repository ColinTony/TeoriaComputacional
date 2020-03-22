/*
	Clase Primos
	Author : Colin Heredia Luis Antonio
	Version: 1.0
*/
#include <iostream>
#include <cstdlib> 	// donde se encuentra la funcion RAND y SRAND
#include <ctime>	// time para la funcion de uso de tiempo
#include <fstream> 	// para los archivos
#include <iomanip> // parametros de manupulacions
#include <bits/stdc++.h> // funcion reverse. 
#include "Primos.hpp"

using namespace std;

// construcores y desctructor
Primos::~Primos(){}
Primos::Primos()
{
	// constructor clase primos
	binario[0] = '0';
	binario[1] = '1';
}
/**
 * [Primos::genValor description]
 * Genera un valor distinto en un determinador rango
 * @return [regresa el numero generado]
 */
int Primos::genValor() const{
	srand(time(NULL)); // le damos la semilla a srand
	int random = (rand()%100000)+1; // generamos un numero entre 1 y 10
	return random;
}

/**
 * [Primos::escribeBinariosPrimos description]
 * Escribe en un archivo llamado BinariosPrimos los numeros primos binarios
 * @param binario [cadena que se va escribir en el carhcivo]
 */
void Primos::escribeBinariosPrimos(string binario)
{
	cadenaJunta += " Numero Binario : " + binario;
	ofstream txtPrimos;
	txtPrimos.open("./txt/BinariosPrimos.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtPrimos<<binario<<",";
	txtPrimos.close();
}
/**
 * [Primos::escribeNumerosPrimos description]
 * escribe en un archivo los numeros primos encontrados
 * añade en la cadena para imprimir el numero primo
 * @param primos [numeor primo]
 */
void Primos::escribeNumerosPrimos(int primos)
{
	cadenaJunta += " Decimal: " + to_string(primos);
	ofstream txtPrimos;
	txtPrimos.open("./txt/NumerosPrimos.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtPrimos<<primos<<",";
	txtPrimos.close();
}
/**
 * [Primos::escribeUnosBinarios description]
 * Escribe los unos contados dentro de un binario
 * @param unos [binario]
 */
void Primos::escribeUnosBinarios(int unos)
{
	cadenaJunta += " Numero de unos : " + to_string(unos);
	ofstream txtPrimos;
	txtPrimos.open("./txt/UnosBinarios.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtPrimos<<unos<<endl;
	txtPrimos.close();
}


/**
 * [Primos::leerUnos description]
 * lee un arhcivo con un path y cuenta los unos dentro de ese archivo
 * manda la cadena a contarunos quien se encarga de contarlos
 * @param pathArchivo [description]
 */
void Primos::leerUnos(string pathArchivo)
{
	// abrimos el archivo y contamos los segmentos
	// abirmo el archivo y contamos los unos que hayan
	string numeros;
	int unos = 0;
	int contador = 0;
	ifstream archivo(pathArchivo);
	if(archivo.fail())
		cerr<<"Error al abrir el archivo"<<endl;
	else{
		getline(archivo,numeros);
		contarUnos(numeros);
	}
}
/**
 * [Primos::contarUnos description]
 * Funcion se encarga de contar los unos que existan dentro de la cadena
 * @param cadena [cadena a leer]
 */
void Primos::contarUnos(string cadena)
{
	int unos=0;
	for(int i = 0; i<cadena.size(); i++)
		if(cadena[i] == binario[1])
			unos++;
	if(unos != 0)
		escribeUnosBinarios(unos);
}
/**
 * [Primos::calcularPrimos description]
 * Calcula los numeros primos dentro de un rango dado por el usuario
 * pasa por el isPrimo quien determina si es primo
 * Si es primo lo escribe en numerosPrimos y en bianrio
 * @param n [Numeor hasta n a calcular]
 */
void Primos::calcularPrimos(int n)
{
	for(int i = 2; i<= n; i++)
	{
		if(isPrimo(i))
		{
			escribeNumerosPrimos(i);
			escribeBinariosPrimos(conversorBinario(i));
			imprimeValores();
		}
	}
}
/**
 * [Primos::imprimeValores description]
 * Solo imprime en pantalla los valores escritos en diferentes archivos
 */
void Primos::imprimeValores()
{
	cout<<cadenaJunta<<endl;
	cadenaJunta.clear();
}
/**
 * [Primos::isPrimo description]
 * Determina si el valor dado es un numero primo
 * @param  numero [numero a evaluar]
 * @return        [true or false si es primo o no]
 */
bool Primos::isPrimo(int numero)
{
	bool isPrimo = true;
	int contador = 2;

	while((contador<numero) && (isPrimo))
	{
		if((numero%contador)!= 0)
			contador++;
		else
			isPrimo = false;
	}
	return isPrimo;
}
/**
 * [Primos::conversorBinario description]
 * convierte un valor decimal dado que seria primo a un valor
 * binario equivalente. Llama la funcion contar unos para que cuente
 * cuantos unos tiene el numero primo en binario
 * @param  decimal [decimal a convertir]
 * @return         [cadena en binario del numero primo]
 */
string Primos::conversorBinario(int decimal)
{
	cadena = "";
	while(decimal > 0)
	{
		cadena += binarioResiduo(decimal);
		decimal /= 2;
	}
	// revertimos la cadena
	reverse(cadena.begin(),cadena.end());
	contarUnos(cadena);
	return cadena;
}
/**
 * [Primos::binarioResiduo description]
 * Devuelve el residuo para la conversion de binario
 * @param  numero [numero a convertir]
 * @return        [valor 0 o 1 del residuo]
 */
char Primos::binarioResiduo(int numero)
{
	if(!(numero == 0))
		numero%=2;
	if(numero>0)
		return binario[1];
	else
		return binario[0];
}
