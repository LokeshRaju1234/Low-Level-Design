package template;

public class SeniorCitizenTax implements TaxCalculator
{
    @Override
    public int calculateTax(int income) {
        return (income * 20) / 100; //tax calculation with 20 percent tax for senior citizens
    }
}
