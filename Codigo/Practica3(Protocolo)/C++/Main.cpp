/**
 * 
 * Author: Colin Heredia Luis Antonio
 * Version : 1.0
 * Descripcion: Protocolo prorama que cree 100,000 cadenas de 31 bits y revise con un automata
 * 	Si pertenece la cadena.
 * 	
 */

#include <iostream>
#include <cstdlib> 	// donde se encuentra la funcion RAND y SRAND
#include <ctime>	// time para la funcion de uso de tiempo
#include "miniwin.h"
#include "Automata.hpp"

using namespace std;

int main(void)
{
	/* code */
	srand(time(NULL)); // le damos la semilla a srand
	Automata autoCadenas;

	return 0;
}