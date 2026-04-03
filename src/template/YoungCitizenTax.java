package template;

public class YoungCitizenTax implements TaxCalculator
{
    @Override
    public int calculateTax(int income) {
        return (income * 10) / 100;//tax calculation with 10 percent tax for younger citizens
    }
}
