package classes.aula20250122;

public class Prog5Tratamento {
    public static void main(String[] args) {
		int[] num = {4,8,5,16,32, 21, 64, 128, 62, 80, 90};
		int[] den = {2, 0,4,8,0,2, 4};

        DrawLine();
		for (int i=0; i<num.length; i++) {
			try {
				validateInexactDivision(num[i], den[i]); // divisão não exata
                System.out.println(num[i] + " / " + den[i] + " = " + (num[i]/den [i])); // divisão exata
			} catch (ArithmeticException ex) {
				System. out.println ("Erro aritmético: "+ ex.getMessage ()); // divisão por zero
			} catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Erro de índice: " + ex.getMessage()); // índice fora do limite
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage()); // erro genérico
            }
		}
        DrawLine();
	}

    public static void validateInexactDivision(int num, int den) throws DivisaoNaoExata {
        try {
            if (num % 2 != 0) { throw new DivisaoNaoExata(num, den); } // Divisão não exata
        } catch (DivisaoNaoExata ex) {
            System.out.println(ex.toString());
        }
    }

    private static void DrawLine() {
        System.out.println("\n--------------------------------------------------------------------------------\n");
    }
}
