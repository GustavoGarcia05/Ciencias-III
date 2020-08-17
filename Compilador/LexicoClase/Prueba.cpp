#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

using namespace std;

int main()
{
	// declaración de variables.
	int NumeroA;
	int NumeroB;
	int Suma;
	int Resta;
	int opcion;
	//Solicitud de números enteros.
	cout<<"Introduzca el primer entero:\n"; cin>>NumeroA;
	cout<<"Introduzca el segundo entero:\n"; cin>>NumeroB;

	//Suma de los dos dígitos
	Suma=NumeroA+NumeroB;
	Resta=NumeroA-NumeroB;
	
	cout<<"Seleccione una opcion 0 para sumar 1 para restar \n"; cin>>opcion;
	switch(opcion){
		case 0:
			cout<<"El resultado de la suma es:"<<Suma<<endl;
			break;
		case 1:
			cout<<"El resultado de la resta es:"<<Resta<<endl;
			break;
		default:
			cout<<opcion<<" No es una opcion valida"<<endl;
	}
	
	system("pause");
	return 0;
}
