
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
  int fd[2];
  char buffer[30];
  pid_t pid;

  pipe(fd);
  pid=fork();
  switch(pid) {
    case -1:
      printf("NO SE HA PODIDO CREAR HIJO...");
      exit(-1);
      break;
    case 0: //HIJO
      printf("El HIJO escribe en el pipe...\n");
      write(fd[1], "Hola papi", 10);
      break;
    default: //PADRE
      wait (NULL);
      printf("El PADRE lee del pipe...\n");
      read(fd[0], buffer, 10);
      printf("\tMensaje leido: %s\n",buffer);
      break;
  }
}
