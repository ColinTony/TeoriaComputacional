/**
 *  Author : Colin Heredia Luis Antonio
 *  Version : 1.0
 *  Clase de Comb contiende las funciones y variables a usar en esta practica
 */
class Comb{
public:
	// cosntructor
	explicit Comb();
	~Comb();
	void newComb(int);
	int calcularX(int); // funcion para devolver el numero de combinaciones.
	int genValor() const;

	// Funcoines para las combinaciones
	void startCombinacion();
	void startCombinacion27();
	char binarioResiduo(int);

	// lectura y escritura de archivos
	void escribeUniverso(std::string);
	void escribeCombinacion(std::string);
	void escribeUniverso27(std::string);
	void segmentarVeinte(int);
	void segnmentarSesenta(int);
	void segmentarCien(int);
	void segmentarOtro(int);
	
	void leerUnos(int,std::string);
	void agregarUnos(int,int);
	void contarUnos(std::string,int);
	// fin de funciones para la combinacion

private:
	char binario[2];	// valores posibles
	std::string cadena; // arreglo para la cadena
	std::string auxCadena; // para la modificacion de la cadena
	int k;	// valor de k dada o generada
	int x;	// valor d ecombinaciones
};