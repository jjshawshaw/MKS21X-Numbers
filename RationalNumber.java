public class RationalNumber extends RealNumber
{
  private int nume, deno;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */

  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      this.nume = 0;
      this.deno = 1;
    }
    else{
    this.nume = nume;
    this.deno = deno;
    reduce();
  }
  }

  public double getValue(){
    return  ((double) nume) / deno;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return nume;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return deno;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(deno, nume);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return nume == other.getNumerator() && deno == other.getDenominator();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (deno == 1) return "" + nume;
    if (nume == 0) return "0";
    return nume + "/" + deno;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    int minAB = Math.min(Math.abs(a), Math.abs(b));
    int gcd = 1;
    if (minAB != 0) {
      for (int i = 1; i <= minAB; i++){
        if (a % i == 0 && b % i == 0) gcd = i;
      }
    }
    return gcd;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if (deno < 0) {
      nume = -nume;
      deno = -deno;
    }
    int gcd = gcd(nume, deno);
    nume /= gcd;
    deno /= gcd;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(nume * other.getNumerator(), deno * other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber(nume * other.getDenominator() + deno * other.getNumerator(), deno * other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber(nume * other.getDenominator() - deno * other.getNumerator(), deno * other.getDenominator());
  }
}
