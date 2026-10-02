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
    char buffer[10];
    int turno_carniceria = 1;
    int turno_pescaderia = 1;


    p = mkfifo("FIFO2", S_IFIFO|0666);

    while(1) {
        fp = open("FIFO2", 0);
        bytesleidos = read(fp, buffer, 1);

        while (bytesleidos != 0){
            if (buffer[0] == 'C') {
                printf("OBTENIENDO Información...Carnicería:\nTurno: %d\n\n", turno_carniceria);
                turno_carniceria++;
            } else if (buffer[0] == 'P') {
                printf("OBTENIENDO Información...Pescadería:\nTurno: %d\n\n", turno_pescaderia);
                turno_pescaderia++;
            }

            bytesleidos = read(fp, buffer, 1);
        }
        close(fp);
    }
    return(0);
}
