import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

// Comparable, what are we comparing against!
// Previous needed a compareTo(Obj o)
// only concrete need to handle the comparable

public abstract class Security implements Comparable<Security>, Valuation
{
    protected String mISIN;
    protected String mIssuer;

    protected NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected DecimalFormat twoDP = new DecimalFormat("0.00");

    protected Security(String ISIN, String issuer) {
        mISIN = ISIN;
        mIssuer = issuer;
    }

    public String getISIN() {
        return mISIN;
    }

    public String getIssuer() {
        return mIssuer;
    }

    public void setIssuer(String issuer) {
        mIssuer = issuer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(mISIN, security.mISIN) && Objects.equals(mIssuer, security.mIssuer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mISIN, mIssuer);
    }


    @Override
    public int compareTo(Security other) {
        int classComp = this.getClass().getCanonicalName().compareToIgnoreCase(other.getClass().getCanonicalName());
        if(classComp != 0)
            return classComp;
        // Compare 1st on ISIN
        int isinComp = this.mISIN.compareToIgnoreCase(other.mISIN);
        if(isinComp != 0)
            return isinComp;
        // Pretend compare next on Issuer (String)
        return this.mIssuer.compareToIgnoreCase(other.mIssuer);
    }
}


/*

code style - java code generator
 */