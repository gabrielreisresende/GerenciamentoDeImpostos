
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Tex payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(name, anualIncome, gastosSaude));
			}
			else {
				System.out.print("Number of employees: ");
				int numFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(name, anualIncome, numFuncionarios));
			}
		}
		System.out.println();
		double impostoTotal=0;
		System.out.println("TAXES PAID:");
		for(Pessoa pessoa : list) {
			System.out.println(pessoa.getNome() + ": R$ " + String.format("%.2f", pessoa.calcImposto()));
			impostoTotal += pessoa.calcImposto();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: R$ " + String.format("%.2f", impostoTotal));
		
		sc.close();

	}

}
