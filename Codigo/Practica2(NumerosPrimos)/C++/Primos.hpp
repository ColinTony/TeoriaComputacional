/*
	 Clase ppara calculo de primos y escritura de archivos de texto
*/
class Primos{
public:
	explicit Primos();
	~Primos();
	bool isPrimo(int);
	int genValor() const;
	void start();
	void escribeBinariosPrimos(std::string);
	void leerUnos(std::string);
	void contarUnos(std::string);
	void escribeUnosBinarios(int);
	void escribeNumerosPrimos(int);
	void calcularPrimos(int);
	char binarioResiduo(int);
	void imprimeValores();
	std::string conversorBinario(int);
private:
	char binario[2];
	std::string cadena;
	std::string cadenaJunta;
};