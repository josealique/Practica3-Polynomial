public class Polynomial {
    private float[] coeficientes;
    private String string;

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
        String[] componentes = s.split(" ");

        this.string = s;
        this.coeficientes = new float[]{0};
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
        StringBuilder s = new StringBuilder();
        if (coeficientes[0] == 0) return "" + Math.round(coeficientes[0]);
        if (coeficientes[0] == 1) return "x + " + Math.round(coeficientes[1]);
        for (int i = 0; i < coeficientes.length; i++) {
            int number = Math.round(coeficientes[i]);
            if (number == 0) continue;
            if (number > 0) s.append(number);
            if (number < 0) s.append(number + "-");
        }
        return s.toString();
    }

}