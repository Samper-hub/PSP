#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int variable = 10;
    pid_t pid;

    printf("Valor inicial de la variable: %d\n", variable);

    pid = fork();

    if (pid < 0) {
        printf("Error al crear el proceso.\n");
        return 1;
    } else if (pid == 0) {
        variable -= 5;
        printf("Variable en Proceso Hijo: %d\n", variable);
    } else {
        wait(NULL);
        variable += 5;
        printf("Variable en Proceso Padre: %d\n", variable);
    }

    return 0;
}
