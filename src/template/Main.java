package template;

public class Main
{
    public static void main(String[] args)
    {
        //calculating tax for younger citizens
        TaxCalculator youngCitizenTax = new YoungCitizenTax();
        int youngTax = youngCitizenTax.calculateTax(2000000);
        System.out.println(2000000 - youngTax);

        //calculating tax for senior citizens
        TaxCalculator seniorCitizen = new SeniorCitizenTax();
        int seniorTax = seniorCitizen.calculateTax(3000000);
        System.out.println(3000000 - seniorTax);
    }
}
