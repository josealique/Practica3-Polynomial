import java.util.Arrays;

public class Polynomial {
    private float[] coeficientes;
    private String poly;

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
        this.coeficientes = new float[]{0};
        this.poly = "0";
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        this.coeficientes = cfs;
        this.poly = "0";
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
        this.coeficientes = new float[]{0};
       String[] componentes = s.split(" ");
       String resultado = "";
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i].contains("x")){
                String[] a = componentes[i].split("x");
                resultado += Arrays.toString(a) + "x";
            }
            if (componentes[i].contains("x^")){
                int potencia = Integer.parseInt(componentes[i].split("x\\^")[1]);
                resultado += potencia;
                System.out.println(resultado);
            }
        }
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        float[] p1;
        float[] p2;
        float[] resultado;
        return null;
    }

    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object o) {
        Polynomial polynomial = (Polynomial) o;
        return this == polynomial;
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        if (this.isZero()) return "0";
        StringBuilder coso = new StringBuilder();
        for (int i = 0; i < coeficientes.length; i++) {
            int coeff = Math.round(this.coeficientes[i]);
            if (i == this.coeficientes.length - 1) {
                coso.append(coeff);
                continue;
            }
            int power = getDegree(i);
            if (power == 1) {
                coso.append(coeff == 1 ? "x " : coeff + "x ");
            } else {
                coso.append(coeff == 1 ? "x^" + ++power + " " : coeff + "x^" + ++power + " ");
                i += power - 2;
            }
            if (i + 1 <= this.coeficientes.length - 1) {
                float next = this.coeficientes[i + 1];
                coso.append(next > 0 ? "+ " : "- ");
                this.coeficientes[i + 1] = next < 0 ? next * -1 : next;
            }
        }
        return coso.toString();
    }

    private boolean isZero() {
        boolean empty = true;
        for (float f : this.coeficientes) {
            if (f != 0.0) {
                empty = false;
            }
        }
        if (!this.poly.equals("0")) empty = false;
        return empty;
    }

    private int getDegree(int idx) {
        int counter = 0;
        do {
            counter++;
        } while (this.coeficientes[++idx] == 0);
        return counter;
    }
}

/*
   // Multiplica el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial mult(Polynomial p2) {
        return null;
    }

    // Divideix el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    // Torna el quocient i també el residu (ambdós polinomis)
    public Polynomial[] div(Polynomial p2) {
        return null;
    }

    // Troba les arrels del polinomi, ordenades de menor a major
    public float[] roots() {
        return null;
    }
 */