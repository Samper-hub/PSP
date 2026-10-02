// fifoPesca.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>   // para open
#include <unistd.h>  // para read, close

int main()
{
    int fp;
    char señal[] = "P\n"; 
    
    fp = open("FIFO2", 1); // O_WRONLY (1)
    
    if(fp == -1) {
        printf("ERROR AL ABRIR EL FICHERO...\n");
        exit(1);
    }
    
    printf("Mandando información al FIFO...\n");
    write(fp, señal, strlen(señal));
    
    close(fp);
    return 0;
}
