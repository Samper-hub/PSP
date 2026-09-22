
#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main() {
  pid_t pid, hijo_pid;
  pid = fork();
  if (pid == -1){ //Ha ocurrido un error
    printf("No se ha podido crear el proceso hijo..."); 
    exit(-1);
  }
  if (pid == 0 ){ //Nos encontramos en Proceso hijo
     printf("Soy el proceso hijo \n\tMi PID es %d, el PID de mi padre es: %d.\n",
            getpid(),
            getppid()
     );
  } else {//Nos encontramos en Proceso padre
    hijo_pid = wait(NULL); //espera la finalización del proceso hijo
    printf("Soy el proceso padre:\n");
    printf("\tMi PID es: %d.\n", getpid());
    printf("\tel PID de mi padre es: %d.\n", getppid());
    printf("\tMi hijo con PID: %d terminó.\n", pid);
  }
  exit(0);
}
