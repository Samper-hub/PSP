//creaFifo.c
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>      // para open
#include <unistd.h>     // para read, close
#include <sys/types.h>  // para mkfifo
#include <sys/stat.h>   // para mkfifo

int main(void)
{
    int fp;
    int p, bytesleidos;
    char saludo[] = "Un saludo!!!\n",
         buffer[10];
    
    //permiso de lectura y escritura
    p=mkfifo("FIFO", S_IFIFO|0666);
    
    if (p==-1) {
        printf("HA OCURRIDO UN ERROR...\n");
        exit(0);
    }
    
    while(1) {
        fp = open("FIFO", 0);
        bytesleidos= read(fp, buffer, 1);
        printf("OBTENIENDO Información...");
        while (bytesleidos!=0){
            //leo un caracter
            printf("%1c", buffer[0]);
            //leo otro byte
            bytesleidos= read(fp, buffer, 1);
        }
    close(fp);
    }
    return(0);
}
