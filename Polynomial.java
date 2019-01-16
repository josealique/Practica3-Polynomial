public class Polynomial {
    private float[] coeficientes;

    // Constructor per defecte. Genera un polinomi zero
    public Polynomial() {
        this.coeficientes = new float[]{0};
    }

    // Constructor a partir dels coeficients del polinomi en forma d'array
    public Polynomial(float[] cfs) {
        this.coeficientes = new float[cfs.length];
        for (int i = 0; i < coeficientes.length; i++) {
            coeficientes[i] = cfs[i];
        }
    }

    // Constructor a partir d'un string
    public Polynomial(String s) {
    }

    // Suma el polinomi amb un altre. No modifica el polinomi actual (this). Genera un de nou
    public Polynomial add(Polynomial p) {
        return null;
    }

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

    // Torna "true" si els polinomis són iguals. Això és un override d'un mètode de la classe Object
    @Override
    public boolean equals(Object o) {
        Polynomial polynomial = (Polynomial) o;
        return this == polynomial;
    }

    // Torna la representació en forma de String del polinomi. Override d'un mètode de la classe Object
    @Override
    public String toString() {
        if (coeficientes[0] == 0) return "" + Math.round(coeficientes[0]);
        if (coeficientes[0] == 1) return "x + " + Math.round(coeficientes[1]);
        StringBuilder s = new StringBuilder(Math.round(coeficientes[0]) + "x^" + Math.round(coeficientes[1]));
        for (int i = Math.round(coeficientes[0]) - 1; i >= 0; i--) {
            if (coeficientes[i] == 0) continue;
            else if (coeficientes[i] > 0) s.append(" + ").append(coeficientes[i]);
            else if (coeficientes[i] < 0) s.append(" - ").append(-coeficientes[i]);
            if (i == 1) s.append("x");
            else if (i >  1) s.append("x^").append(i);
        }
        return s.toString();
    }

    private String getCoeffs() {
        StringBuilder coso = new StringBuilder();
        for (int i = 0; i < this.coeficientes.length; i++) {
            int coeff = Math.round(this.coeficientes[i]);

            if (i == this.coeficientes.length - 1) {
                coso.append(coeff);
                continue;
            }
            int power = getPower(i);

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

    private int getPower(int idx) {
        int counter = 0;
        do {
            counter++;
        } while (this.coeficientes[++idx] == 0);
        return counter;
    }
}