#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

using namespace std;

int main()
{
	// declaraci�n de variables.
	int NumeroA;
	int NumeroB;
	int Suma;
	
	//Solicitud de n�meros enteros.
	cout<<"Introduzca el primer entero:\n"; cin>>NumeroA;
	cout<<"Introduzca el segundo entero:\n"; cin>>NumeroB;

	//Suma de los dos d�gitos
	Suma=NumeroA+NumeroB;
	cout<<"El resultado de la suma es:"<<Suma<<endl;
	system("pause");
	return 0;
}
