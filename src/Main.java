import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        // things invested in, security
        // bonds / common stock

        // bonds = sharing of debt, your loaning money and they will give you money back @ fixed interest
        // common stock = share in company

        // ISIN international Serial ID Number

        List<Security> portfolio = new ArrayList<>();
        portfolio.add(new CommonStock("ISIN: 123457", "Apple, Inc.", 100, 100.0, 134.89));

        System.out.println("\n~~~~UNSORTED~~~~");
        for(Security s : portfolio)
            System.out.println(s);

        Collections.sort(portfolio);

        System.out.println("~~~SORTED~~~");
        for(Security s : portfolio)
            System.out.println(s);

    }
}
