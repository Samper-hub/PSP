#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int fd[2];
    pid_t pid;
    char mensaje[] = "Buenos días hijo.";
    char buffer[100];

    if (pipe(fd) == -1) {
        perror("Error al crear el pipe");
        exit(EXIT_FAILURE);
    }

    pid = fork();

    if (pid == -1) {
        perror("Error en el fork");
        exit(EXIT_FAILURE);
    }

    if (pid > 0) {
        close(fd[0]);
        printf("El PADRE envía algo al pipe.\n");

        write(fd[1], mensaje, strlen(mensaje) + 1);
        close(fd[1]);
        wait(NULL);
    } else {

        close(fd[1]);

        read(fd[0], buffer, sizeof(buffer));
        printf("El HIJO recibe algo del pipe: %s\n", buffer);

        close(fd[0]);
        exit(EXIT_SUCCESS);
    }

    return 0;
}
