/*
	Clase Comb
	Author : Colin Heredia Luis Antonio
*/
#include <iostream>
#include <cmath>	// funcniones matematicas Pow
#include <cstdlib> 	// donde se encuentra la funcion RAND y SRAND
#include <ctime>	// time para la funcion de uso de tiempo
#include <fstream> 	// para los archivos
#include <iomanip> // parametros de manupulacions
#include <bits/stdc++.h> // funcion reverse. 
#include "Comb.hpp"
using namespace std;


/**
 *  Destructor
 */
Comb::~Comb(){}
/**
 *  Constructor inicializacion de binarios
 */
Comb::Comb()
{
	binario[0] = '0';
	binario[1] = '1';
}
/**
 * [Comb::newComb description]
 * Vuelve inicializar las variables el valor de k lo establece a nuestra k
 * de nuestra clase y manda el valor a la funcion calcular K.
 * @param k [description]
 */
void Comb::newComb(int k)
{
	// constructor vacio
	this->k = 0;
	this->x = 0;
	binario[0] = '0';
	binario[1] = '1';
	this->k = k;
	this->x = calcularX(k);
	
}
/**
 * [Comb::calcularX description]
 * Obtiene el valor de X que son el numero de combinaciones obtenidas
 * por ejemplo 2^5 = 32
 * @param  numero [valor del exponente]
 * @return        [regresa el valor de elevar 2 al numero]
 */
int Comb::calcularX(int numero)
{
	return pow(2,numero);
}

/**
 * [Comb::genValor description]
 * Genera un valor aleatorio dentro de un rango
 * @return [regresa el valor random generado]
 */
int Comb::genValor() const{
	// funcion de time , recupera la hora del sistema
	// lo cual hace que la semilla que le demos a srand sea aleatoria
	// dado que en teoria siempre sera una semilla distinta
	srand(time(NULL)); // le damos la semilla a srand
	int random = (rand()%100000)+1;

	return random;
}

/**
 * [Comb::startCombinacion description]
 * Empieza a realizar las combinaciones lo que hice fue convertir los valores
 * de 0 hasta el numero de combinaicones X convertirlos a binario.
 * los escribe dentro del archivo Universo y las combinaciones de las cadenas
 */
void Comb::startCombinacion()
{
	int aux;
	this->cadena.clear();

	for(int i = 0; i<x; i++)
	{
		aux = i;
		for(int j = 0; j<k; j++)
		{
			cadena += binarioResiduo(aux);
			aux /= 2;
			reverse(cadena.begin(),cadena.end());
		}
		escribeUniverso(cadena);
		cadena += ",";
		escribeCombinacion(cadena);
		cout<<cadena;
		this->cadena.clear();
	}
}
/**
 * [Comb::startCombinacion27 description]
 * Algoritmo para la combinaicon de k=27 cambia al momento de 
 * escribir en el archivo.
 */
void Comb::startCombinacion27()
{
	int aux;
	this->cadena.clear();

	for(int i = 0; i<x; i++)
	{
		aux = i;
		for(int j = 0; j<k; j++)
		{
			cadena += binarioResiduo(aux);
			aux /= 2;
			reverse(cadena.begin(),cadena.end());
		}
		escribeUniverso27(cadena);
		cadena += ",";
		escribeCombinacion(cadena);
		cout<<cadena;
		this->cadena.clear();
	}
}

/**
 * [Comb::binarioResiduo description]
 * Funcion para devolver el residuo al dividir entre 2
 * esto funciona para convertir a binario.
 * @param  numero [numero a convertir]
 * @return        [regresa el valor de 0 o 1]
 */
char Comb::binarioResiduo(int numero)
{
	if(!(numero == 0))
		numero%=2;
	if(numero>0)
		return binario[1];
	else
		return binario[0];
}

/**
 * [Comb::escribeCombinacion description]
 * Escribe la cadena en un archivo de texto Combinaciones.txt
 * @param cadCom [cadena a escribir]
 */
void Comb::escribeCombinacion(string cadCom)
{
	// primer archivo de texto llamado Combinaciones.txt dentro de txt
	ofstream txtComb;
	txtComb.open("./txt/Combinaciones.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<cadCom;
	txtComb.close();
}
/**
 * [Comb::escribeUniverso description]
 * Funcion va concatenando la cadena en el archivo Universo. en este no se agregan ','
 * todo se va concatenando directamente.
 * @param cadCom [description]
 */
void Comb::escribeUniverso(string cadCom)
{
	// algoritmo para guardar las combinacione del universo
	// primer archivo de texto llamado Combinaciones.txt dentro de txt
	ofstream txtComb;
	txtComb.open("./txt/Universo.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<cadCom;
	txtComb.close();
}
/**
 * [Comb::escribeUniverso27 description]
 * Esta funcion es la misma que escribeUniverso
 * Solo que aqui se escribe en Universo27.txt
 * @param cadCom [cadena a escribir]
 */
void Comb::escribeUniverso27(string cadCom)
{
	// algoritmo para guardar las combinacione del universo
	// primer archivo de texto llamado Combinaciones.txt dentro de txt
	ofstream txtComb;
	txtComb.open("./txt/Universo27.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<cadCom;
	txtComb.close();
}
/**
 * [Comb::segmentarVeinte description]
 * escribe el valor de unos en el archivo de segmentar veinte
 * que son los numeros contados, esto se escribe en un archivo llamado segmentosVeinte.txt
 * @param numero [numeor a escrbir]
 */
void Comb::segmentarVeinte(int numero)
{
	ofstream txtComb;
	txtComb.open("./txt/segmentosVeinte.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<numero<<endl;
	txtComb.close();
}
/**
 * [Comb::segnmentarSesenta description]
 * Escribe los numeros de unos contados en segmentos de sesenta
 * esto en un archivo llamdo segmentoSesenta.txt
 * @param numero [numero a escrbier]
 */
void Comb::segnmentarSesenta(int numero)
{
	ofstream txtComb;
	txtComb.open("./txt/segmentoSesenta.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<numero<<endl;
	txtComb.close();
}
/**
 * [Comb::segmentarCien description]
 * Escribe el numeor de unos contados en segmentos de cien en cien
 * esto en un archivo llamado segmentoCien.txt
 * @param numero [Valor contado]
 */
void Comb::segmentarCien(int numero)
{
	ofstream txtComb;
	txtComb.open("./txt/segmetoCien.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<numero<<endl;
	txtComb.close();
}
/**
 * [Comb::segmentarOtro description]
 * Se puede segmenetar en diferentes valores la cadena universo
 * esta funcion es si no esta dentro de los parametros dados en la rpactica
 * si queremos segmentar la cadena en otros valores podemos hacerlo
 * esto escribira el valor dentro de un archivo otroSegmento.txt
 * @param numero [valor a escribir]
 */
void Comb::segmentarOtro(int numero)
{
	ofstream txtComb;
	txtComb.open("./txt/otroSegmento.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txtComb<<numero<<endl;
	txtComb.close();
}
/**
 * [Comb::leerUnos description]
 * La funcion lee un archivo dado por su path y lo manda a contar sus unos
 * con un segmento determinado
 * @param segmentos   [leer en segmentos]
 * @param pathArchivo [direccion del archivo a leer]
 */
void Comb::leerUnos(int segmentos,string pathArchivo)
{
	string numeros;
	int unos = 0;
	int contador = 0;
	ifstream archivo(pathArchivo);
	if(archivo.fail())
		cerr<<"Error al abrir el archivo"<<endl;
	else{
		getline(archivo,numeros);
		contarUnos(numeros,segmentos);
	}
}
/**
 * [Comb::contarUnos description]
 * Cuenta los unos dentro de una cadena dada.
 * y el numero de segmentos dados
 * @param cadena    [cadena a leer]
 * @param segmentos [segmentos de unos a contar]
 */
void Comb::contarUnos(string cadena,int segmentos)
{
	int unos=0;
	for(int i = 0; i<cadena.size(); i++)
	{
		if(cadena[i] == binario[1])
			unos++;
		cout<<"i="<<i<<" Valor cadena: "<<cadena[i]<<" Valor de unos: "<<unos<<endl;
		if(((i+1)%segmentos) == 0)
		{
			agregarUnos(unos,segmentos);
			unos = 0; // reiniciamos el contador.
		}
	}
	if(unos != 0)
		agregarUnos(unos,segmentos);
}
/**
 * [Comb::agregarUnos description]
 * determina en donde escribir el numero de unos contados
 * Ya sea de 20,60,100 u otro. en su respectivo archivo
 * @param unos      [Unos que ha contado]
 * @param segmentos [segmentos en los que va contando]
 */
void Comb::agregarUnos(int unos,int segmentos)
{
	switch(segmentos)
	{
		case 20:
			segmentarVeinte(unos);
		break; 
		case 60:
			segnmentarSesenta(unos);
		break;
		case 100:
			segmentarCien(unos);
		break;
		default:
			segmentarOtro(unos);
		break;
	}
}