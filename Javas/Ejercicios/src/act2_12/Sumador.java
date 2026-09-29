package act2_12;

public class Sumador {
    public static void main(String[] args){
        int num1,num2;
        Sumador s=new Sumador();
        num1=Integer.parseInt(args[0]);
        num2=Integer.parseInt(args[1]);
        int resultado=s.sumar(num1,num2);
        System.out.println(resultado);
    }


    public int sumar(int n1, int n2){
        int resultado=0;
        for (int i=n1;i<=n2;i++){
            resultado=resultado+i;
        }
        return resultado;
    }
}
