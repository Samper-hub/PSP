// fifoCarne.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

int main()
{
    int fp;
    char señal[] = "C\n";

    fp = open("FIFO2", 1);

    if(fp == -1) {
        printf("ERROR AL ABRIR EL FICHERO...\n");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");
    write(fp, señal, strlen(señal));

    close(fp);
    return 0;
}
