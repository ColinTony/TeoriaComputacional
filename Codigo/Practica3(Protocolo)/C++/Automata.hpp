
class Automata {
public:

	explicit Automata();
	~Automata();
	// dibujar el diseño
	void pintarTodo();
	void dibujarEstado(std::string,float,float,bool);
	void dibujarLinea(float, float, float, float,std::string,bool);
	void dibujarLineaArribaAbajo(float, float, float, float,std::string,bool);
	void dibujarEstados();
	void dibujarPuntosignificado(float,float,miniwin::COLOR,std::string);
	void dibujarEstadoActual(std::string,float,float);
	void repintar();
	// generar valores
	char genValor() const;
	// escribir la cadenas en archivos 
	void escribeCadena(std::string);
	void escribeCadenaCorrecta(std::string);
	void escribeCadenaIncorrecta(std::string);
	void escribeEstado(std::string);
	// generar las 100,000 cadenas de 32 bits
	void generarCadenas();
	void leerArchivoMandarAutomata();
	// automata
	void inicializaVariabres();
	void automata(std::string);
	int transicion(int,char,int);
private:
	// cienmil cadenas de 32 bits
	const int MAX = 3;
	const int BITS_NUM = 33;
	char cadenaCeros[33];
	std::string cadena;
	int numCadena;
	// variables del automata
	int funcionT[4][2];
	char binario[2]; // esta seria sigma
	int qA;	 // resultado q0 q1 , q2 , q3 solo el indice
	int q0; // estado incial
	std::string palAuxiliar; // palabra auxiliar para imprimir
	std::string cadenas; // almacenar las cadeas que leeramos en el archivo
};