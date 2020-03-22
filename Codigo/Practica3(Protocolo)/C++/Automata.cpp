
#include <iostream>
#include <cstdlib> 	// donde se encuentra la funcion RAND y SRAND
#include <ctime>	// time para la funcion de uso de tiempo
#include <fstream> 	// para los archivos
#include <cstring>
#include <sstream>
#include <iomanip> // parametros de manupulacions
#include "miniwin.h"
#include "Automata.hpp"

using namespace std;
using namespace miniwin;

/**
 *  Constructor. Se pinta el automata directamente al ser llamado
 */
Automata::Automata() {
	inicializaVariabres();
	pintarTodo();
	// genera las cadenas
	generarCadenas();
	leerArchivoMandarAutomata();
	//automata("1110111111011111101111110111111010,");
}
/**
 * [Automata::inicializaVariabres description]
 * Funcion que inicializa la funcion de transicion,los estados
 * alfabeto para el funcinamiento del automata.
 */
void Automata::inicializaVariabres()
{
	numCadena=1;
	// cadenas
	palAuxiliar = "";
	// estados
	q0 = 0; // estado inicial
	qA = q0; //posicion del estado.

	// sigma
	binario[0]='0';
	binario[1]='1';

	// Tabla de transicion.
	// primer columna
	funcionT[0][0] = 1; // [0][0] => q1
	funcionT[1][0] = 0; // [1][0] => q0
	funcionT[2][0] = 3; // [2][0] => q3
	funcionT[3][0] = 2; // [3][0] => q2
	// segunda columna
	funcionT[0][1] = 2; // [0][1] => q2
	funcionT[1][1] = 3;	// [0][1] => q3
	funcionT[2][1] = 0; // [0][1] => q0
	funcionT[3][1] = 1; // [0][1] => q1
	
	refresca();
}
void Automata::pintarTodo()
{
	vredimensiona(1200,600);
	// DAtos 
	texto(200,0,"ESCOM - Colin Heredia Luis Antonio - Practica 3 Teoria computacional");
	// dibujamos los estados
	dibujarEstados();
	// dibujanod las fechas
	dibujarLinea(120,125,270,125,"0",true);
	dibujarLinea(120,170,270,170,"0",false);
	dibujarLinea(120,275,270,275,"0",true);
	dibujarLinea(120,320,270,320,"0",false);
	refresca();
	espera(1000);

	// flechas hacia arriba y abajo
	dibujarLineaArribaAbajo(80,170,80,275,"1",true);
	dibujarLineaArribaAbajo(110,170,110,275,"1",false);
	dibujarLineaArribaAbajo(280,170,280,275,"1",true);
	dibujarLineaArribaAbajo(310,170,310,275,"1",false);
	refresca();
	espera(1000);
	// sifnificado de colores
	texto(500,100,"SIGNIFICADO DE COLORES");
	texto(750,100,"SECUENCIA DE ESTADOS");
	texto(500,320,"CADENA NUMERO : "+to_string(numCadena));
	dibujarPuntosignificado(500,150,VERDE,": Estado valido");
	dibujarPuntosignificado(500,200,ROJO,": Estado invalido");
	dibujarPuntosignificado(500,250,CYAN,": Posicion actual");
	refresca();
}
/**
 * [Automata::automata description]
 * Esta funcion recorre la palabra caracter por caracter hasta encontrar
 * el , que le dice que ua termino de leer la cadena. La funcion al recorrer
 * Cada caracter lo pasa a la funcion transicion quien me determina el estado
 * al que debo devolverle a qA
 * @param  palabra [La palabra a analizar de 1 y 0 s]
 */
void Automata::automata(std::string palabra)
{
	int is = 0;
	texto(80,350,"CADENA A ANALIZAR");
	texto(80,380,palabra);
	for(int i = 0; i<=palabra.size(); i++)
	{
		if(palabra[i] == ','){
			break;
		}

		is +=13;
		palAuxiliar = palabra[i];
		char c = palabra[i];
		qA = transicion(qA,c,is);
		switch(qA)
		{
			case 0:
				// dibujamos los estados
				espera(500);
				dibujarEstados();
				dibujarEstadoActual("qA",100,150);
				refresca();
			break;
			case 1:
				espera(500);
				dibujarEstados();
				dibujarEstadoActual("qA",300,150);
				refresca();
			break;
			case 2:
				espera(500);
				dibujarEstados();
				dibujarEstadoActual("qA",100,300);
				refresca();
			break;
			case 3:
				espera(500);
				dibujarEstados();
				dibujarEstadoActual("qA",300,300);
				refresca();
			break;
		}
	}

	color(AMARILLO);
	if(qA != 0){
		texto(80,400,"LA CADENA ES VALIDA");
		escribeCadenaCorrecta(palabra);
		numCadena++;
	}
	else{
		texto(80,400,"LA CADENA ES INVALIDA");
		escribeCadenaIncorrecta(palabra);
		numCadena++;
	}
	
	refresca();
	espera(1500);
	repintar();
}
/**
 * [Automata::repintar description]
 * Funcion para borrar el buffer y volver a pintar todo
 */
void Automata::repintar()
{
	borra();
	espera(500);
	refresca();
	pintarTodo();
}
/**
 * [Automata::leerArchivoMandarAutomata description]
 * Leer las cadenas y mandarlas al automata para verificarlos
 * y decidir si son validas o no.
 */
void Automata::leerArchivoMandarAutomata()
{
	int unos = 0;
	int contador = 0;
	//ifstream archivo("./txt/cadenas32BitsPruebas.txt");
	ifstream archivo("./txt/cadenas32Bits.txt");
	if(archivo.fail())
		cerr<<"Error al abrir el archivo"<<endl;
	else{
		while(getline(archivo,cadenas,'\n'))
			automata(cadenas);
	}
}
/**
 * [Automata::dibujarEstados description]
 * Dibyja los circulos en verde y rojo para el recorrido
 * del automata
 */
void Automata::dibujarEstados()
{
	// dibujamos los estados
	dibujarEstado("q0",100,150,false);
	dibujarEstado("q1",300,150,true);
	dibujarEstado("q2",100,300,true);
	dibujarEstado("q3",300,300,true);
}
/**
 * [Automata::transicion description]
 * Esta es la funcion de transicion recibe la letra char
 * Esa letra la convierte a string y luego a un int.
 * el cual se usa como indice junto con qA siendo el estado
 * y el indice lo cual en nuestra tabla de funcion de transicion
 * nos dira que es lo que hay que devolver.
 * @param  qA    [Estado actual]
 * @param  letra [caracter leido]
 * @param  toi   [contador para imprimir correctamente]
 * @return       [regresa el siguiente estado para qA]
 */
int Automata::transicion(int qA,char letra,int toi)
{
	int qR=0;
	int indice =0;
	string aux;
	aux.push_back(letra);
	istringstream iss (aux);
	indice = stoi(aux);
	qR = funcionT[qA][indice];
	color(AMARILLO);
	texto(800,105+toi,aux+"--> q"+to_string(qR));
	escribeEstado("q"+to_string(qR)); // escribe el estado en el archivo
	return qR;
}

/**
 * [Automata::dibujarPuntosignificado description]
 * Dibuja un circulo con una descripcion a un lado para darle signidicado al color
 * @param x      [posicion respectiva]
 * @param y      [posicion respectiva]
 * @param a      [color del circulo especificado dentro del miniwin.h]
 * @param cadena [descripcion del colo]
 */
void Automata::dibujarPuntosignificado(float x,float y,COLOR a,string cadena)
{
	color(a);
	circulo_lleno(x,y,10);
	texto(x+15,y-10,cadena);
}

/**
 * [Automata::dibujarEstado description]
 * Dibujja un circulo con el nombre del estado si es final lo pinta en verde si no en blanco.
 * @param estado  [String con el nombre del estado genralmente qn]
 * @param x       [Posicion en X deonde pintar]
 * @param y       [Posicion en Y donde pintar]
 * @param isFinal [Verifica si es un estado final o no]
 */
void Automata::dibujarEstado(string estado,float x,float y ,bool isFinal)
{
	color(ROJO);
	if(isFinal)
		color(VERDE);
	circulo_lleno(x,y,30);
	color(NEGRO);
	texto((x-10),(y-15),estado);
}
/**
 * [Automata::dibujarEstadoActual description]
 * Dibujja un circulo con el nombre del estado qA
 * @param estado  [String con el nombre del estado genralmente qn]
 * @param x       [Posicion en X deonde pintar]
 * @param y       [Posicion en Y donde pintar]
 */
void Automata::dibujarEstadoActual(string estado,float x,float y)
{
	color(CYAN);
	circulo_lleno(x,y,30);
	color(NEGRO);
	texto((x-10),(y-15),estado);
}

/**
 * [Automata::dibujarLinea description]
 * Dibujar una linea de un luhgar a otro y al final le agrega un > para simular la fecha
 * @param x_ini [Posicion inicial X]
 * @param y_ini [posicion inicial Y]
 * @param x_fin [Posicion final X]
 * @param y_fin [Posicion final Y]
 * @param caracter [caracter a colocar a la mitad de la flecha];
 * @param der_iz un boleano para detectar de que lado apunta la flecha;
 */
void Automata::dibujarLinea(float x_ini, float y_ini, float x_fin, float y_fin,string caracter,bool der_izq)
{
	color(BLANCO);
	linea(x_ini,y_ini,x_fin,y_fin);
	
	if(der_izq)
		texto(x_fin,(y_fin-8),">");
	else
		texto(x_ini,(y_ini-8),"<");

	color(BLANCO);
	texto(((x_ini+x_fin)/2),((y_ini+y_fin)/2),caracter);
}

/**
 * [Automata::dibujarLineaArribaAbajo description]
 * Dibujar una linea de un luhgar a otro y al final le agrega un > para simular la fecha
 * @param x_ini [Posicion inicial X]
 * @param y_ini [posicion inicial Y]
 * @param x_fin [Posicion final X]
 * @param y_fin [Posicion final Y]
 * @param caracter [caracter a colocar a la mitad de la flecha];
 * @param arr_abj un boleano para detectar de que lado apunta la flecha;
 */
void Automata::dibujarLineaArribaAbajo(float x_ini, float y_ini, float x_fin, float y_fin,string caracter,bool arr_abj)
{
	color(BLANCO);
	linea(x_ini,y_ini,x_fin,y_fin);
	
	if(arr_abj)
		texto((x_fin-4),y_fin,"V");
	else
		texto((x_ini-4),y_ini-3,"A");

	color(BLANCO);
	texto(((x_ini+x_fin)/2),((y_ini+y_fin)/2),caracter);
}
/**
 * [Automata::genValor description]
 * Genera un valor aleatorio de 0 y 1
 * @return [devuelve el valor generado]
 */
char Automata::genValor() const{
	
	int random = (rand()%2);

	if(random != 1)
		return binario[0];
	return binario[1];
}
/**
 * [Automata::escribeCadena description]
 * Escribe las cadenas generadas en un archivo dividiendolas por una ,
 * @param cadena [cadena a escribir en el archivo]
 */
void Automata::escribeCadena(string cadena)
{
	ofstream txt;
	txt.open("./txt/cadenas32Bits.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txt<<cadena<<","<<endl;
	txt.close();
}
/**
 * [Automata::escribeEstado description]
 * Escribe en un archivo llamado Estados.txt los estados 
 * donde se va recorriendo la transicion del automata
 * @param q [description]
 */
void Automata::escribeEstado(string q)
{
	ofstream txt;
	txt.open("./txt/Estados.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txt<<q<<",";
	txt.close();
}
/**
 * [Automata::escribeCadenaCorrecta description]
 * Escribira las cadenas validads
 * @param cadena [cadena a escribir]
 */
void Automata::escribeCadenaCorrecta(string cadena)
{
	ofstream txt;
	txt.open("./txt/cadenasValidas.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txt<<cadena<<endl;
	txt.close();
}
/**
 * [Automata::escribeCadenaIncorrecta description]
 * Escribe la cadenas incorrectas
 * @param cadena [cadena a escribir]
 */
void Automata::escribeCadenaIncorrecta(string cadena)
{
	ofstream txt;
	txt.open("./txt/cadenasInvalidas.txt",ios::in|ios::app); // entrada y añadir
	// salto de linea
	txt<<cadena<<endl;
	txt.close();
}
/**
 *  Genera las 100000 cadenas usando la variable constante de la clase
 *  seran 100000 cadenas con 32 bits
 */
void Automata::generarCadenas()
{
	this->cadena = "";
	for(int j=0; j<=MAX; j++){
		for(int i = 0; i<BITS_NUM; i++)
			cadenaCeros[i] = genValor();

		cadenaCeros[32] = '\0';
		cadena = cadenaCeros;
		escribeCadena(cadena);
	}

}
/**
 *  Destructor de la clase Automata
 */
Automata::~Automata() {}