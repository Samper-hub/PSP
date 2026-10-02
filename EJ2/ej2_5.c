#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h> // para read, write, close
#include <fcntl.h> // para open y flags (O_RDONLY, O_WRONLY, ...)

int main(void)
{
	char saludo[] = "Un saludo!!!\n";
	char buffer[10];
	int fd, bytesleidos;
	//fichero se abre solo para escritura
	fd=open("texto.txt",1);

	if( fd == -1 )
	{
	    printf("ERROR AL ABRIR EL FICHERO...\n"); 
	    exit(-1);
	}

	printf("Escribo el saludo...\n"); 
        write(fd, saludo, strlen(saludo)); 
	close(fd); //cierro el fichero

	//el fichero se abre solo para lectura 
	fd=open("texto.txt",0);
	printf("Contenido del Fichero: \n");
	// leo bytes de 1 en 1 y lo guardo en buffer 
	bytesleidos = read(fd, buffer, 1);
	while (bytesleidos!=0){
	    printf("%1c", buffer[0]);
	    //leo otro byte
	    bytesleidos= read(fd, buffer, 1);
	}
	close(fd);
	return 0;
}
