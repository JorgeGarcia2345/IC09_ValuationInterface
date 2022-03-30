import java.util.Objects;

public class Bond extends Security implements Comparable<Security>, Valuation
{
    private double mPrinciple;
    private double mCouponRate;
    private double mHoldingPeriod;


    public Bond(String ISIN, String issuer, double principle, double couponRate, double holdingPeriod) {
        super(ISIN, issuer);
        mPrinciple = principle;
        mCouponRate = couponRate;
        mHoldingPeriod = holdingPeriod;
    }

    public double getPrinciple() {
        return mPrinciple;
    }

    public void setPrinciple(double principle) {
        mPrinciple = principle;
    }

    public double getCouponRate() {
        return mCouponRate;
    }

    public void setCouponRate(double couponRate) {
        mCouponRate = couponRate;
    }

    public double getHoldingPeriod() {
        return mHoldingPeriod;
    }

    public void setHoldingPeriod(double holdingPeriod) {
        mHoldingPeriod = holdingPeriod;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bond bond = (Bond) o;
        return Double.compare(bond.mPrinciple, mPrinciple) == 0 && Double.compare(bond.mCouponRate, mCouponRate) == 0 && Double.compare(bond.mHoldingPeriod, mHoldingPeriod) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mPrinciple, mCouponRate, mHoldingPeriod);
    }

    @Override
    public String toString() {
        return "CommonStock [" +
                mISIN + ", " +
                mIssuer + ", " +
                "Holding Period " + mHoldingPeriod +
                "Principle " + mPrinciple +
                "Coupon Rate: " + mCouponRate +
                "Total return: " + currency.format(totalReturn()) + ", " +
                "Percent return: " + twoDP.format(percentReturn()) + "%]";
    }

    @Override
    public double totalReturn() {
        return mPrinciple * mCouponRate * mHoldingPeriod;
    }

    @Override
    public double percentReturn() {
        return 100 * mCouponRate * mHoldingPeriod;
    }

    @Override
    public int compareTo(Security o) {
        int superComp = super.compareTo(o);
        if (superComp != 0)
            return superComp;
        // compare on couponRate
        if(o instanceof Bond) {
            Bond other = (Bond) o;
            int couponRateComp = Double.compare(this.mCouponRate, other.mCouponRate);
            if(couponRateComp != 0)
                return couponRateComp;
        }
        return this.getClass().getCanonicalName().compareToIgnoreCase(o.getClass().getCanonicalName());
    }

}
